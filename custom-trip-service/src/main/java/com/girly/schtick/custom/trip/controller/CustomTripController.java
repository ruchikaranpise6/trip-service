package com.girly.schtick.custom.trip.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/custom-trip")
public class CustomTripController {

    @GetMapping
    ResponseEntity<String> getCustomTrip(){
        return  ResponseEntity.status(HttpStatus.OK).body(" Received response from custom trip");
    }

}
