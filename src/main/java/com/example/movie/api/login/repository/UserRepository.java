package com.example.movie.api.login.repository;

import com.example.movie.api.login.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User,String> {
    @Query("{username:'?0'}")
    User findUserByUsername(String username);
}
