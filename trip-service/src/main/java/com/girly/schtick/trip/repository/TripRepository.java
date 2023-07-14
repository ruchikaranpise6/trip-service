package com.girly.schtick.trip.repository;

import com.girly.schtick.trip.entity.TripEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TripRepository extends JpaRepository<TripEntity,String> {
}
