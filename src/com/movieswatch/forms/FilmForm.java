package com.movieswatch.forms;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.movieswatch.connection.EMF;
import com.movieswatch.model.Csa;
import com.movieswatch.model.Film;
import com.movieswatch.model.FilmsGenre;
import com.movieswatch.model.Genre;
import com.movieswatch.model.Personnage;
import com.movieswatch.model.Personne;
import com.movieswatch.query.EntityFinderImpl;

/**
 * 
 * @author Bilal Djouab
 * 
 */
public class FilmForm {
	private static Logger log = Logger.getLogger(FilmForm.class);


	EntityFinderImpl<Film> entityFinderImplFilm = new EntityFinderImpl<>();
	EntityFinderImpl<Personnage> entityFinderImplPersonnage = new EntityFinderImpl<>();
	EntityFinderImpl<Personne> entityFinderImplPersonne = new EntityFinderImpl<>();
	EntityFinderImpl<Csa> entityFinderImplCsa = new EntityFinderImpl<>();
	EntityFinderImpl<Genre> entityFinderImplGenre = new EntityFinderImpl<>();

	
	Film film = new Film();


	public Film setFilm(HttpServletRequest request){
		film.setTitreOriginal(request.getParameter("titre"));
		film.setBudget(request.getParameter("budget"));
		film.setAnneeProduction(request.getParameter("anneeProduction"));
		film.setSynopsis(request.getParameter("synopsis"));
		film.setMetrage(request.getParameter("metrage"));
		film.setUrlAffiche(request.getParameter("urlAffiche"));
		film.setNumIsan(request.getParameter("isan"));

	    Map<String, String> parametre = new HashMap<String, String>();
	    String age = request.getParameter("age");
	    log.debug(age);
	    parametre.put("age",age);


		Csa csa = entityFinderImplCsa.findOneByNamedQuery("Csa.findIdByValue",new Csa(), parametre);

		if(csa !=null) {
			film.setCsa(csa);
		}


		EntityManager em= EMF.getEM();
		EntityTransaction transac= em.getTransaction();
		try {
			transac.begin();
			em.persist(film);
			transac.commit();
		}finally {
			if(transac.isActive()) {
				transac.rollback();
			}
			em.clear();
			em.close();
		}
		
		return film;
	}
}
