package com.movieswatch.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import com.movieswatch.connection.EMF;
import com.movieswatch.model.Commande;
import com.movieswatch.model.CommandesFilm;
import com.movieswatch.model.Facture;
import com.movieswatch.model.Utilisateur;

/**
 * 
 * @author Quasim Bita
 * 
 */

/**
 * fonction statique evite de devoir instancier � chaque fois pour appeler la fonction
 * 
 *  */

public class UtilisateurService {
	
	
	public static List<Utilisateur> getUtilistateurs(){

		return EMF.getEM().createNamedQuery("Utilisateur.findAll", Utilisateur.class)
				.getResultList();	
	}
	
	public static Utilisateur findByEmail(String email){
		
		return EMF.getEM().createNamedQuery("Utilisateur.findByEmail", Utilisateur.class)
				.setParameter("email", email)
				.getSingleResult();		
	}
	
	/**
	 * fonction statique evite de devoir instancier a chaque fois pour appeler la fonction
	 * 
	 *  */	
	public static void remove(Utilisateur utilisateur) {

		EntityManager em = EMF.getEM();
		EntityTransaction transac= em.getTransaction();
		
		try {					
			transac.begin();			
			if(utilisateur!=null)
				em.remove(em.merge(utilisateur));
			transac.commit();
		}
		finally {
			if(transac.isActive())
				transac.rollback();
			em.clear();
			em.close();
		}
				
	}
	
}
