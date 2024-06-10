package com.ads.adsback.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/prueba")
@RestController
public class PruebaController {

    @GetMapping
    public ResponseEntity<String> prueba(){
        return new ResponseEntity<>("Hola", HttpStatus.OK);
    }

}
