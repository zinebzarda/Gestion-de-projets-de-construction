package com.DAO;

import com.model.Tache;

import java.sql.SQLException;
import java.util.ArrayList;

public interface TacheDAO {
    void addTache(Tache tache) throws SQLException, ClassNotFoundException;
    public ArrayList<Tache> showTache() throws SQLException, ClassNotFoundException;
    void editTache(Tache tache) throws SQLException, ClassNotFoundException;
    void deleteTache(int tache_Id) throws SQLException, ClassNotFoundException;
    Tache selectBiId(int id) throws SQLException, ClassNotFoundException;
}
