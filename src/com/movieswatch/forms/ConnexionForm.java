package com.movieswatch.forms;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.movieswatch.model.Utilisateur;
import com.movieswatch.query.EntityFinderImpl;


public final class ConnexionForm {
	
	private EntityFinderImpl<Utilisateur> entityFinderImplUtilisateur = new EntityFinderImpl<>();
    private Map<String, String> erreurs      = new HashMap<String, String>();


    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public Utilisateur connecterUtilisateur( HttpServletRequest request ) {
        /* Récupération des champs du formulaire */
        String email = request.getParameter("email");
        String motDePasse = request.getParameter("motdepasse");

        Utilisateur utilisateur = new Utilisateur();
        
        Map<String, String> param = new HashMap<String, String>();
        param.put("email", email);
        param.put("password",motDePasse);
        Utilisateur user= entityFinderImplUtilisateur.findOneByNamedQuery("Utilisateur.connexion", utilisateur, param);
        if(user !=null) {
        	utilisateur = user;
        	
        }else {
        	erreurs.put("user", "Votre login ou votre mot de passe est mauvais");
        }

        return utilisateur;
    }
}