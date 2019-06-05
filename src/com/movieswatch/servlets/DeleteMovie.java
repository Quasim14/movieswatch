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

import com.movieswatch.connection.EMF;
import com.movieswatch.model.Commande;
import com.movieswatch.model.CommandesFilm;
import com.movieswatch.query.EntityFinderImpl;

/**
 * Servlet implementation class DeleteMovie
 */
@WebServlet("/accesrestreint/deletemovie")
public class DeleteMovie extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private EntityFinderImpl<Commande> efic = new EntityFinderImpl<Commande>();
    private EntityFinderImpl<CommandesFilm> eficf = new EntityFinderImpl<CommandesFilm>();

    public DeleteMovie() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idFilm= Integer.valueOf(request.getParameter("idfilm"));
        int idPanier= Integer.valueOf(request.getParameter("idpanier"));
        CommandesFilm itemToRemove = null;

        Commande panier= efic.findOne(new Commande(), idPanier);

        for(CommandesFilm cf : panier.getCommandesFilms()) {
            if(cf.getFilm().getIdFilm()== idFilm) {
                EntityManager em= EMF.getEM();
                try {
                    EntityTransaction transac= em.getTransaction();
                    transac.begin();
                    itemToRemove = em.find(CommandesFilm.class, cf.getIdCommandeFilm());
                    if(itemToRemove != null)
                        em.remove(itemToRemove);
                    transac.commit();
                }
                finally {
                    em.clear();
                    em.close();
                }
            }
        }

        panier.removeCommandesFilm(itemToRemove);
        response.sendRedirect(request.getContextPath()+ "/accesrestreint/panier");
    }

}
