package com.movieswatch.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.movieswatch.connection.EMF;
import com.movieswatch.model.Commande;
import com.movieswatch.model.CommandesFilm;
import com.movieswatch.model.Facture;
import com.movieswatch.model.Utilisateur;

public class CommandeService {
	
	public static void remove(Facture facture) {
		
		if(facture == null)
				return;
		EntityManager em = EMF.getEM();
		
		try {		
		

		EntityTransaction transac = em.getTransaction();
		transac.begin();
		em.remove(em.merge(facture));
		transac.commit();
		}
		finally {
			em.clear();
			em.close();
		}
	}
	
	public static void remove(CommandesFilm cmdFilm) {
		EntityManager em = EMF.getEM();
		
		try {		
		

		EntityTransaction transac = em.getTransaction();
		transac.begin();
		em.remove(em.merge(cmdFilm));
		transac.commit();
		}
		finally {
			em.clear();
			em.close();
		}
	}
	// Delete les commandes
public static void remove(Commande commande) {
		
		// on recupère la facture pour la supprimer en dernier apres la commande
		Facture facture  = commande.getFacture();
		
		// On efface la table de liasion commande film
		for(CommandesFilm cmdFilm : commande.getCommandesFilms()) {
			remove(cmdFilm);
		}
		
		EntityManager em = EMF.getEM();
		try {
		//Suppression de la commande
		EntityTransaction transac = em.getTransaction();
		transac.begin();
		em.remove(em.merge(commande));
		transac.commit();
		
		//Suppression de la facture
		remove(facture);
		}
		finally {
			em.clear();
			em.close();
		}
		
		
	}


public static void removeAll(List<Commande> commandes) {
	
	for(Commande commande : commandes) {
		CommandeService.remove(commande);
	}
	
}



}
