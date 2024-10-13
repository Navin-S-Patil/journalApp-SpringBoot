package com.navin.journalApp.service;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static  org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class UserServiceTests {

    @Autowired
    UserService userService;


    @ParameterizedTest
    @ValueSource(strings={
            "navin",
            "arpita",
            "Sushmita"
    })
    public void testFindByUsername(String name){
        assertNotNull(userService.findByUsername(name),"Failed for"+name);
    }


    @ParameterizedTest
    @CsvSource({
            "1,1,2",
            "2,3,4",
            "4,5,9",
            "5,4,9",
            "2,3,11"
    })
    public void test(int a, int b, int expected){
        assertEquals(expected,a+b);
    }

}
