package com.movieswatch.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.movieswatch.model.Film;
import com.movieswatch.model.FilmsGenre;
import com.movieswatch.model.FilmsPay;
import com.movieswatch.model.FilmsPersonnage;
import com.movieswatch.model.FilmsPersonne;
import com.movieswatch.query.EntityFinderImpl;

/**
 * Servlet implementation class FilmListe
 */
@WebServlet("/accesrestreint/filmList")
public class FilmList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EntityFinderImpl<Film> film = new EntityFinderImpl<Film>();

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FilmList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		List<Film> filmList = film.findByNamedQuery("Film.findAll", new Film(), null);
		
		request.setAttribute("filmList", filmList);
		this.getServletContext().getRequestDispatcher("/WEB-INF/filmsList.jsp").forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Film> filmList = film.findByNamedQuery("Film.findAll", new Film(), null);
		List<Film> filmListToSend= new ArrayList<>();
		
		String type= request.getParameter("type");
		String keyword= request.getParameter("keyword");
		
		switch(type) {
			case "personne": 
				for(Film film: filmList) {
					for(FilmsPersonne fp : film.getFilmsPersonnes()) {
						if(fp.getPersonne().getNom().toLowerCase().contains(keyword.toLowerCase()) 
								|| fp.getPersonne().getPrenom().toLowerCase().contains(keyword.toLowerCase()))
							filmListToSend.add(film);
					}
				}
				break;
			
			case "titre" : 
				for(Film film: filmList) {
					if(film.getTitreOriginal().toLowerCase().contains(keyword.toLowerCase()))
						filmListToSend.add(film);
				}
				break;
			
			case "annee" : 
				for(Film film: filmList) {
					if(film.getAnneeProduction().toLowerCase().contains(keyword.toLowerCase()))
						filmListToSend.add(film);
				}
				break;
				
			case "genre" :
				for(Film film: filmList) {
					for(FilmsGenre fg: film.getFilmsGenres()) {
						if(fg.getGenre().getNom().toLowerCase().contains(keyword.toLowerCase()))
							filmListToSend.add(film);
					}
				}
				break;
			
			case "pays":
				for(Film film: filmList) {
					for(FilmsPay fp: film.getFilmsPays()) {
						if(fp.getPay().getFormeCourte().toLowerCase().contains(keyword.toLowerCase()) 
								|| fp.getPay().getCodePays().toLowerCase().contains(keyword.toLowerCase())
								|| fp.getPay().getNationalite().toLowerCase().contains(keyword.toLowerCase()))
							filmListToSend.add(film);
					}
				}
				break;
				
			case "csa" : 
				for(Film film: filmList) {
					if(film.getCsa().getAgeMin().toLowerCase().contains(keyword.toLowerCase()))
						filmListToSend.add(film);
				}
				break;
			
			case "personnage":
				for(Film film: filmList) {
					for(FilmsPersonnage fp : film.getFilmsPersonnages()) {
						if(fp.getPersonnage().getNom().toLowerCase().contains(keyword.toLowerCase()) 
								|| fp.getPersonnage().getPrenom().toLowerCase().contains(keyword.toLowerCase()))
							filmListToSend.add(film);
					}
				}
				break;
		}
		
		request.setAttribute("filmList", filmListToSend);
		this.getServletContext().getRequestDispatcher("/WEB-INF/filmsList.jsp").forward( request, response );
	}

}
