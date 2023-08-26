package com.example.movie.api.login.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class RegistrationRequest {
    private String email;
    private String username;
    private String password;
}
