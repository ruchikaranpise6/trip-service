package com.girly.schtick.trip.fein;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "CUSTOM-TRIP-SERVICE")
public interface CustomTripServiceFeignClient {

    @GetMapping("/custom-trip")
    ResponseEntity<String> getCustomTrips();
}
