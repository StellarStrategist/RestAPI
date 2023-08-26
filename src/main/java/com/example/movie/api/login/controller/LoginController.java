package com.example.movie.api.login.controller;

import com.example.movie.api.login.entity.*;
import com.example.movie.api.login.security.JwtHelper;
import com.example.movie.api.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class LoginController {
    private AuthenticationManager authenticationManager;
    private UserDetailsService userDetailsService;
    private JwtHelper helper;
    private UserService userService;
    @Autowired
    LoginController(AuthenticationManager authenticationManager,JwtHelper helper,UserDetailsService userDetailsService,UserService userService) {
        this.authenticationManager=authenticationManager;
        this.userDetailsService=userDetailsService;
        this.userService=userService;
        this.helper=helper;
    }
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        String username=loginRequest.getUsername();
        String password= loginRequest.getPassword();
        this.doAuthenticate(username,password);
        UserDetails userDetails= userDetailsService.loadUserByUsername(username);
        String token=this.helper.generateToken(userDetails);
        return new ResponseEntity<>(new LoginResponse(token,username), HttpStatus.OK);
    }
    private void doAuthenticate(String username, String password) {
        UsernamePasswordAuthenticationToken authenticationToken=new UsernamePasswordAuthenticationToken(username,password);
        try {
            authenticationManager.authenticate(authenticationToken);
        }
        catch (BadCredentialsException e) {
            throw new BadCredentialsException("Invalid u or p");
        }
    }
    @ExceptionHandler(BadCredentialsException.class)
    public String exceptionHandle() {
        return "Invalid Details!";
    }

    @PostMapping("/register")
    public ResponseEntity<RegistrationResponse> registration(@RequestBody RegistrationRequest registrationRequest) {
        return userService.saveUser(new User(registrationRequest.getUsername(), registrationRequest.getPassword()));
    }
}
