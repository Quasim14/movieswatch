package com.movieswatch.forms;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import com.movieswatch.model.Codepostaux;
import com.movieswatch.model.Role;
import com.movieswatch.model.Utilisateur;
import com.movieswatch.query.EntityFinderImpl;
import com.movieswatch.service.FormService;

public class EditProfileModel {
	private static Logger log = Logger.getLogger(RegisterFormsModel.class);
	FormService formService = new FormService();
	EntityFinderImpl<Codepostaux> entityFinderImplCodePostal = new EntityFinderImpl<>();
	EntityFinderImpl<Utilisateur> entityFinderImplUser = new EntityFinderImpl<>();
	EntityFinderImpl<Role> entityFinderImplRole = new EntityFinderImpl<>();

	private String resultat;
	private Map<String, String> erreurs = new HashMap<String, String>();

	public String getResultat() {
	    return resultat;
	}

	public Map<String, String> getErreurs() {
	    return erreurs;
	}

	public Utilisateur editUser( HttpServletRequest request ) {

		//Recupération des donnée du formulaire d'inscription (registerForms.jsp)		
		String id =request.getParameter("idUtilisateur");
		int result = Integer.parseInt(id);
		String lastName =request.getParameter("nom");
		String firstName =request.getParameter("prenom");
		String adress =request.getParameter("adresseRue");
		String mobile =request.getParameter("telephone");
	    String email = request.getParameter("email");
	    String password = request.getParameter("motdepasse");
	    String confirmation = request.getParameter("confirmation");
	   
	  //Initialisation des nouvels valeurs de l'utilisateur	
	    Utilisateur user = entityFinderImplUser.findOne( new Utilisateur(),result );
	    user.setNumMobile(mobile);
	    user.setPrenom(firstName);
	    user.setADrue(adress);
	    user.setUtilisateur(null);

	    // Control des données requise pour la base de donnée.
	    try {
	        formService.validationEntry( lastName );
	    } catch ( Exception e ) {
	    	erreurs.put("nom",e.getMessage());
	    }
	    user.setNom( lastName );

	    try {
	        formService.validationEntry(email);
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
	        resultat = "Succes de l'inscription.";
	        entityFinderImplUser.edit(user,result);
	    } else {
	    	log.debug("Une erreur c'est produite lors de la validation");
	        resultat = "echec de l'inscription.";
	    }
	    return user;
	}
}

