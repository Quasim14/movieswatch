package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the abonnements database table.
 * 
 */
@Entity
@Table(name="abonnements")
@NamedQuery(name="Abonnement.findAll", query="SELECT a FROM Abonnement a")
public class Abonnement implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_ABONNEMENT", unique=true, nullable=false)
	private int idAbonnement;

	@Column(length=45)
	private String intitule;

	private int tarif;

	//bi-directional many-to-one association to AbonnementsCommande
	@OneToMany(mappedBy="abonnement")
	private List<AbonnementsCommande> abonnementsCommandes;

	public Abonnement() {
	}

	public int getIdAbonnement() {
		return this.idAbonnement;
	}

	public void setIdAbonnement(int idAbonnement) {
		this.idAbonnement = idAbonnement;
	}

	public String getIntitule() {
		return this.intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public int getTarif() {
		return this.tarif;
	}

	public void setTarif(int tarif) {
		this.tarif = tarif;
	}

	public List<AbonnementsCommande> getAbonnementsCommandes() {
		return this.abonnementsCommandes;
	}

	public void setAbonnementsCommandes(List<AbonnementsCommande> abonnementsCommandes) {
		this.abonnementsCommandes = abonnementsCommandes;
	}

	public AbonnementsCommande addAbonnementsCommande(AbonnementsCommande abonnementsCommande) {
		getAbonnementsCommandes().add(abonnementsCommande);
		abonnementsCommande.setAbonnement(this);

		return abonnementsCommande;
	}

	public AbonnementsCommande removeAbonnementsCommande(AbonnementsCommande abonnementsCommande) {
		getAbonnementsCommandes().remove(abonnementsCommande);
		abonnementsCommande.setAbonnement(null);

		return abonnementsCommande;
	}

}