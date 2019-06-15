package com.movieswatch.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.movieswatch.connection.EMF;
import com.movieswatch.model.Commande;
import com.movieswatch.model.CommandesFilm;
import com.movieswatch.model.Film;
import com.movieswatch.model.Utilisateur;
import com.movieswatch.query.EntityFinderImpl;

/**
 * Servlet implementation class Panier
 */

/**
 * 
 * @author Younes Moumtaz
 * 
 */
@WebServlet("/accesrestreint/panier")
public class Panier extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EntityFinderImpl<Commande> efic= new EntityFinderImpl<>();
	private Utilisateur currentUser= new Utilisateur();
	
    public Panier() {
        super();
        // TODO Auto-generated constructor stub
    }

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session= request.getSession();
		if(session.getAttribute("currentUser")!= null)
			currentUser= (Utilisateur) session.getAttribute("currentUser");
		
		Map param= new HashMap();
		param.put("id", currentUser.getIdUtilisateur());
		param.put("status","non-paye");
		
		Commande panier= efic.findOneByNamedQuery("Commande.getPanier", new Commande(), param);
		if(panier == null) {
			panier= new Commande();
			panier.setUtilisateur(currentUser);
			panier.setFacture(null);
			panier.setStatus("non-paye");
			EntityManager em = EMF.getEM();		
			EntityTransaction transac= em.getTransaction();
			try {
				transac.begin();
				em.persist(panier);
				transac.commit();
				}
			finally {
				if(transac.isActive()) {
					transac.rollback();
				}
				em.clear();
				em.close();
			}
		}
		
		request.setAttribute("commandeFilms", panier.getCommandesFilms());
		request.setAttribute("idpanier", panier.getIdCommande());
		this.getServletContext().getRequestDispatcher("/WEB-INF/panier.jsp").forward( request, response );
	}

}
