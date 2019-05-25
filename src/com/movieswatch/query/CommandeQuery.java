package com.movieswatch.query;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.movieswatch.connection.EMF;
import com.movieswatch.model.Commande;
import com.movieswatch.model.Facture;

public class CommandeQuery {

	public void updatePanier(int idpanier) {
		EntityManager em = EMF.getEM();
		try {
			EntityTransaction transac= em.getTransaction();
			transac.begin();
		
			Query query = em.createQuery("select c from Commande c where c.idCommande=:id");
			query.setParameter("id", idpanier);
			
			Commande panier= (Commande) query.getSingleResult();
			Facture f= new Facture();
			f.setDateCommande(Date.valueOf(LocalDate.now()));
			panier.setFacture(f);
			panier.setStatus("paye");
			
			em.flush();
			transac.commit();
		}
		finally {
			em.clear();
			em.close();
		}
	}
}
