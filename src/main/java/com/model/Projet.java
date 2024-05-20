package com.model;

public class Projet {
    private int idProjet;
    private String nom;
    private String description;
    private String dateDebut;
    private String dateFin;
    private double budget;

    public Projet(int idProjet, String nom, String description, String dateDebut, String dateFin, double budget) {
        this.idProjet = idProjet;
        this.nom = nom;
        this.description = description;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.budget = budget;
    }

    public int getIdProjet() {
        return idProjet;
    }

    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    public String getDateDebut() {
        return dateDebut;
    }

    public String getDateFin() {
        return dateFin;
    }

    public double getBudget() {
        return budget;
    }

    public void setIdProjet(int idProjet) {
        this.idProjet = idProjet;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }
}
