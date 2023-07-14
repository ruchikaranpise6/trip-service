package com.girly.schtick.trip.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TripBean {

    private String tripName;

    private String description;

    private long fromDate;

    private long toDate;

    private double cost;

    private double minCost;

    private double maxDiscount ;

    private String id;
}
