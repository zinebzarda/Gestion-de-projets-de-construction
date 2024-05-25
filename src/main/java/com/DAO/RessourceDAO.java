package com.DAO;

import com.model.Ressource;

import java.sql.SQLException;
import java.util.ArrayList;

public interface RessourceDAO {

    void addRessource(Ressource ressource) throws SQLException, ClassNotFoundException;

    ArrayList<Ressource> showRessource() throws SQLException, ClassNotFoundException;

    ArrayList<Ressource> showRT(int tache_Id) throws SQLException, ClassNotFoundException;

    void editRessource(Ressource ressource) throws SQLException, ClassNotFoundException;

    void deleteRessource(int ressource_Id) throws SQLException, ClassNotFoundException;

    Ressource selectBiId(int id) throws SQLException, ClassNotFoundException;
}
