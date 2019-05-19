package com.movieswatch.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.movieswatch.model.Commande;
import com.movieswatch.model.CommandesFilm;
import com.movieswatch.model.Film;
import com.movieswatch.query.EntityFinderImpl;

/**
 * Servlet implementation class DetailsCommande
 */
@WebServlet("/accesrestreint/detailscommande")
public class DetailsCommande extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DetailsCommande() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityFinderImpl<Commande> efic = new EntityFinderImpl<>();
		List<Film> films= new ArrayList<>();
		int idcommande= Integer.valueOf(request.getParameter("idcommande"));
		
		Commande commande= efic.findOne(new Commande(), idcommande);
		for(CommandesFilm cf: commande.getCommandesFilms()) 
		{
			films.add(cf.getFilm());
		}
				
		request.setAttribute("films", films);
		this.getServletContext().getRequestDispatcher("/WEB-INF/detailscommande.jsp").forward( request, response );
	}


}
