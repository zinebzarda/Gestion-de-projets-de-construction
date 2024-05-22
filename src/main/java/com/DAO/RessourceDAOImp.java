package com.DAO;

import com.model.Ressource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RessourceDAOImp implements RessourceDAO {
    @Override
    public void addRessource(Ressource ressource) throws SQLException, ClassNotFoundException {
        Connection connection = ConnectionDAO.getConnection();
        String sql = "INSERT INTO  ressources ( ressource_name, type, quantite, fournisseur, tache_Id)\n" +
                "VALUES ( ?, ?, ?, ?, ?);";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, ressource.getRessource_name());
            statement.setString(2, ressource.getType());
            statement.setInt(3, ressource.getQuantite());
            statement.setString(4, ressource.getFournisseur());
            statement.setInt(5, ressource.getTache_Id());
            statement.executeUpdate();
        }

    }

    @Override
    public ArrayList<Ressource> showRessource() throws SQLException, ClassNotFoundException {
        Connection connection = ConnectionDAO.getConnection();
        ArrayList<Ressource> ressourses = new ArrayList<>();
        String sql = "SELECT * FROM ressources";
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultat = statement.executeQuery()) {
            while (resultat.next()) {
                Integer ressource_Id = resultat.getInt("ressource_Id");
                String ressource_name = resultat.getString("ressource_name");
                String type = resultat.getString("type");
                Integer quantite = resultat.getInt("quantite");
                String fournisseur = resultat.getString("fournisseur");
                Integer tache_Id = resultat.getInt("tache_Id");

                Ressource ressource = new Ressource(ressource_Id,ressource_name, type, quantite, fournisseur, tache_Id);
                ressourses.add(ressource);
            }
        }
        return ressourses;
    }

    @Override
    public void editRessource(Ressource ressource) throws SQLException, ClassNotFoundException {
        Connection connection = ConnectionDAO.getConnection();
        String sql = "UPDATE ressources SET ressource_name=?, type=?, quantite=?, fournisseur=?, tache_Id=? WHERE ressource_Id=?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, ressource.getRessource_name());
            statement.setString(2, ressource.getType());
            statement.setInt(3, ressource.getQuantite());
            statement.setString(4, ressource.getFournisseur());
            statement.setInt(5, ressource.getTache_Id());
            statement.setInt(6, ressource.getRessource_Id());
            statement.executeUpdate();
        }
    }
    @Override
    public void deleteRessource(int ressource_Id) throws SQLException, ClassNotFoundException {
        Connection connection = ConnectionDAO.getConnection();
        String sql = "DELETE FROM ressources WHERE ressource_Id=?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, ressource_Id);
            statement.executeUpdate();
        }
    }

    @Override
    public Ressource selectBiId(int id) throws SQLException, ClassNotFoundException {
        Ressource ressource = null;
        Connection connection = ConnectionDAO.getConnection();
        String sql = "SELECT * FROM ressources WHERE ressource_Id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            ressource = new Ressource(
                    resultSet.getInt("ressource_Id"),
                    resultSet.getString("ressource_name"),
                    resultSet.getString("type"),
                    resultSet.getInt("quantite"),
                    resultSet.getString("fournisseur"),
                    resultSet.getInt("tache_Id")
            );
        }
        return ressource;
    }
}
