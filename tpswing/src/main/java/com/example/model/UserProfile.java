package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserProfile {
    private String lastname;
    private String firstname;
    private String nickname;

    @Override
    public String toString() {
        return String.format(
                "User Profile: { Lastname: %s, Firstname: %s, nickname: %s }", lastname, firstname, nickname //
        );
    }
}
