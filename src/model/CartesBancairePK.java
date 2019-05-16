package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the cartes_bancaire database table.
 * 
 */
@Embeddable
public class CartesBancairePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ID_CARTE_BANCAIRE", unique=true, nullable=false)
	private int idCarteBancaire;

	public CartesBancairePK() {
	}
	public int getIdCarteBancaire() {
		return this.idCarteBancaire;
	}
	public void setIdCarteBancaire(int idCarteBancaire) {
		this.idCarteBancaire = idCarteBancaire;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CartesBancairePK)) {
			return false;
		}
		CartesBancairePK castOther = (CartesBancairePK)other;
		return 
			(this.idCarteBancaire == castOther.idCarteBancaire);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idCarteBancaire;;
		
		return hash;
	}
}