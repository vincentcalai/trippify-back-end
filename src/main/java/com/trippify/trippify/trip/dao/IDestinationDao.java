package com.trippify.trippify.trip.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trippify.trippify.trip.view.DestinationView;

@Repository
public interface IDestinationDao extends JpaRepository<DestinationView, Long> {

}
