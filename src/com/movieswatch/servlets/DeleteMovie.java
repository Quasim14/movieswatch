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

import com.movieswatch.model.Commande;
import com.movieswatch.model.CommandesFilm;
import com.movieswatch.query.EntityFinderImpl;

/**
 * Servlet implementation class DeleteMovie
 */
@WebServlet("/accesrestreint/deletemovie")
public class DeleteMovie extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EntityFinderImpl<Commande> efic = new EntityFinderImpl<Commande>();
	EntityFinderImpl<CommandesFilm> eficf = new EntityFinderImpl<CommandesFilm>();
	
    public DeleteMovie() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idFilm= Integer.valueOf(request.getParameter("idfilm"));
		int idPanier= Integer.valueOf(request.getParameter("idpanier"));
		CommandesFilm itemToRemove= new CommandesFilm();
		
		Commande panier= efic.findOne(new Commande(), idPanier);
		
		for(CommandesFilm cf : panier.getCommandesFilms()) {
			if(cf.getFilm().getIdFilm()== idFilm) {
				itemToRemove= cf;
				eficf.delete(cf, cf.getIdCommandeFilm());
			}
		}
		
		panier.removeCommandesFilm(itemToRemove);
		response.sendRedirect(request.getContextPath()+ "/accesrestreint/panier");
	}

}
