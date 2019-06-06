package com.movieswatch.forms;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import com.movieswatch.model.Codepostaux;
import com.movieswatch.model.Role;
import com.movieswatch.model.Utilisateur;
import com.movieswatch.query.EntityFinderImpl;

public class RegisterFormsControl {
	EntityFinderImpl<Codepostaux> entityFinderImplCodePostal = new EntityFinderImpl<>();
	EntityFinderImpl<Utilisateur> entityFinderImplUtilisateur = new EntityFinderImpl<>();
	EntityFinderImpl<Role> entityFinderImplRole = new EntityFinderImpl<>();

	private String resultat;
	private Map<String, String> erreurs = new HashMap<String, String>();
	private static Codepostaux codePostal = new Codepostaux();
	private static Role role= new Role();

	public String getResultat() {
	    return resultat;
	}

	public Map<String, String> getErreurs() {
	    return erreurs;
	}

	public Utilisateur inscrireUtilisateur( HttpServletRequest request ) {
		String nom =request.getParameter("nom");
		String prenom =request.getParameter("prenom");
		String adresseRue =request.getParameter("adresseRue");
		String codepostal =request.getParameter("codepostal");
		String telephone =request.getParameter("telephone");
		String datenaissance =request.getParameter("datenaissance");
	    String email = request.getParameter("email");
	    String motdepasse = request.getParameter("motdepasse");
	    String confirmation = request.getParameter("confirmation");
	    String pRole = request.getParameter("role");

	    Map<String, String> parametre = new HashMap<String, String>();
	    parametre.put("numero",codepostal);
		role =  entityFinderImplRole.findOne(role, 1);
		
/*
	    switch(pRole) {
	    case "Utilisateur" : role =  entityFinderImplRole.findOne(role, 1);
			break;
	    case "Admin" : role =  entityFinderImplRole.findOne(role, 2);
	    	break;
	    case "Comptable" : role =  entityFinderImplRole.findOne(role, 3);
			break;
	    }
*/
	    Codepostaux codePostal =entityFinderImplCodePostal.findOneByNamedQuery("Codepostaux.findByNumber", new Codepostaux(), parametre) ;
	    Utilisateur utilisateur = new Utilisateur();
	    utilisateur.setRole(role);
	    //Faire methode de controle
	    utilisateur.setNumMobile(telephone);

	    LocalDate datenaiss = LocalDate.parse(datenaissance);
	    utilisateur.setDateNaissance(Date.valueOf(datenaiss));
	    utilisateur.setUtilisateur(null);

	    utilisateur.setPrenom(prenom);
	    utilisateur.setADrue(adresseRue);


	    if(codePostal != null) {
		    utilisateur.setCodepostaux(codePostal);

	    }else {
	    	erreurs.put("codepostal", "Erreur code postal");
	    }


	    try {
	        validationEmail( email );
	    } catch ( Exception e ) {
	        erreurs.put("email",e.getMessage());
	    }
	    utilisateur.setEmail( email );

	    try {
	        validationMotsDePasse( motdepasse, confirmation );
	    } catch ( Exception e ) {
	    	erreurs.put("motdepasse",e.getMessage());
	    }
	    utilisateur.setPasswd(motdepasse);

	    try {
	        validationNom( nom );
	    } catch ( Exception e ) {
	    	erreurs.put("nom",e.getMessage());
	    }
	    utilisateur.setNom( nom );

	    if ( erreurs.isEmpty() ) {
	        resultat = "Succ�s de l'inscription.";
	        entityFinderImplUtilisateur.insert(utilisateur);
	    } else {
	        resultat = "�chec de l'inscription.";
	    }

	    return utilisateur;

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

	private void validationMotsDePasse( String motDePasse, String confirmation ) throws Exception {
	    if ( motDePasse != null && confirmation != null ) {
	        if ( !motDePasse.equals( confirmation ) ) {
	            throw new Exception( "Les mots de passe entr�s sont diff�rents, merci de les saisir � nouveau." );
	        } else if ( motDePasse.length() < 3 ) {
	            throw new Exception( "Les mots de passe doivent contenir au moins 3 caract�res." );
	        }
	    } else {
	        throw new Exception( "Merci de saisir et confirmer votre mot de passe." );
	    }
	}

	private void validationNom( String nom ) throws Exception {
	    if ( nom != null && nom.length() < 3 ) {
	        throw new Exception( "Le nom d'utilisateur doit contenir au moins 3 caract�res." );
	    }
	}



}
