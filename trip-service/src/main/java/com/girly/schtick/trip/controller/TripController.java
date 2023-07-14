package com.girly.schtick.trip.controller;

import com.girly.schtick.trip.bean.TripBean;
import com.girly.schtick.trip.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trips")
public class TripController {

    @Autowired
    private TripService tripService;

    @PostMapping
    ResponseEntity<TripBean> addTripDetails(@RequestBody TripBean request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(tripService.addTripDetails(request));
    }

    @GetMapping
    ResponseEntity<List<TripBean>> getTrips() {
        return ResponseEntity.status(HttpStatus.OK).body(tripService.getTrips());
    }

    @GetMapping("/{id}")
    ResponseEntity<TripBean> getTripById(@PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(tripService.getTripById(id));
    }

}
