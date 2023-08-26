package com.example.movie.api.login.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection = "users")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class User {
    private @MongoId ObjectId id;
    private String username;
    private String password;
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
