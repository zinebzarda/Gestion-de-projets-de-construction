package com.servlets.Tache;

import com.DAO.ProjetDAOImp;
import com.DAO.TacheDAOImp;
import com.model.Tache;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "addTache", value = "/addTache")
public class addTache extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.getServletContext().getRequestDispatcher("/Tache/addTache.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name_tache = request.getParameter("name_tache");
        String tache_Description = request.getParameter("tache_Description");
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        String status = request.getParameter("status");
        Integer projet_Id = Integer.parseInt(request.getParameter("projet_Id"));
        TacheDAOImp tacheDAO = new TacheDAOImp();
        Tache tache = new Tache(name_tache, tache_Description, startDate, endDate, status, projet_Id);
        try {
            tacheDAO.addTache(tache);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        response.sendRedirect(request.getContextPath() + "/showT?projet_Id=" + projet_Id);
    }
}
