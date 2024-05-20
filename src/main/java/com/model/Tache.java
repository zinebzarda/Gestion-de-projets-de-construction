package com.model;

public class Tache {
    private int idTache;
    private String description;
    private String dateDebut;
    private String dateFin;
    private String statut;

    public Tache(int idTache, String description, String dateDebut, String dateFin, String statut) {
        this.idTache = idTache;
        this.description = description;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.statut = statut;
    }

    public int getIdTache() {
        return idTache;
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

    public String getStatut() {
        return statut;
    }

    public void setIdTache(int idTache) {
        this.idTache = idTache;
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

    public void setStatut(String statut) {
        this.statut = statut;
    }
}
