package com.movieswatch.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the commandes_films database table.
 * 
 */
@Entity
@Table(name="commandes_films")
@NamedQueries({@NamedQuery(name="CommandesFilm.findAll", query="SELECT c FROM CommandesFilm c"),
	@NamedQuery(name="CommandesFilm.getFilm", query="SELECT c from CommandesFilm c where c.film.idFilm= :idfilm and c.commande.idCommande= :idpanier")})
public class CommandesFilm implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_COMMANDE_FILM", unique=true, nullable=false)
	private int idCommandeFilm;


	//bi-directional many-to-one association to Commande
	@ManyToOne
	@JoinColumn(name="ID_COMMANDE", nullable=false)
	private Commande commande;

	//bi-directional many-to-one association to Film
	@ManyToOne
	@JoinColumn(name="ID_FILM", nullable=false)
	private Film film;

	public CommandesFilm() {
	}

	public int getIdCommandeFilm() {
		return this.idCommandeFilm;
	}

	public void setIdCommandeFilm(int idCommandeFilm) {
		this.idCommandeFilm = idCommandeFilm;
	}

	public Commande getCommande() {
		return this.commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public Film getFilm() {
		return this.film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

}