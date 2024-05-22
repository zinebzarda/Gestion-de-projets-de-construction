package com.DAO;

import com.model.Projet;

import java.sql.*;
import java.util.ArrayList;


public class ProjetDAOImp implements ProjetDAO {

    @Override
    public void addProjet(Projet projet) throws SQLException, ClassNotFoundException {
        Connection connection = ConnectionDAO.getConnection();
        String sql = "INSERT INTO projets (projet_Name, projet_Description, startDate, endDate, budget)\n" +
                "VALUES ( ?, ?, ?, ?, ?);";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, projet.getProjet_Name());
            statement.setString(2, projet.getProjet_Description());
            statement.setString(3, projet.getStartDate());
            statement.setString(4, projet.getEndDate());
            statement.setDouble(5, projet.getBudget());
            statement.executeUpdate();
        }
    }

    @Override
    public ArrayList<Projet> showProjet() throws SQLException, ClassNotFoundException {
        Connection connection = ConnectionDAO.getConnection();
        ArrayList<Projet> projets = new ArrayList<>();
        String sql = "SELECT * FROM projets";
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultat = statement.executeQuery()) {
            while (resultat.next()) {
                Integer projet_Id = resultat.getInt("projet_Id");
                String projet_Name = resultat.getString("projet_Name");
                String projet_Description = resultat.getString("projet_Description");
                String startDate = resultat.getString("startDate");
                String endDate = resultat.getString("endDate");
                Double budget = resultat.getDouble("budget");

                Projet projet = new Projet(projet_Id, projet_Name, projet_Description, startDate, endDate, budget);
                projets.add(projet);
            }
        }
        return projets;
    }

    @Override
    public void editProjet(Projet projet) throws SQLException, ClassNotFoundException {
        Connection connection = ConnectionDAO.getConnection();
        String sql = "UPDATE projets SET  projet_Name=?, projet_Description=?, startDate=?, endDate=?, budget=? WHERE projet_Id=?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, projet.getProjet_Name());
            statement.setString(2, projet.getProjet_Description());
            statement.setString(3, projet.getStartDate());
            statement.setString(4, projet.getEndDate());
            statement.setDouble(5, projet.getBudget());
            statement.setInt(6, projet.getProjet_Id());
            statement.executeUpdate();
        }
    }

    @Override
    public void deleteProjet(int projet_Id) throws SQLException, ClassNotFoundException {
        Connection connection = ConnectionDAO.getConnection();
        String sql = "DELETE FROM projets WHERE projet_Id=?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, projet_Id);
            statement.executeUpdate();
        }
    }

    @Override
    public Projet selectBiId(int id) throws SQLException, ClassNotFoundException {
        Projet projet = null;
        Connection connection = ConnectionDAO.getConnection();
        String sql = "SELECT * FROM projets WHERE projet_Id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            projet = new Projet(
                    resultSet.getInt("projet_Id"),
                    resultSet.getString("projet_Name"),
                    resultSet.getString("projet_Description"),
                    resultSet.getString("startDate"),
                    resultSet.getString("endDate"),
                    resultSet.getDouble("budget")
            );
        }
        return projet;
    }
}
