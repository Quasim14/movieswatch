package com.movieswatch.servlets;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.movieswatch.connection.EMF;
import com.movieswatch.model.Commande;
import com.movieswatch.model.Facture;
import com.movieswatch.query.CommandeQuery;
import com.movieswatch.query.EntityFinderImpl;

/**
 * Servlet implementation class PayPanier
 */
@WebServlet("/accesrestreint/paypanier")
public class PayPanier extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EntityFinderImpl<Commande> efic = new EntityFinderImpl<Commande>();
	private CommandeQuery cq= new CommandeQuery();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PayPanier() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idPanier= Integer.valueOf(request.getParameter("idpanier"));
		cq.updatePanier(idPanier);
		
		response.sendRedirect(request.getContextPath()+ "/accesrestreint/mescommandes");
		
	}
}
