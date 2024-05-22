package com.model;

public class Ressource {
    private Integer ressource_Id;
    private String ressource_name;
    private String type;
    private Integer quantite;
    private String fournisseur;
    private Integer tache_Id;

    public Ressource(Integer ressource_Id, String ressource_name, String type, Integer quantite, String fournisseur, Integer tache_Id) {
        this.ressource_Id = ressource_Id;
        this.ressource_name = ressource_name;
        this.type = type;
        this.quantite = quantite;
        this.fournisseur = fournisseur;
        this.tache_Id = tache_Id;
    }

    public Ressource(String ressource_name, String type, Integer quantite, String fournisseur, Integer tache_Id) {
        this.ressource_name = ressource_name;
        this.type = type;
        this.quantite = quantite;
        this.fournisseur = fournisseur;
        this.tache_Id = tache_Id;
    }

    public Integer getRessource_Id() {
        return ressource_Id;
    }

    public String getRessource_name() {
        return ressource_name;
    }

    public String getType() {
        return type;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public String getFournisseur() {
        return fournisseur;
    }

    public Integer getTache_Id() {
        return tache_Id;
    }
}
