package com.movieswatch.servlets;

import java.io.IOException;
import java.util.HashMap;
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
 * Servlet implementation class AddPanier
 */
@WebServlet("/accesrestreint/addpanier")
public class AddPanier extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private Utilisateur currentUser= new Utilisateur();
    private EntityFinderImpl<Commande> efic= new EntityFinderImpl<>();
    private EntityFinderImpl<Film> efif= new EntityFinderImpl<>();
    private EntityFinderImpl<CommandesFilm> eficf= new EntityFinderImpl<>();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPanier() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idFilm= Integer.valueOf(request.getParameter("idfilm"));
        Film f= efif.findOne(new Film(), idFilm);

        HttpSession session= request.getSession();
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
            try {
                EntityTransaction transac= em.getTransaction();
                transac.begin();
                em.persist(panier);
                transac.commit();
            }
            finally {
                em.clear();
                em.close();
            }
            panier= efic.findOneByNamedQuery("Commande.getPanier", new Commande(), param);
        }

        CommandesFilm cf= new CommandesFilm();
        cf.setCommande(panier);
        cf.setFilm(f);
        eficf.insert(cf);
        panier.addCommandesFilm(cf);

        response.sendRedirect(request.getContextPath()+"/accesrestreint/panier");
    }

}
