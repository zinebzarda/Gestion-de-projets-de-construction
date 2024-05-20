package com.model;

public class Projet {
    private int projet_Id;
    private String projet_Name;
    private String projet_Description;
    private String startDate;
    private String endDate;
    private double budget;

    public Projet(int projet_Id, String projet_Name, String projet_Description, String startDate, String endDate, double budget) {
        this.projet_Id = projet_Id;
        this.projet_Name = projet_Name;
        this.projet_Description = projet_Description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.budget = budget;
    }

    public int getProjet_Id() {
        return projet_Id;
    }

    public String getProjet_Name() {
        return projet_Name;
    }

    public String getProjet_Description() {
        return projet_Description;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public double getBudget() {
        return budget;
    }
}
