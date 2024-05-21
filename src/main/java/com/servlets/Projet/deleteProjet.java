package com.servlets.Projet;

import com.DAO.ProjetDAOImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "deleteProjet", value = "/deleteProjet")
public class deleteProjet extends HttpServlet {


    private ProjetDAOImp projetDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        projetDAO = new ProjetDAOImp();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer projet_Id = Integer.parseInt(request.getParameter("projet_Id"));
        try {
            projetDAO.deleteProjet(projet_Id);
            request.setAttribute("shows", projetDAO.showProjet());
        } catch (SQLException e) {
            throw new ServletException("Failed to delete projet", e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        request.getRequestDispatcher("/displayProjet.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer projet_Id = Integer.parseInt(request.getParameter("projet_Id"));
        try {
            projetDAO.deleteProjet(projet_Id);
            request.setAttribute("shows", projetDAO.showProjet());
        } catch (SQLException e) {
            throw new ServletException("Failed to delete projet", e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        request.getRequestDispatcher("/displayProjet.jsp").forward(request, response);
    }
}
