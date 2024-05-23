package com.servlets.Ressource;

import com.DAO.ProjetDAOImp;
import com.DAO.RessourceDAOImp;
import com.DAO.TacheDAOImp;
import com.model.Ressource;
import com.model.Tache;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "addRessource", value = "/addRessource")
public class addRessource extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TacheDAOImp show=new TacheDAOImp();
        try {
            request.setAttribute("showT", show.showTache());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        this.getServletContext().getRequestDispatcher("/Ressource/addRessource.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ressource_name = request.getParameter("ressource_name");
        String type = request.getParameter("type");
        Integer quantite = Integer.valueOf(request.getParameter("quantite"));
        String fournisseur = request.getParameter("fournisseur");
        Integer tache_Id = Integer.parseInt(request.getParameter("tache_Id"));


        RessourceDAOImp ressourceDAO = new RessourceDAOImp();
        Ressource ressource = new Ressource(ressource_name,type, quantite, fournisseur, tache_Id);
        try {
            ressourceDAO.addRessource(ressource);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


        response.sendRedirect("showR");
    }
}