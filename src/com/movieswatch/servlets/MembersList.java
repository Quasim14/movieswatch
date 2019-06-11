package com.movieswatch.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.movieswatch.connection.EMF;
import com.movieswatch.model.Utilisateur;
import com.movieswatch.query.EntityFinderImpl;
import com.movieswatch.service.UtilisateurService;

/**
 * Servlet implementation class MembersList
 */
@WebServlet("/admin/membersList")
public class MembersList extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MembersList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//EntityFinderImpl<Utilisateur> utilisateur = new EntityFinderImpl<>();
		//List<Utilisateur> listUtilisateur = utilisateur.findByNamedQuery("Utilisateur.findAll",new Utilisateur(), null);
		

		List<Utilisateur> listUtilisateur = UtilisateurService.getUtilistateurs();
		request.setAttribute("listUtilisateur", listUtilisateur);
		
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/membersList.jsp").forward( request, response );

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
