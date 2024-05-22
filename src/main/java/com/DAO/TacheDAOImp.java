package com.DAO;

import com.model.Projet;
import com.model.Tache;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TacheDAOImp implements TacheDAO {
    @Override
    public void addTache(Tache tache) throws SQLException, ClassNotFoundException {
        Connection connection = ConnectionDAO.getConnection();
        String sql = "INSERT INTO taches ( name_tache, tache_Description, startDate, endDate, status, projet_Id)\n" +
                "VALUES ( ?, ?, ?, ?, ?, ?);";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, tache.getName_tache());
            statement.setString(2, tache.getTache_Description());
            statement.setString(3, tache.getStartDate());
            statement.setString(4, tache.getEndDate());
            statement.setString(5, tache.getStatus());
            statement.setInt(6, tache.getProjet_Id());
            statement.executeUpdate();
        }

    }

    @Override
    public ArrayList<Tache> showTache() throws SQLException, ClassNotFoundException {
        Connection connection = ConnectionDAO.getConnection();
        ArrayList<Tache> taches = new ArrayList<>();
        String sql = "SELECT * FROM taches";
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultat = statement.executeQuery()) {
            while (resultat.next()) {
                Integer tache_Id = resultat.getInt("tache_Id");
                String name_tache = resultat.getString("name_tache");
                String tache_Description = resultat.getString("tache_Description");
                String startDate = resultat.getString("startDate");
                String endDate = resultat.getString("endDate");
                String status = resultat.getString("status");
                Integer projet_Id = resultat.getInt("projet_Id");

                Tache tache = new Tache(tache_Id,name_tache, tache_Description, startDate, endDate, status,projet_Id);
                taches.add(tache);
            }
        }
        return taches;
    }

    @Override
    public void editTache(Tache tache) throws SQLException, ClassNotFoundException {
        Connection connection = ConnectionDAO.getConnection();
        String sql = "UPDATE taches SET name_tache=?, tache_Description=?, startDate=?, endDate=?, status=?, projet_Id=? WHERE tache_Id=?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, tache.getName_tache());
            statement.setString(2, tache.getTache_Description());
            statement.setString(3, tache.getStartDate());
            statement.setString(4, tache.getEndDate());
            statement.setString(5, tache.getStatus());
            statement.setInt(6, tache.getProjet_Id());
            statement.setInt(7, tache.getTache_Id());
            statement.executeUpdate();
        }
    }
    @Override
    public void deleteTache(int tache_Id) throws SQLException, ClassNotFoundException {
        Connection connection = ConnectionDAO.getConnection();
        String sql = "DELETE FROM taches WHERE tache_Id=?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, tache_Id);
            statement.executeUpdate();
        }
    }

    @Override
    public Tache selectBiId(int id) throws SQLException, ClassNotFoundException {
        Tache tache = null;
        Connection connection = ConnectionDAO.getConnection();
        String sql = "SELECT * FROM taches WHERE tache_Id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            tache = new Tache(
                    resultSet.getInt("tache_Id"),
                    resultSet.getString("name_tache"),
                    resultSet.getString("tache_Description"),
                    resultSet.getString("startDate"),
                    resultSet.getString("endDate"),
                    resultSet.getString("status"),
                    resultSet.getInt("projet_Id")
            );
        }
        return tache;
    }
}
