package com.movieswatch.forms;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.http.HttpServletRequest;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import com.movieswatch.connection.EMF;
import com.movieswatch.model.Codepostaux;
import com.movieswatch.model.Role;
import com.movieswatch.model.Utilisateur;
import com.movieswatch.query.EntityFinderImpl;
import com.movieswatch.service.FormService;
/**
 * 
 * @author Quasim Bita
 * 
 */
public class RegisterFormsModel {
	FormService formService = new FormService();
	EntityFinderImpl<Codepostaux> entityFinderImplCodePostal = new EntityFinderImpl<>();
	EntityFinderImpl<Role> entityFinderImplRole = new EntityFinderImpl<>();

	private String resultat;
	private Map<String, String> erreurs = new HashMap<String, String>();
	private static Role role= new Role();

	public String getResultat() {
	    return resultat;
	}

	public Map<String, String> getErreurs() {
	    return erreurs;
	}
/*
 * Cette m�thode Permet la cr�ation d'un utilisateur
 */
	public Utilisateur createNewUser( HttpServletRequest request ) {
		Utilisateur user = new Utilisateur();
		Map<String, String> mapPostalCode = new HashMap<String, String>();
		
		//Recup�ration des donn�e du formulaire d'inscription (registerForms.jsp)		
		String lastName =request.getParameter("nom");
		String firstName =request.getParameter("prenom");
		String adress =request.getParameter("adresseRue");
		String postalCode =request.getParameter("codepostal");
		String ville= request.getParameter("nomVille");
		mapPostalCode.put("numero",postalCode);
		mapPostalCode.put("nomVille", ville);
		String mobile =request.getParameter("telephone");
		String birthDate =request.getParameter("datenaissance");
		LocalDate localDatebirthDate = LocalDate.parse(birthDate);
	    String email = request.getParameter("email");
	    String password = request.getParameter("motdepasse");
	    String confirmation = request.getParameter("confirmation");
	    String pRole = request.getParameter("role");
	
	    //Initialisation des valeurs de l'utilisateur	    
	          
	    /*
	     * POUR L'UTILISATEUR
	     * Lors de l'inscription fais par un simple utilisateur,
	     *  le role de l'utilisateur est initialiser � 1.
	     * Il y a trois role d�finis en Base de donn�e
	     * 1 = Utilisateur
	     * 2 = Admin
	     * 3 = Comptable 
	     */  
		role =  entityFinderImplRole.findOne(role, 1);
		
		/*
		 * POUR L'ADMINISTRATEUR
		 * Permet d'afficher le choix de role d'un utilisateur, 
		 * lors de l'inscription r�alis�e par un administrateur.
		 */
		if(pRole != null) {
		    switch(pRole) {
		    case "Utilisateur" : role =  entityFinderImplRole.findOne(role, 1);
				break;
		    case "Admin" : role =  entityFinderImplRole.findOne(role, 2);
		    	break;
		    case "Comptable" : role =  entityFinderImplRole.findOne(role, 3);
				break;
		    }
		}
		Codepostaux postalCodes =entityFinderImplCodePostal.findOneByNamedQuery("Codepostaux.findByNumber", new Codepostaux(), mapPostalCode) ;	
		user.setRole(role);
		user.setNumMobile(mobile);
		user.setDateNaissance(Date.valueOf(localDatebirthDate));
		user.setUtilisateur(null);
		user.setPrenom(firstName);
		user.setADrue(adress);

	    // Control des donn�es requise pour la base de donn�e.
	    try {
	    	formService.validationEntry(lastName);
	    } catch ( Exception e ) {
	    	erreurs.put("nom",e.getMessage());
	    }
	    user.setNom( lastName );
	    
	    
	    if(postalCodes != null) {
	    	user.setCodepostaux(postalCodes);

	    }else {
	    	erreurs.put("codepostal", "Erreur code postal");
	    }

	    try {
	        formService.validationEmail( email , "Utilisateur.findAll" );
	    } catch ( Exception e ) {
	        erreurs.put("email",e.getMessage());
	    }
	    user.setEmail( email );
	    
	    try {
	    	formService.validationPassword( password, confirmation );
	    } catch ( Exception e ) {
	    	erreurs.put("motdepasse",e.getMessage());
	    }
	    user.setPasswd(password);

	    if ( erreurs.isEmpty() ) {
	        resultat = "Succ�s de l'inscription.";
	        
	        EntityManager em= EMF.getEM();
			EntityTransaction transac= em.getTransaction();
			try {
				transac.begin();
				em.persist(user);
				transac.commit();
			}finally {
				if(transac.isActive()) {
					transac.rollback();
				}
				em.clear();
				em.close();
			}
	    } else {
	        resultat = "echec de l'inscription.";
	    }

	    return user;
	}


}
