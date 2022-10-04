package com.trippify.trippify.trip.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trippify.trippify.trip.dao.ITripDao;
import com.trippify.trippify.trip.model.reponse.AngularCreateTripResponse;
import com.trippify.trippify.trip.model.request.CreateTripRest;
import com.trippify.trippify.trip.view.TripView;

@Transactional
@Service
public class TripService {

	@Autowired
	public ITripDao tripDao;

	public AngularCreateTripResponse createTrip(CreateTripRest tripInput) {
		TripView newTripObj = new TripView();
		newTripObj.setName(tripInput.getParticulars().getName());
		newTripObj.setEmail(tripInput.getParticulars().getEmail());
		newTripObj.setAttractionBudget(tripInput.getBudget().getAttractionBudget());
		newTripObj.setFlightBudget(tripInput.getBudget().getFlightBudget());
		newTripObj.setFoodBudget(tripInput.getBudget().getFoodBudget());
		newTripObj.setHotelBudget(tripInput.getBudget().getHotelBudget());
		newTripObj.setOtherBudget(tripInput.getBudget().getOtherBudget());
		newTripObj.setTotalBudget(tripInput.getBudget().getTotalBudget());
		newTripObj.setTransportBudget(tripInput.getBudget().getTransportBudget());
		newTripObj.setNoOfDestinations(tripInput.getTripDetails().getNoOfDestinations());

		newTripObj.setCreatedBy("VINCENT");
		newTripObj.setCreatedDt(LocalDateTime.now());

		this.tripDao.save(newTripObj);
		return null;
	}
}
