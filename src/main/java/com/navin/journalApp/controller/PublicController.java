package com.navin.journalApp.controller;

import com.navin.journalApp.entity.User;
import com.navin.journalApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping
    public void createUser(@RequestBody User user) {
        userService.saveNewUser(user);
    }
}
