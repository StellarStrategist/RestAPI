package com.example.movie.api.login.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class LoginResponse {
    private String token;
    private String message;
}
