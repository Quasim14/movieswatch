package com.movieswatch.servlets;

import java.io.IOException;

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
import com.movieswatch.query.EntityFinderImpl;

/**
 * Servlet implementation class PayPanier
 */
@WebServlet("/accesrestreint/paypanier")
public class PayPanier extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EntityFinderImpl<Commande> efic = new EntityFinderImpl<Commande>();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PayPanier() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idPanier= Integer.valueOf(request.getParameter("idpanier"));
		updatePanier(idPanier);
		
		response.sendRedirect(request.getContextPath()+ "/accesrestreint/mescommandes");
		
	}


	private void updatePanier(int idpanier) {
		EntityManager em = EMF.getEM();
		try {
			EntityTransaction transac= em.getTransaction();
			transac.begin();
		
			Query query = em.createQuery("select c from Commande c where c.idCommande=:id");
			query.setParameter("id", idpanier);
			
			Commande panier= (Commande) query.getSingleResult();
			panier.setStatus("paye");
			
			em.flush();
			transac.commit();
		}
		finally {
			em.clear();
			em.close();
		}
	}
}
