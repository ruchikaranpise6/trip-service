package com.girly.schtick.trip.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "trip")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TripEntity {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id")
    private String id;

    @Column(name = "trip_name")
    private String tripName;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "from_date")
    private long fromDate;

    @Column(name = "to_date")
    private long toDate;

    @Column(name ="cost")
    private double cost;

    @Column(name ="min_cost")
    private double minCost = cost;

    @Column(name ="max_discount")
    private double maxDiscount = 0d;

}
