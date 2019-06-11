package com.movieswatch.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.movieswatch.connection.EMF;
import com.movieswatch.model.Utilisateur;
import com.movieswatch.query.EntityFinderImpl;

/*
 fonction statique evite de devoir instancier a chaque fois pour appeler la fonction */

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
	
	
	public static void remove(int id) {
		/*
		EntityManager em = EMF.getEM();
		
		try {		
		Utilisateur utilisateur = em.find(Utilisateur.class, id);
		CommandeService.removeAll(utilisateur.getCommandes());
		EntityTransaction transac= em.getTransaction();
		transac.begin();
		em.remove(em.merge(utilisateur));
		transac.commit();
		}
		finally {
			em.clear();
			em.close();
		}*/
		
		EntityManager em = EMF.getEM();
			
		Utilisateur utilisateur = em.find(Utilisateur.class, id);
		CommandeService.removeAll(utilisateur.getCommandes());
		remove(utilisateur);
	}
	
	public static void remove(Object  obj) {
			
			EntityManager em = EMF.getEM();
			
			try {		
			EntityTransaction transac= em.getTransaction();
			transac.begin();
			em.remove(em.merge(obj));
			transac.commit();
			}
			finally {
				em.clear();
				em.close();
			}
		}
		
	}
