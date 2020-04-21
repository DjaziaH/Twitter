package com.example.tweet.Data;

public class User {

    private int id ;
    private String nom ;
    private String prenom ;
    private int avatare ;

    public User(int id, String nom, String prenom, int avatare) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.avatare = avatare;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getAvatare() {
        return avatare;
    }

    public void setAvatare(int avatare) {
        this.avatare = avatare;
    }
}
