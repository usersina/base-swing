package com.example;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class EcouteurFocus implements FocusListener {
    Profils p;

    EcouteurFocus(Profils p) {
        this.p = p;
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (e.getSource() == p.tf_nom)
            p.tf_nom.setText("");
        if (e.getSource() == p.tf_prenom)
            p.tf_prenom.setText("");
        if (e.getSource() == p.tf_pseudo)
            p.tf_pseudo.setText("");
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (e.getSource() == p.tf_nom)
            if (p.tf_nom.getText().trim().equals(""))
                p.tf_nom.setText("Tapper votre nom");

        if (e.getSource() == p.tf_prenom)
            if (p.tf_prenom.getText().trim().equals(""))
                p.tf_prenom.setText("Tapper votre prenom");

        if (e.getSource() == p.tf_pseudo)
            if (p.tf_pseudo.getText().trim().equals(""))
                p.tf_pseudo.setText("Tapper votre pseudo");

    }
}
