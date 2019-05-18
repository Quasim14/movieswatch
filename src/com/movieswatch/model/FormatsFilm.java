package com.movieswatch.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the formats_films database table.
 * 
 */
@Entity
@Table(name="formats_films")
@NamedQuery(name="FormatsFilm.findAll", query="SELECT f FROM FormatsFilm f")
public class FormatsFilm implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_FORMAT_FILM", unique=true, nullable=false)
	private int idFormatFilm;

	//bi-directional many-to-one association to Film
	@ManyToOne
	@JoinColumn(name="ID_FILM", nullable=false)
	private Film film;

	//bi-directional many-to-one association to Format
	@ManyToOne
	@JoinColumn(name="ID_FORMAT", nullable=false)
	private Format format;

	public FormatsFilm() {
	}

	public int getIdFormatFilm() {
		return this.idFormatFilm;
	}

	public void setIdFormatFilm(int idFormatFilm) {
		this.idFormatFilm = idFormatFilm;
	}

	public Film getFilm() {
		return this.film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	public Format getFormat() {
		return this.format;
	}

	public void setFormat(Format format) {
		this.format = format;
	}

}