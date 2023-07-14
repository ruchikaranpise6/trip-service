package com.girly.schtick.trip.service.impl;

import com.girly.schtick.trip.bean.TripBean;
import com.girly.schtick.trip.entity.TripEntity;
import com.girly.schtick.trip.fein.CustomTripServiceFeignClient;
import com.girly.schtick.trip.repository.TripRepository;
import com.girly.schtick.trip.service.TripService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Slf4j
public class TripServiceImpl implements TripService {

    @Autowired
    private TripRepository tripRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CustomTripServiceFeignClient customTripServiceFeignClient;

    int retryCount;

    @Override
    public TripBean addTripDetails(TripBean request) {
        if (Objects.nonNull(request)) {
            TripEntity trip = TripEntity.builder()
                    .tripName(request.getTripName())
                    .description(request.getDescription())
                    .cost(request.getCost())
                    .fromDate(request.getFromDate())
                    .toDate(request.getToDate())
                    .cost(request.getCost())
                    .minCost(request.getMinCost())
                    .maxDiscount(request.getMaxDiscount()).build();

            trip = tripRepository.save(trip);
            BeanUtils.copyProperties(trip, request);
        }
        return request;
    }

    @Override
    public TripBean getTripById(String id) {
        TripBean response = new TripBean();
        Optional<TripEntity> trip = tripRepository.findById(id);
        if (trip.isPresent()) {
            BeanUtils.copyProperties(trip.get(), response);
        }
        return response;
    }

    @Override
    //@CircuitBreaker(name = "customPackageCircuitBreaker", fallbackMethod = "customPackageCircuitBreaker")
    //@Retry(name = "customPackageCircuitRetry", fallbackMethod = "customPackageCircuitBreaker")
    @RateLimiter(name ="CustomTripRateLimiter", fallbackMethod = "customPackageCircuitBreaker")
    public List<TripBean> getTrips() {
        List<TripEntity> trips = tripRepository.findAll();
        List<TripBean> responses = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(trips)) {
            trips.forEach(trip -> {
                TripBean response = new TripBean();
                BeanUtils.copyProperties(trip, response);
                responses.add(response);
            });
        }
        ResponseEntity<String> customPackages;
        System.out.print("Retry count: " + retryCount);
        System.out.println();
        retryCount++;

        //using rest template
        customPackages =
                restTemplate.getForEntity("http://CUSTOM-TRIP-SERVICE/custom-trip", String.class);
        log.info("Data received from custom - trip :" + customPackages.getBody());

        //using feign client
        /*customPackages = customTripServiceFeignClient.getCustomTrips();
        log.info("Data received from custom - trip :" + customPackages.getBody()); */

        return responses;
    }

    public List<TripBean> customPackageCircuitBreaker(Exception ex) {
        List<TripBean> responses = new ArrayList<>();
        System.out.println(" In fallback");
        return responses;
    }
}
