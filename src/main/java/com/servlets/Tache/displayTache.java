package com.servlets.Tache;

import com.DAO.ProjetDAOImp;
import com.DAO.TacheDAOImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "displayTache", value = "/displayTache")
public class displayTache extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TacheDAOImp show=new TacheDAOImp();
        int projet_Id = Integer.parseInt(request.getParameter("projet_Id"));
        try {
            request.setAttribute("showT", show.showTP(projet_Id));
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        this.getServletContext().getRequestDispatcher("/Tache/displayTache.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}