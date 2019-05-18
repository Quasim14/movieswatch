package com.movieswatch.servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.movieswatch.forms.ConnexionForm;
import com.movieswatch.model.Utilisateur;


@WebServlet("/connexion")
public class Connexion extends HttpServlet {

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
      
    		this.getServletContext().getRequestDispatcher("/WEB-INF/connexion.jsp").forward( request, response );
    }

    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
    	HttpSession session = request.getSession();
    	ConnexionForm form = new ConnexionForm();

    	Utilisateur utilisateur = form.connecterUtilisateur( request );
     
    	request.setAttribute( "utilisateur", utilisateur );
    	if ( form.getErreurs().isEmpty() ) {
    		session.setAttribute( "currentUser", utilisateur );
    		response.sendRedirect(request.getContextPath() + "/accesrestreint/accueil");
    	} else {
    		session.setAttribute( "currentUser", null );
    		request.setAttribute( "form", form );
    		doGet(request,response);
    	}
    	
    }
    
}
