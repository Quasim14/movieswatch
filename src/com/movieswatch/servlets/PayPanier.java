package com.movieswatch.servlets;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.mail.MessagingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.movieswatch.connection.EMF;
import com.movieswatch.model.Commande;
import com.movieswatch.model.CommandesFilm;
import com.movieswatch.model.Facture;
import com.movieswatch.model.Utilisateur;
import com.movieswatch.query.EntityFinderImpl;
import com.movieswatch.service.JavaMailUtil;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * 
 * @author Younes Moumtaz & Souhaib Jemaiel
 * 
 */
@WebServlet("/accesrestreint/paypanier")
public class PayPanier extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EntityFinderImpl<Commande> efic = new EntityFinderImpl<Commande>();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PayPanier() {
        super();
        // TODO Auto-generated constructor stub
    }

	@SuppressWarnings("deprecation")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Paiement du panier: Partie Younes
		
		int idPanier= Integer.valueOf(request.getParameter("idpanier"));
		
		EntityManager em= EMF.getEM();
		EntityTransaction transac= em.getTransaction();
		Commande panier= (Commande) em.find(Commande.class, idPanier);
		Facture f= new Facture();

		try {
			transac.begin();
			
			if(panier!=null) {

				f.setDateCommande(Date.valueOf(LocalDate.now()));
				panier.setFacture(f);
				panier.setStatus("paye");
				em.merge(panier);
			}
	
			transac.commit();
		}
		finally {
			if(transac.isActive()) {
				transac.rollback();
			}
			em.clear();
			em.close();
		}
		
		//Envoi d'email avec fichier pdf joint: Partie Souhaib
		//generation de PDF ==> LE WORKSPACE DOIT ETRE LE DOSSIER PARENT DU PROJET
		HttpSession session= request.getSession();
		Utilisateur user = (Utilisateur) session.getAttribute("currentUser");
		try {
		Document document = new Document();
		PdfWriter.getInstance(document,new FileOutputStream(this.getServletContext().getRealPath("/")+"/facture/" +panier.getIdCommande()+".pdf"));
		document.open();
		document.add(new Paragraph("Nom : " + user.getNom() + " Prenom : " + user.getPrenom()));
		document.add(new Paragraph("Adresse mail :" + user.getEmail()));
		document.add(new Paragraph(user.getCodepostaux().getNomVille() + " " + user.getCodepostaux().getNumero()));
		document.add(new Paragraph("Commandes : "));
		for(CommandesFilm c: panier.getCommandesFilms()) {
			document.add(new Paragraph(c.getFilm().getTitreOriginal()));
		}

		document.add(new Paragraph("Date de commande : " + panier.getFacture().getDateCommande().toString()));
		document.close();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		//envoi d'email 
		try {
			JavaMailUtil.sendMail(user.getEmail(), panier, this.getServletContext().getRealPath("/")+"/facture/" +panier.getIdCommande()+".pdf");
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.sendRedirect(request.getContextPath()+ "/accesrestreint/mescommandes");
		
	}
}