package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the cartes_bancaire database table.
 * 
 */
@Entity
@Table(name="cartes_bancaire")
@NamedQuery(name="CartesBancaire.findAll", query="SELECT c FROM CartesBancaire c")
public class CartesBancaire implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CartesBancairePK id;

	@Column(name="code_securite", length=3)
	private String codeSecurite;

	@Temporal(TemporalType.DATE)
	private Date expirtation;

	@Column(name="numero_carte", length=45)
	private String numeroCarte;

	@Column(name="type_carte", length=1)
	private String typeCarte;

	//bi-directional many-to-one association to Utilisateur
	@ManyToOne
	@JoinColumn(name="utilisateurs_ID_UTILISATEUR", nullable=false, insertable=false, updatable=false)
	private Utilisateur utilisateur;

	public CartesBancaire() {
	}

	public CartesBancairePK getId() {
		return this.id;
	}

	public void setId(CartesBancairePK id) {
		this.id = id;
	}

	public String getCodeSecurite() {
		return this.codeSecurite;
	}

	public void setCodeSecurite(String codeSecurite) {
		this.codeSecurite = codeSecurite;
	}

	public Date getExpirtation() {
		return this.expirtation;
	}

	public void setExpirtation(Date expirtation) {
		this.expirtation = expirtation;
	}

	public String getNumeroCarte() {
		return this.numeroCarte;
	}

	public void setNumeroCarte(String numeroCarte) {
		this.numeroCarte = numeroCarte;
	}

	public String getTypeCarte() {
		return this.typeCarte;
	}

	public void setTypeCarte(String typeCarte) {
		this.typeCarte = typeCarte;
	}

	public Utilisateur getUtilisateur() {
		return this.utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

}