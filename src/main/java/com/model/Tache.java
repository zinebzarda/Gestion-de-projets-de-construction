package com.model;

public class Tache {
    private Integer tache_Id;
    private String name_tache;
    private String tache_Description;
    private String startDate;
    private String endDate;
    private String status;
    private Integer projet_Id;

    public Tache(Integer tache_Id, String name_tache, String tache_Description, String startDate, String endDate, String status, Integer projet_Id) {
        this.tache_Id = tache_Id;
        this.name_tache = name_tache;
        this.tache_Description = tache_Description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.projet_Id = projet_Id;
    }

    public Tache(String name_tache, String tache_Description, String startDate, String endDate, String status, Integer projet_Id) {
        this.name_tache = name_tache;
        this.tache_Description = tache_Description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.projet_Id = projet_Id;
    }

    public Integer getTache_Id() {
        return tache_Id;
    }

    public String getName_tache() { return name_tache;}

    public String getTache_Description() {
        return tache_Description;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getStatus() {
        return status;
    }

    public Integer getProjet_Id() {
        return projet_Id;
    }
}
