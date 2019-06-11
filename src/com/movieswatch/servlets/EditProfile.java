package com.movieswatch.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.movieswatch.forms.EditProfileModel;
import com.movieswatch.model.Utilisateur;

/**
 * Servlet implementation class EditProfile
 */
@WebServlet("/accesrestreint/edituser")
public class EditProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditProfile() {
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session= request.getSession();
		EditProfileModel editProfileModel = new EditProfileModel ();
		Utilisateur utilisateur = new Utilisateur();

		utilisateur= editProfileModel.editUser(request);

		request.setAttribute("utilisateur",utilisateur);

		if(editProfileModel.getErreurs().isEmpty()) {
			session.setAttribute("currentUser", utilisateur);
			response.sendRedirect(request.getContextPath() +"/accesrestreint/edituser");

		}else {
			request.setAttribute("editProfile", editProfileModel);
			doGet(request,response);
		}

	}

}
