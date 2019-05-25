package com.movieswatch.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.movieswatch.forms.EditProfile;
import com.movieswatch.model.Utilisateur;

/**
 * Servlet implementation class AffichageTest
 */
@WebServlet("accesrestreint/edituser")
public class EditUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		this.getServletContext().getRequestDispatcher("/WEB-INF/editUser.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session= request.getSession();
		EditProfile editProfile = new EditProfile ();
		Utilisateur utilisateur = new Utilisateur();
		
		utilisateur= editProfile.mergeUtilisateur(request);
		
		request.setAttribute("utilisateur",utilisateur);
		
		if(editProfile.getErreurs().isEmpty()) {
			session.setAttribute("currentUser", utilisateur);
			response.sendRedirect(request.getContextPath() +"accesrestreint/edituser");

		}else {
			request.setAttribute("editProfile", editProfile);
			doGet(request,response);
		}			
		
	}

}
