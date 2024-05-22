package com.servlets.Tache;

import com.DAO.ProjetDAOImp;
import com.DAO.TacheDAOImp;
import com.model.Projet;
import com.model.Tache;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "editTache", value = "/editTache")
public class editTache extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer id = Integer.valueOf(request.getParameter("id"));
        TacheDAOImp tacheDAO = new TacheDAOImp();
        try {
            Tache tache = tacheDAO.selectBiId(id);
            request.setAttribute("tache", tache);
            System.out.println(tache);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        this.getServletContext().getRequestDispatcher("/Tache/editTache.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer tache_Id = Integer.valueOf(request.getParameter("tache_Id"));
        String name_tache = request.getParameter("name_tache");
        String tache_Description = request.getParameter("tache_Description");
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        String status = request.getParameter("status");
        Integer projet_Id = Integer.valueOf(request.getParameter("projet_Id"));

        Tache tache = new Tache(tache_Id ,name_tache, tache_Description, startDate, endDate, status, projet_Id);
        TacheDAOImp tacheDAO = new TacheDAOImp();
        try {
            tacheDAO.editTache(tache);
            request.setAttribute("showT", tacheDAO.showTache());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        this.getServletContext().getRequestDispatcher("/Tache/displayTache.jsp").forward(request, response);
    }
}