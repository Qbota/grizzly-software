package com.cembrzynski.clinic.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/setup")
public class SetUpController {

    @GetMapping
    public ResponseEntity<Object> setUpDatabase(){
        return ResponseEntity.ok().build();
    }
}
