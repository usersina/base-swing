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
        if (e.getSource() == p.tf_nom) {
            if (p.tf_nom.getText().trim().equals(Constants.LASTNAME_LABEL)) {
                p.tf_nom.setText("");
            }
        } else if (e.getSource() == p.tf_prenom) {
            if (p.tf_prenom.getText().trim().equals(Constants.FIRSTNAME_LABEL)) {
                p.tf_prenom.setText("");
            }
        } else if (e.getSource() == p.tf_pseudo) {
            if (p.tf_pseudo.getText().trim().equals(Constants.NICKNAME_LABEL)) {
                p.tf_pseudo.setText("");
            }
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (e.getSource() == p.tf_nom) {
            if (p.tf_nom.getText().trim().equals("")) {
                p.tf_nom.setText(Constants.LASTNAME_LABEL);
            }
        } else if (e.getSource() == p.tf_prenom) {
            if (p.tf_prenom.getText().trim().equals("")) {
                p.tf_prenom.setText(Constants.FIRSTNAME_LABEL);
            }
        } else if (e.getSource() == p.tf_pseudo) {
            if (p.tf_pseudo.getText().trim().equals("")) {
                p.tf_pseudo.setText(Constants.NICKNAME_LABEL);
            }
        }

    }
}
