package com.example;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Profil {
    private String nom;
    private String prenom;
    private String pseudo;

    @Override
    public String toString() {
        return String.format("Profile: { Nom: %s, Prenom: %s, Pseudo: %s }", nom, prenom, pseudo);
    }
}
