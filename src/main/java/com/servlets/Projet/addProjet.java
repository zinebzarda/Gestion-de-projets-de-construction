package com.servlets.Projet;

import com.DAO.ProjetDAOImp;
import com.model.Projet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

@WebServlet(name = "addProjet", value = "/addProjet")
public class addProjet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.getServletContext().getRequestDispatcher("/Projet/addProjet.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String projet_Name = request.getParameter("projet_Name");
        String projet_Description = request.getParameter("projet_Description");
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        Double budget = Double.valueOf(request.getParameter("budget"));


        ProjetDAOImp ProjetDao = new ProjetDAOImp();
        Projet projet = new Projet(projet_Name, projet_Description, startDate, endDate, budget);
        try {
            ProjetDao.addProjet(projet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


        response.sendRedirect("showP");
    }
}