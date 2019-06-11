package com.movieswatch.service;

import java.util.List;
import com.movieswatch.model.Utilisateur;
import com.movieswatch.query.EntityFinderImpl;

/**
 * 
 * @author Quasim Bita
 * 
 */
public class FormService {
	private EntityFinderImpl<Utilisateur> entityFinderImplUser = new EntityFinderImpl<>();

	/*
	 * Control email
	 * 1.Permet la v�rification de la pr�sence et du format de l'email entrer
	 * par l'utilisateur.
	 * 2.Permet de verifier si l'adresse email entr�e par l'utilisateur,
	 *  n'est pas d�j� existante en base de donn�es.
	 * 
	 */
	public void validationEmail( String email ,String pNamedQuery) throws Exception {
		
	    if ( email != null ) {
	    	//Control la pr�sence et le format et entrer par l'utilisateur
	        if ( !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
	            throw new Exception( "Merci de saisir une adresse mail valide." );
	        }
	        // Control si l'email n'est pas d�j� inscrit en base de donn�es
	        List<Utilisateur> users = entityFinderImplUser.findByNamedQuery(pNamedQuery, new Utilisateur(), null);
			for(Utilisateur u: users) {
				if(email.equals(u.getEmail())) {
					throw new Exception( "email deja existante" );
				}
			}
	    }else {
	    	throw new Exception( "Merci de saisir une adresse mail." );
	    }
	}
	
	public void validationEmail( String email ) throws Exception {
	    if ( email != null ) {
	        if ( !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
	            throw new Exception( "Merci de saisir une adresse mail valide." );
	        }
	    } else {
	        throw new Exception( "Merci de saisir une adresse mail." );
	    }
	}
	
	/*
	 * Control du mot de passe
	 * Permet de v�rifier si le mot de passe contient au minimum 3 lettres
	 * et que le mot de passe et la confirmation du mot de passe soit identique. 
	 */
	public void validationPassword( String pPassword, String confirmation ) throws Exception {
	    if ( pPassword != null && confirmation != null ) {
	        if ( !pPassword.equals( confirmation ) ) {
	        	throw new Exception( "Les mots de passe entr�s sont diff�rents, merci de les saisir � nouveau." );
	        }else if ( pPassword.length() < 3 ) {
	            throw new Exception( "Les mots de passe doivent contenir au moins 3 caract�res." );
	        }
	    } else {
	        throw new Exception( "Merci de saisir et confirmer votre mot de passe." );
	    }
	}
	
	/*
	 * Control du nombre de saisie
	 * Permet de v�rifier si la saisiecontient au minimum 3 lettres. 
	 */
	public void validationEntry( String pEntry ) throws Exception {
	    if ( pEntry != null && pEntry.length() < 3 ) {
	        throw new Exception( "Ce champ doit contenir au moins 3 caract�res." );
	    }
	}

	
	//Getter et Setter
	public EntityFinderImpl<Utilisateur> getEntityFinderImplUser() {
		return entityFinderImplUser;
	}

	public void setEntityFinderImplUser(EntityFinderImpl<Utilisateur> entityFinderImplUser) {
		this.entityFinderImplUser = entityFinderImplUser;
	}
	
	

}
