package com.trippify.trippify.trip.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trippify.trippify.trip.dao.IDestinationDao;
import com.trippify.trippify.trip.dao.ITripDao;
import com.trippify.trippify.trip.model.reponse.AngularCreateTripResponse;
import com.trippify.trippify.trip.model.request.CreateTripRest;
import com.trippify.trippify.trip.view.DestinationView;
import com.trippify.trippify.trip.view.TripView;

@Transactional
@Service
public class TripService {

	@Autowired
	public ITripDao tripDao;

	@Autowired
	public IDestinationDao destDao;

	public AngularCreateTripResponse createTrip(CreateTripRest tripInput) {
		List<DestinationView> destinationList = new ArrayList<>();
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

		Arrays.stream(tripInput.getTripDetails().getDestinations()).forEach(destination -> {

			DestinationView destinationView = new DestinationView();
			destinationView.setName(destination.getName());
			destinationView.setDays(destination.getNoOfTripDays());
			destinationView.setCreatedBy("VINCENT");
			destinationView.setCreatedDt(LocalDateTime.now());

			try {
				Date dateFrom = new SimpleDateFormat("dd/MM/yyyy").parse(destination.getDateFromStr());
				Date dateTo = new SimpleDateFormat("dd/MM/yyyy").parse(destination.getDateFromStr());
				destinationView.setDateFrom(dateFrom);
				destinationView.setDateTo(dateTo);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			destinationList.add(destinationView);
		});

		newTripObj.setDestinations(destinationList);

		this.tripDao.save(newTripObj);
		return null;
	}
}
