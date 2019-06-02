package com.movieswatch.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.movieswatch.connection.EMF;
import com.movieswatch.forms.FilmForm;
import com.movieswatch.model.Codepostaux;
import com.movieswatch.model.Film;
import com.movieswatch.query.EntityFinderImpl;

/**
 * Servlet implementation class FilmAdmin
 */
@WebServlet("/films")
public class Films extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	// Log4j
	private static Logger log = Logger.getLogger(Films.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Films() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		EntityFinderImpl<Film> efFilm = new EntityFinderImpl<>();
		
		List<Film> listeFilm = efFilm.findByNamedQuery("Film.findAll", new Film(), null);
		
		request.getServletContext().setAttribute("listeFilm", listeFilm );
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/films.jsp").forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				
		doGet(request, response);
	}
}
