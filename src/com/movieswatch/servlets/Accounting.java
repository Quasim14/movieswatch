package com.movieswatch.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.movieswatch.model.Commande;
import com.movieswatch.query.EntityFinderImpl;

/**
 * Servlet implementation class Accounting
 */

@WebServlet("/accounting")
public class Accounting extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Accounting() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityFinderImpl<Commande> etic= new EntityFinderImpl<>();
		List<Commande> commandes= etic.findByNamedQuery("Commande.findAll", new Commande(), null);
		
		request.setAttribute("commandes", commandes);
		this.getServletContext().getRequestDispatcher("/WEB-INF/accounting.jsp").forward( request, response );
	}

	
}
