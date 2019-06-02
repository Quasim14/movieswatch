package com.movieswatch.forms;

import java.util.function.Function;

public final class Utils {

	private Utils() {}
	
	private boolean Validation(Function<String, Boolean> validator, String param) { 
		
			return validator.apply(param);
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
	
	private void validationNom( String nom ) throws Exception {

	    if ( nom != null && nom.length() < 3 ) {

	        throw new Exception( "Le nom d'utilisateur doit contenir au moins 3 caract�res." );
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
}
