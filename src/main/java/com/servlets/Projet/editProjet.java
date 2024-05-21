package com.servlets.Projet;

import com.DAO.ProjetDAOImp;
import com.model.Projet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

@WebServlet(name = "editProjet", value = "/editProjet")
public class editProjet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        ProjetDAOImp projetDAO = new ProjetDAOImp();
        try {
            Projet projet = projetDAO.selectBiId(id);
            request.setAttribute("projet", projet);
            System.out.println(projet);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        this.getServletContext().getRequestDispatcher("/editProjet.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer projet_Id = Integer.valueOf(request.getParameter("projet_Id"));
        String projet_Name = request.getParameter("projet_Name");
        String projet_Description = request.getParameter("projet_Description");
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        Double budget = Double.valueOf(request.getParameter("budget"));

        Projet projet = new Projet(projet_Id, projet_Name, projet_Description, startDate, endDate, budget);
        ProjetDAOImp projetDAO = new ProjetDAOImp();
        try {
            projetDAO.editProjet(projet);
            request.setAttribute("shows", projetDAO.showProjet());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        this.getServletContext().getRequestDispatcher("/displayProjet.jsp").forward(request, response);
    }
}