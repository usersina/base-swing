package com.example;

public class Profil {
    String nom, prenom, pseudo;

    public Profil(String nom, String prenom, String pseudo) {
        this.nom = nom;
        this.prenom = prenom;
        this.pseudo = pseudo;
    }

    @Override
    public String toString() {
        return "Profil{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", pseudo='" + pseudo + '\'' +
                '}';
    }
}
