package com.movieswatch.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the abonnements_commandes database table.
 * 
 */
@Entity
@Table(name="abonnements_commandes")
@NamedQuery(name="AbonnementsCommande.findAll", query="SELECT a FROM AbonnementsCommande a")
public class AbonnementsCommande implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_ABONNEMENT_COMMANDE", unique=true, nullable=false)
	private int idAbonnementCommande;

	//bi-directional many-to-one association to Abonnement
	@ManyToOne
	@JoinColumn(name="ID_ABONNEMENT", nullable=false)
	private Abonnement abonnement;

	//bi-directional many-to-one association to Commande
	@ManyToOne
	@JoinColumn(name="ID_COMMANDE", nullable=false)
	private Commande commande;

	public AbonnementsCommande() {
	}

	public int getIdAbonnementCommande() {
		return this.idAbonnementCommande;
	}

	public void setIdAbonnementCommande(int idAbonnementCommande) {
		this.idAbonnementCommande = idAbonnementCommande;
	}

	public Abonnement getAbonnement() {
		return this.abonnement;
	}

	public void setAbonnement(Abonnement abonnement) {
		this.abonnement = abonnement;
	}

	public Commande getCommande() {
		return this.commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

}