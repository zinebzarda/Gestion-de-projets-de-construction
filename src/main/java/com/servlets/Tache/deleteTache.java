package com.servlets.Tache;

import com.DAO.TacheDAOImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "daleteTache", value = "/daleteTache")
public class deleteTache extends HttpServlet {

    private TacheDAOImp tacheDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        tacheDAO = new TacheDAOImp();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer tache_Id = Integer.parseInt(request.getParameter("tache_Id"));
        try {
            tacheDAO.deleteTache(tache_Id);
            request.setAttribute("showT", tacheDAO.showTache());
        } catch (SQLException e) {
            throw new ServletException("Failed to delete tache", e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        request.getRequestDispatcher("/Tache/displayTache.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/Tache/displayTache.jsp").forward(request, response);
    }
}