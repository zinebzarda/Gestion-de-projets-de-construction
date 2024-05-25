package com.servlets.Ressource;

import com.DAO.RessourceDAOImp;
import com.DAO.TacheDAOImp;
import com.model.Ressource;
import com.model.Tache;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "editRessource", value = "/editRessource")
public class editRessource extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer id = Integer.valueOf(request.getParameter("id"));
        RessourceDAOImp ressourceDAO = new RessourceDAOImp();
        try {
            Ressource ressource = ressourceDAO.selectBiId(id);
            request.setAttribute("ressource", ressource);
            System.out.println(ressource);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        this.getServletContext().getRequestDispatcher("/Ressource/editRessource.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer ressource_Id = Integer.valueOf(request.getParameter("ressource_Id"));
        String ressource_name = request.getParameter("ressource_name");
        String type = request.getParameter("type");
        Integer quantite = Integer.valueOf(request.getParameter("quantite"));
        String fournisseur = request.getParameter("fournisseur");
        Integer tache_Id = Integer.valueOf(request.getParameter("tache_Id"));

        Ressource ressource = new Ressource(ressource_Id ,ressource_name, type, quantite, fournisseur, tache_Id);
        RessourceDAOImp ressourceDAo = new RessourceDAOImp();
        try {
            ressourceDAo.editRessource(ressource);
            request.setAttribute("showR", ressourceDAo.showRessource());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        this.getServletContext().getRequestDispatcher("/Ressource/displayRessource.jsp").forward(request, response);
    }
}