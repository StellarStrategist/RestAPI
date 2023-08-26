package com.example.movie.api.login.entity;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
@Document(collection="reviews")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Review {
    @Id
    private ObjectId id;
    private String body;
    private LocalDateTime created;
    private LocalDateTime updated;
    public Review(String body,LocalDateTime created,LocalDateTime updated) {
        this.body=body;
        this.created=created;
        this.updated=updated;
    }
}
