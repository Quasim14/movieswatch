package com.movieswatch.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.movieswatch.connection.EMF;

import model.Abonnement;
import movieswatchquery.EntityFinderImpl;

/**
 * Servlet implementation class testServlet
 */
@WebServlet("/testServlet")
public class testServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(testServlet.class);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public testServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		EntityFinderImpl<Abonnement> eti= new EntityFinderImpl<>();
		Abonnement ab= new Abonnement();
		
		//recuperation de tout les abonnement via une namedQuery specifier dans le model Abonnement
		List<Abonnement> abonnements = new ArrayList<Abonnement>();
		abonnements= (List<Abonnement>)eti.findByNamedQuery("Abonnement.findAll", ab, null);
		
		//recuperation d'une liste d'objet via une customQuery, ATTENTION impossible de caster dans un type precis
		List abonnements2 = new ArrayList();
		abonnements2= eti.findByCustomQuery("select a.intitule from Abonnement a where a.tarif > 5", ab, null );
		
		//delete d'un objet,  param: type a  supprimer via un objet de ce type et id
		eti.delete(ab, 1);
		
		//insertion en passant un objet en parametre
		eti.insert(ab);
		
		//update, param: un objet avec les prop mis Ã  jour et id, ATTENTION non generique
		update(ab, 2);
		
		//update generique via une query d'update, param: la query et une map avec les parametre de la query
		Map<String, Integer> params= new HashMap<String, Integer>();
		params.put("tf", 3);
		params.put("id", 2);
		eti.update("update Abonnement set tarif = :tf where idAbonnement= :id", params);
		
		log.debug(abonnements2.get(1));
		
		request.setAttribute("abos", abonnements);
		request.setAttribute("abo", eti.findOne(ab,1));
		this.getServletContext().getRequestDispatcher("/WEB-INF/test.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	//autre maniere de realiser des update mais non generique
	public void update(Abonnement ab, int id) {
		EntityManager em = EMF.getEM();		
		try {
			EntityTransaction transac= em.getTransaction();
			transac.begin();
			Abonnement abo= (Abonnement) em.find(ab.getClass(), id);
			if(abo!=null) {
				abo.setIntitule(ab.getIntitule());
				abo.setTarif(ab.getTarif());
				log.debug(abo + " a été mis a jour");
			}else
				log.debug("aucun enregistrement avec l'id: " + id);
			em.flush();
			transac.commit();
		}
		finally {
			em.clear();
			em.close();
		}
	}
}
