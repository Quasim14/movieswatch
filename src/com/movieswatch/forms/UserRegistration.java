package com.movieswatch.forms;
import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.movieswatch.query.EntityFinderImpl;

import com.movieswatch.model.Test;

public class UserRegistration {
	
	EntityFinderImpl<Test> entityFinderImplUtilisateur = new EntityFinderImpl<>();
	Test test = new Test();
	/*
	private Map<String, String> erreurs = new HashMap<String, String>();
	private String resultat;
	
*/
	public Test userValuesRegistration(HttpServletRequest request) {
		String nom = request.getParameter("nom");
		String email = request.getParameter("email");
		test.setNom(nom);
		test.setEmail(email);
		
		entityFinderImplUtilisateur.insert(test);
/*
	    try {
	        validationNom( nom );
	    } catch ( Exception e ) {
	    	erreurs.put("nom",e.getMessage());
	    }
	    test.setNom( nom );

	    if ( erreurs.isEmpty() ) {
	        resultat = "Succes de l'inscription.";
	        entityFinderImplUtilisateur.insert(test);
	    } else {
	        resultat ="Echec";
	    }
		
*/
		return test;
			
	}
	/*
	private void validationNom( String nom ) throws Exception {
	    if ( nom != null && nom.length() < 3 ) {
	        throw new Exception( "Le nom d'utilisateur doit contenir au moins 3 caract�res." );
	    }
	}
	
	private void validationEmail( String email ) throws Exception {
	    if ( email != null ) {
	        if ( !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
	            throw new Exception( "Merci de saisir une adresse mail valide." );
	        }
	    } else {
	        throw new Exception( "Merci de saisir une adresse mail." );
	    }
	}
	
*/
}
