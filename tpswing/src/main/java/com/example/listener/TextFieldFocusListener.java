package com.example.listener;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import com.example.constants.Labels;
import com.example.ui.ProfileManager;

public class TextFieldFocusListener implements FocusListener {
    ProfileManager p;

    public TextFieldFocusListener(ProfileManager p) {
        this.p = p;
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (e.getSource() == p.tf_nom) {
            if (p.tf_nom.getText().trim().equals(Labels.LASTNAME_LABEL)) {
                p.tf_nom.setText("");
            }
        } else if (e.getSource() == p.tf_prenom) {
            if (p.tf_prenom.getText().trim().equals(Labels.FIRSTNAME_LABEL)) {
                p.tf_prenom.setText("");
            }
        } else if (e.getSource() == p.tf_pseudo) {
            if (p.tf_pseudo.getText().trim().equals(Labels.NICKNAME_LABEL)) {
                p.tf_pseudo.setText("");
            }
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (e.getSource() == p.tf_nom) {
            if (p.tf_nom.getText().trim().equals("")) {
                p.tf_nom.setText(Labels.LASTNAME_LABEL);
            }
        } else if (e.getSource() == p.tf_prenom) {
            if (p.tf_prenom.getText().trim().equals("")) {
                p.tf_prenom.setText(Labels.FIRSTNAME_LABEL);
            }
        } else if (e.getSource() == p.tf_pseudo) {
            if (p.tf_pseudo.getText().trim().equals("")) {
                p.tf_pseudo.setText(Labels.NICKNAME_LABEL);
            }
        }

    }
}
