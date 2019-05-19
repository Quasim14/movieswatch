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
 * Servlet implementation class Panier
 */
@WebServlet("/accesrestreint/panier")
public class Panier extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Panier() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session= request.getSession();
		Utilisateur currentUser= new Utilisateur();
		if(session.getAttribute("currentUser")!= null)
			currentUser= (Utilisateur) session.getAttribute("currentUser");
		
		
		EntityFinderImpl<Commande> etic= new EntityFinderImpl<>();
		List<Film> films = new ArrayList<Film>();
		
		Map param= new HashMap();
		param.put("id", currentUser.getIdUtilisateur());
		param.put("status","non-paye");
		
		List<Commande> commandes= etic.findByNamedQuery("Commande.getPanier", new Commande(), param);
		
		for(Commande com: commandes) {
			for(CommandesFilm cf: com.getCommandesFilms()) 
			{
				films.add(cf.getFilm());
			}
		}
		
		request.setAttribute("films", films);
		request.setAttribute("idpanier", commandes.get(0).getIdCommande());
		this.getServletContext().getRequestDispatcher("/WEB-INF/panier.jsp").forward( request, response );
	}

}
