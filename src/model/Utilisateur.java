package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the utilisateurs database table.
 * 
 */
@Entity
@Table(name="utilisateurs")
@NamedQuery(name="Utilisateur.findAll", query="SELECT u FROM Utilisateur u")
public class Utilisateur implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_UTILISATEUR", unique=true, nullable=false)
	private int idUtilisateur;

	@Column(length=45)
	private String ADnumero;

	@Column(length=255)
	private String ADrue;

	@Temporal(TemporalType.DATE)
	@Column(name="date_naissance", nullable=false)
	private Date dateNaissance;

	@Column(nullable=false, length=255)
	private String email;

	@Column(length=255)
	private String nom;

	@Column(name="num_mobile", nullable=false, length=45)
	private String numMobile;

	@Column(nullable=false, length=255)
	private String passwd;

	@Column(length=255)
	private String prenom;

	@Column(length=255)
	private String pseudo;

	//bi-directional many-to-one association to CartesBancaire
	@OneToMany(mappedBy="utilisateur")
	private List<CartesBancaire> cartesBancaires;

	//bi-directional many-to-one association to Commande
	@OneToMany(mappedBy="utilisateur")
	private List<Commande> commandes;

	//bi-directional many-to-one association to Document
	@OneToMany(mappedBy="utilisateur")
	private List<Document> documents;

	//bi-directional many-to-one association to FilmsUtilisateur
	@OneToMany(mappedBy="utilisateur")
	private List<FilmsUtilisateur> filmsUtilisateurs;

	//bi-directional many-to-one association to Role
	@ManyToOne
	@JoinColumn(name="ID_ROLE", nullable=false)
	private Role role;

	//bi-directional many-to-one association to Utilisateur
	@ManyToOne
	@JoinColumn(name="REFERE", nullable=false)
	private Utilisateur utilisateur;

	//bi-directional many-to-one association to Utilisateur
	@OneToMany(mappedBy="utilisateur")
	private List<Utilisateur> utilisateurs;

	//bi-directional many-to-one association to Codepostaux
	@ManyToOne
	@JoinColumn(name="ID_CODEPOSTAL", nullable=false)
	private Codepostaux codepostaux;

	public Utilisateur() {
	}

	public int getIdUtilisateur() {
		return this.idUtilisateur;
	}

	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public String getADnumero() {
		return this.ADnumero;
	}

	public void setADnumero(String ADnumero) {
		this.ADnumero = ADnumero;
	}

	public String getADrue() {
		return this.ADrue;
	}

	public void setADrue(String ADrue) {
		this.ADrue = ADrue;
	}

	public Date getDateNaissance() {
		return this.dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getNumMobile() {
		return this.numMobile;
	}

	public void setNumMobile(String numMobile) {
		this.numMobile = numMobile;
	}

	public String getPasswd() {
		return this.passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getPseudo() {
		return this.pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public List<CartesBancaire> getCartesBancaires() {
		return this.cartesBancaires;
	}

	public void setCartesBancaires(List<CartesBancaire> cartesBancaires) {
		this.cartesBancaires = cartesBancaires;
	}

	public CartesBancaire addCartesBancaire(CartesBancaire cartesBancaire) {
		getCartesBancaires().add(cartesBancaire);
		cartesBancaire.setUtilisateur(this);

		return cartesBancaire;
	}

	public CartesBancaire removeCartesBancaire(CartesBancaire cartesBancaire) {
		getCartesBancaires().remove(cartesBancaire);
		cartesBancaire.setUtilisateur(null);

		return cartesBancaire;
	}

	public List<Commande> getCommandes() {
		return this.commandes;
	}

	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}

	public Commande addCommande(Commande commande) {
		getCommandes().add(commande);
		commande.setUtilisateur(this);

		return commande;
	}

	public Commande removeCommande(Commande commande) {
		getCommandes().remove(commande);
		commande.setUtilisateur(null);

		return commande;
	}

	public List<Document> getDocuments() {
		return this.documents;
	}

	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}

	public Document addDocument(Document document) {
		getDocuments().add(document);
		document.setUtilisateur(this);

		return document;
	}

	public Document removeDocument(Document document) {
		getDocuments().remove(document);
		document.setUtilisateur(null);

		return document;
	}

	public List<FilmsUtilisateur> getFilmsUtilisateurs() {
		return this.filmsUtilisateurs;
	}

	public void setFilmsUtilisateurs(List<FilmsUtilisateur> filmsUtilisateurs) {
		this.filmsUtilisateurs = filmsUtilisateurs;
	}

	public FilmsUtilisateur addFilmsUtilisateur(FilmsUtilisateur filmsUtilisateur) {
		getFilmsUtilisateurs().add(filmsUtilisateur);
		filmsUtilisateur.setUtilisateur(this);

		return filmsUtilisateur;
	}

	public FilmsUtilisateur removeFilmsUtilisateur(FilmsUtilisateur filmsUtilisateur) {
		getFilmsUtilisateurs().remove(filmsUtilisateur);
		filmsUtilisateur.setUtilisateur(null);

		return filmsUtilisateur;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Utilisateur getUtilisateur() {
		return this.utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public List<Utilisateur> getUtilisateurs() {
		return this.utilisateurs;
	}

	public void setUtilisateurs(List<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}

	public Utilisateur addUtilisateur(Utilisateur utilisateur) {
		getUtilisateurs().add(utilisateur);
		utilisateur.setUtilisateur(this);

		return utilisateur;
	}

	public Utilisateur removeUtilisateur(Utilisateur utilisateur) {
		getUtilisateurs().remove(utilisateur);
		utilisateur.setUtilisateur(null);

		return utilisateur;
	}

	public Codepostaux getCodepostaux() {
		return this.codepostaux;
	}

	public void setCodepostaux(Codepostaux codepostaux) {
		this.codepostaux = codepostaux;
	}

}