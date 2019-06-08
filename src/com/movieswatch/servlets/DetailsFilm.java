package com.movieswatch.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.movieswatch.model.Film;
import com.movieswatch.query.EntityFinderImpl;

/**
 * Servlet implementation class DetailsFilm
 */
@WebServlet("/accesrestreint/detailsfilm")
public class DetailsFilm extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private EntityFinderImpl<Film> efif= new EntityFinderImpl<Film>();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailsFilm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idFilm= Integer.valueOf(request.getParameter("idfilm"));
		
		Film f= efif.findOne(new Film(), idFilm);
		
		request.setAttribute("film", f);
		this.getServletContext().getRequestDispatcher("/WEB-INF/detailsfilm.jsp").forward(request, response);
	}

	

}
