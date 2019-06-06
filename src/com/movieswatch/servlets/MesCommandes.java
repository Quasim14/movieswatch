package com.movieswatch.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.movieswatch.model.Commande;
import com.movieswatch.model.CommandesFilm;
import com.movieswatch.model.Film;
import com.movieswatch.model.Utilisateur;
import com.movieswatch.query.EntityFinderImpl;

/**
 * Servlet implementation class MesCommandes
 */
@WebServlet("/accesrestreint/mescommandes")
public class MesCommandes extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Utilisateur currentUser= new Utilisateur();


    public MesCommandes() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session= request.getSession();
		if(session.getAttribute("currentUser")!= null)
			currentUser= (Utilisateur) session.getAttribute("currentUser");

		EntityFinderImpl<Commande> etic= new EntityFinderImpl<>();
		Map param= new HashMap();

		param.put("id", currentUser.getIdUtilisateur());
		param.put("status","paye");
		List<Commande> commandes= etic.findByNamedQuery("Commande.getPanier", new Commande(), param);

		request.setAttribute("commandes", commandes);
		this.getServletContext().getRequestDispatcher("/WEB-INF/mescommandes.jsp").forward( request, response );
	}


}
