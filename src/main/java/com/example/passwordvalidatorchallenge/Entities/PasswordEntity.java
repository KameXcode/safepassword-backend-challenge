package com.example.passwordvalidatorchallenge.Entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Component
public class PasswordEntity {
    private String password;

    public PasswordEntity(String password) {
        this.password = password;
    }

      public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
