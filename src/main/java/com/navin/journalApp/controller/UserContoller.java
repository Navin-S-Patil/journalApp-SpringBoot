package com.navin.journalApp.controller;

import com.navin.journalApp.api.response.WeatherResponse;
import com.navin.journalApp.entity.User;
import com.navin.journalApp.service.UserService;
import com.navin.journalApp.service.WeatherApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserContoller {

    @Autowired
    private UserService userService;

    @Autowired
    WeatherApiService weatherApiService;

//    @GetMapping
//    public List<User> getAllUser() {
//        return userService.getAllEntry();
//    }


    @PutMapping()
    public ResponseEntity<?> updateUser(@RequestBody User user) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User userInDb = userService.findByUsername(username);

        userInDb.setUsername(user.getUsername());
        userInDb.setPassword(user.getPassword());
        userService.saveNewUser(userInDb);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @DeleteMapping()
    public ResponseEntity<?> deleteUser(@RequestBody User user) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        userService.deleteEntryByUsername(username);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping()
    public ResponseEntity<?> greeting() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        WeatherResponse response = weatherApiService.getWeatherForcast("Mumbai");
        String greet = "";
        if(response != null){
            greet = " Weather feels like "+response.getCurrent().getTempInCelious();
        }
        return new ResponseEntity<>("Hiii " + authentication.getName() + greet, HttpStatus.OK);
    }

}
