package com.model;

public class Ressource {
    private int idRessource;
    private String nom;
    private String type;
    private int quantite;
    private String fournisseur;

    public Ressource(int idRessource, String nom, String type, int quantite, String fournisseur) {
        this.idRessource = idRessource;
        this.nom = nom;
        this.type = type;
        this.quantite = quantite;
        this.fournisseur = fournisseur;
    }

    public int getIdRessource() {
        return idRessource;
    }

    public String getNom() {
        return nom;
    }

    public String getType() {
        return type;
    }

    public int getQuantite() {
        return quantite;
    }

    public String getFournisseur() {
        return fournisseur;
    }

    public void setIdRessource(int idRessource) {
        this.idRessource = idRessource;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public void setFournisseur(String fournisseur) {
        this.fournisseur = fournisseur;
    }
}
