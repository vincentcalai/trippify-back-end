package com.trippify.trippify.trip.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trippify.trippify.trip.view.TripView;

@Repository
public interface ITripDao extends JpaRepository<TripView, Long> {
}
