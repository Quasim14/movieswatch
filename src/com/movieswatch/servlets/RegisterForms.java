package com.movieswatch.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.movieswatch.forms.RegisterFormsControl;
import com.movieswatch.model.Utilisateur;

/**
 * Servlet implementation class RegisterForms
 */
@WebServlet("/registerForms")
public class RegisterForms extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Utilisateur utilisateur = new Utilisateur();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterForms() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/registerForms.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RegisterFormsControl forms = new RegisterFormsControl();
		
		utilisateur= forms.inscrireUtilisateur(request);
		
		request.setAttribute("utilisateur",utilisateur);
		
		if(forms.getErreurs().isEmpty()) {
			response.sendRedirect(request.getContextPath() + "/connexion");

		}else {
			request.setAttribute("form", forms);
			doGet(request,response);
		}
	
	}

}
