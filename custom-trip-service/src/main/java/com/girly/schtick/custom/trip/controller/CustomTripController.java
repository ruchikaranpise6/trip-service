package com.girly.schtick.custom.trip.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/custom-trip")
public class CustomTripController {

    @GetMapping
    ResponseEntity<String> getCustomTrip() {
        System.out.println("In custom trips");
        return ResponseEntity.status(HttpStatus.OK).body(" Received response from custom trip port:");
    }

}
