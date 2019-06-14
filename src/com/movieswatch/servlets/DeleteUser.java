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
import com.movieswatch.service.UtilisateurService;

/**
 * Servlet implementation class DeleteUser
 */
@WebServlet("/admin/deleteUser")
public class DeleteUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
    EntityFinderImpl<Utilisateur> userDB= new EntityFinderImpl<>();
	
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
		
		Utilisateur user= userDB.findOne(new Utilisateur(), idUser);
		UtilisateurService.remove(user);
		
		
		response.sendRedirect(request.getContextPath()+"/admin/membersList");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
