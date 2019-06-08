package com.movieswatch.servlets;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.movieswatch.connection.EMF;
import com.movieswatch.model.Commande;
import com.movieswatch.model.CommandesFilm;
import com.movieswatch.model.Utilisateur;
import com.movieswatch.query.EntityFinderImpl;

/**
 * Servlet implementation class DeleteUser
 */
@WebServlet("/admin/deleteUser")
public class DeleteUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idUser= Integer.valueOf(request.getParameter("idutilisateur"));
		EntityFinderImpl<Utilisateur> emfi = new EntityFinderImpl();
		
		Utilisateur userToRemove = emfi.findOne(new Utilisateur(), idUser);
		
		EntityManager em= EMF.getEM();
		try {
			EntityTransaction transac= em.getTransaction();
			transac.begin();
			em.remove(em.merge(userToRemove));
			transac.commit();
		}
		finally {
			em.clear();
			em.close();
		}
		
		response.sendRedirect(request.getContextPath()+"/admin/memberList");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
