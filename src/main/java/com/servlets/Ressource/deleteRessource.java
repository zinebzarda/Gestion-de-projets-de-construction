package com.servlets.Ressource;

import com.DAO.RessourceDAOImp;
import com.DAO.TacheDAOImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "deleteRessource", value = "/deleteRessource")
public class deleteRessource extends HttpServlet {

    private RessourceDAOImp ressourceDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        ressourceDAO = new RessourceDAOImp();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer ressource_Id = Integer.parseInt(request.getParameter("ressource_Id"));
        try {
            ressourceDAO.deleteRessource(ressource_Id);
            request.setAttribute("showR", ressourceDAO.showRessource());
        } catch (SQLException e) {
            throw new ServletException("Failed to delete Ressource", e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        request.getRequestDispatcher("/Ressource/displayRessource.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/Ressource/displayRessource.jsp").forward(request, response);

    }
}