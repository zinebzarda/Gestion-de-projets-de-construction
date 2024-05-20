package com.DAO;

import com.model.Projet;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ProjetDAO {
    void addProjet(Projet projet) throws SQLException, ClassNotFoundException;
    ArrayList<Projet> showProjet() throws SQLException, ClassNotFoundException;
    void editProjet(Projet projet) throws SQLException, ClassNotFoundException;
    void deleteProjet(int projet_Id) throws SQLException, ClassNotFoundException;
}