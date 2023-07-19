package com.girly.schtick.trip.fein;

import com.girly.schtick.trip.config.LoadBalancerConfiguration;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "CUSTOM-TRIP-SERVICE")
@LoadBalancerClient(name = "CUSTOM-TRIP-SERVICE", configuration = LoadBalancerConfiguration.class)
public interface CustomTripServiceFeignClient {

    @GetMapping("/custom-trip")
    ResponseEntity<String> getCustomTrips();
}
