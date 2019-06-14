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

/*
 * fonction statique evite de devoir instancier à chaque fois pour appeler la fonction
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
	
	/*
	 * fonction statique evite de devoir instancier à chaque fois pour appeler la fonction
	 * 
	 *  */	
	public static void remove(Utilisateur utilisateur) {
		List<CommandesFilm> commandfilms= new ArrayList<>();
		List<Commande> cmds= new ArrayList<>();
		Facture facture = null;
		
		
		for(Commande commande : utilisateur.getCommandes()) {
			
			for(CommandesFilm cmdFilm : commande.getCommandesFilms()) {
				commandfilms.add(cmdFilm);
				}
			
			facture  = commande.getFacture();
			

			cmds.add(commande);
		}
		
		
		EntityManager em = EMF.getEM();
		EntityTransaction transac= em.getTransaction();
		
		try {		
			
			transac.begin();

			for(CommandesFilm cmdfilm: commandfilms) {
				em.remove(em.merge(cmdfilm));
			}
			
			for(Commande commande: cmds) {
				Commande cmd= em.find(Commande.class, commande.getIdCommande());
				if(cmd!=null)
					em.remove(em.merge(cmd));
			}
			if(facture!=null) {
				Facture factur= em.find(Facture.class, facture.getIdFacture());
				if(factur!=null)
					em.remove(factur);
			}
			
			Utilisateur user = em.find(Utilisateur.class, utilisateur.getIdUtilisateur());
			if(user!=null)
				em.remove(em.merge(user));			
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
