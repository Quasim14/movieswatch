package com.movieswatch.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the formats database table.
 * 
 */
@Entity
@Table(name="formats")
@NamedQuery(name="Format.findAll", query="SELECT f FROM Format f")
public class Format implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_FORMAT", unique=true, nullable=false)
	private int idFormat;

	@Column(length=45)
	private String format;

	//bi-directional many-to-one association to FormatsFilm
	@OneToMany(mappedBy="format")
	private List<FormatsFilm> formatsFilms;

	public Format() {
	}

	public int getIdFormat() {
		return this.idFormat;
	}

	public void setIdFormat(int idFormat) {
		this.idFormat = idFormat;
	}

	public String getFormat() {
		return this.format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public List<FormatsFilm> getFormatsFilms() {
		return this.formatsFilms;
	}

	public void setFormatsFilms(List<FormatsFilm> formatsFilms) {
		this.formatsFilms = formatsFilms;
	}

	public FormatsFilm addFormatsFilm(FormatsFilm formatsFilm) {
		getFormatsFilms().add(formatsFilm);
		formatsFilm.setFormat(this);

		return formatsFilm;
	}

	public FormatsFilm removeFormatsFilm(FormatsFilm formatsFilm) {
		getFormatsFilms().remove(formatsFilm);
		formatsFilm.setFormat(null);

		return formatsFilm;
	}

}