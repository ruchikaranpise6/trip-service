package com.girly.schtick.trip.service;

import com.girly.schtick.trip.bean.TripBean;

import java.util.List;

public interface TripService {

    TripBean addTripDetails(TripBean request);

    TripBean getTripById(String id);

    List<TripBean> getTrips();
}
