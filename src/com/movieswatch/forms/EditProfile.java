package com.movieswatch.forms;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;
import javax.websocket.Session;

import org.apache.log4j.Logger;

import com.movieswatch.connection.EMF;
import com.movieswatch.model.Codepostaux;
import com.movieswatch.model.Role;
import com.movieswatch.model.Utilisateur;
import com.movieswatch.query.EntityFinderImpl;

public class EditProfile {
	private static Logger log = Logger.getLogger(RegisterFormsControl.class);
	
	EntityFinderImpl<Codepostaux> entityFinderImplCodePostal = new EntityFinderImpl<>();
	EntityFinderImpl<Utilisateur> entityFinderImplUtilisateur = new EntityFinderImpl<>();
	EntityFinderImpl<Role> entityFinderImplRole = new EntityFinderImpl<>();
	//Utilisateur utilisateur = new Utilisateur();
	
	
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
	
	public Utilisateur mergeUtilisateur( HttpServletRequest request ) {

		String id =request.getParameter("idUtilisateur");
		int result = Integer.parseInt(id);
		String nom =request.getParameter("nom");
		String prenom =request.getParameter("prenom");
		String adresseRue =request.getParameter("adresseRue");
		String telephone =request.getParameter("telephone");
	    String email = request.getParameter("email");
	    String motdepasse = request.getParameter("motdepasse");
	    String confirmation = request.getParameter("confirmation");
	    log.debug("L'ID est  " +result);
	    Map<String, String> parametre = new HashMap<String, String>(); 
	    
	    
        EntityManager entitymanager =EMF.getEM();
        entitymanager.getTransaction( ).begin( );
       
        Utilisateur utilisateur = entityFinderImplUtilisateur.findOne( new Utilisateur(),result );   
	    
	    
	    utilisateur.setNumMobile(telephone);   
	    utilisateur.setPrenom(prenom);
	    utilisateur.setADrue(adresseRue);
	    utilisateur.setUtilisateur(null);
	    



	    try {
	        validationEmail( email );
	    } catch ( Exception e ) {
	        erreurs.put("email",e.getMessage());
	    }
	    utilisateur.setEmail( email );
	    log.debug("L'email est  " + utilisateur.getEmail());
	    
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
	    
	    
	    log.debug("L'ID est  " +utilisateur.getIdUtilisateur());
	    log.debug("Le nom est " + utilisateur.getNom()); 
	    log.debug("Le prenom est " + utilisateur.getPrenom()); 
	    //log.debug("La date est  " + utilisateur.getDateNaissance());
	    //log.debug("La code postal est  " + utilisateur.getCodepostaux());
	    
	    
	    
	    
	    if ( erreurs.isEmpty() ) {
	    	log.debug("pas erreur");
	        resultat = "Succès de l'inscription.";
	        entityFinderImplUtilisateur.edit(utilisateur,result);
	    } else {
	    	log.debug("erreur");
	        resultat = "échec de l'inscription.";
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
	            throw new Exception( "Les mots de passe entrées sont différents, merci de les saisir à nouveau." );
	        } else if ( motDePasse.length() < 3 ) {
	            throw new Exception( "Les mots de passe doivent contenir au moins 3 caractères." );
	        }
	    } else {
	        throw new Exception( "Merci de saisir et confirmer votre mot de passe." );
	    }
	}

	private void validationNom( String nom ) throws Exception {
	    if ( nom != null && nom.length() < 3 ) {
	        throw new Exception( "Le nom d'utilisateur doit contenir au moins 3 caractï¿½res." );
	    }
	}


}
