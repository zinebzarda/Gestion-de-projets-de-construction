package com.servlets.Ressource;

import com.DAO.RessourceDAOImp;
import com.DAO.TacheDAOImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "displayRessource", value = "/displayRessource")
public class displayRessource extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TacheDAOImp showt=new TacheDAOImp();
        try {
            request.setAttribute("showT", showt.showTache());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        RessourceDAOImp show=new RessourceDAOImp();
        int tache_Id = Integer.parseInt(request.getParameter("tache_Id"));
        try {
            request.setAttribute("showR", show.showRT(tache_Id));
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        this.getServletContext().getRequestDispatcher("/Ressource/displayRessource.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}