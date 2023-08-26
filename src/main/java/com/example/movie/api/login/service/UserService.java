package com.example.movie.api.login.service;

import com.example.movie.api.login.entity.RegistrationResponse;
import com.example.movie.api.login.entity.User;
import com.example.movie.api.login.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;
    @Autowired
    UserService(UserRepository userRepository) {
        this.userRepository=userRepository;
    }
    public ResponseEntity<RegistrationResponse> saveUser(User user) {
        User theUser=userRepository.save(user);
        String message="Hi "+theUser.getUsername()+"! Your registration id is: "+theUser.getId();
        return new ResponseEntity<>(new RegistrationResponse(message), HttpStatus.OK);
    }
}
