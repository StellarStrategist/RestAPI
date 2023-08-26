package com.example.movie.api.login.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class LoginRequest {
    private String username;
    private String password;
}
