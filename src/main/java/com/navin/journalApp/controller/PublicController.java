package com.navin.journalApp.controller;

import com.navin.journalApp.entity.User;
import com.navin.journalApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
public class PublicController {

    @Autowired
    private UserService userService;

    @GetMapping("health-check")
    public String healthCheck() {
        return "Ok";
    }

    @PostMapping("/create-user")
    public ResponseEntity<?> createUser(@RequestBody User user) {
        boolean newUser = userService.saveNewUser(user);
        if(newUser)return new ResponseEntity<>("User Created",HttpStatus.CREATED);
        return new ResponseEntity<>("User Already Exit",HttpStatus.BAD_REQUEST);
    }
}
