package com.trippify.trip.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.trippify.TestWithSpringBoot;
import com.trippify.trippify.common.model.StatusResponse;
import com.trippify.trippify.trip.model.BudgetVO;
import com.trippify.trippify.trip.model.DestinationVO;
import com.trippify.trippify.trip.model.ParticularsVO;
import com.trippify.trippify.trip.model.TripDetailsVO;
import com.trippify.trippify.trip.model.request.CreateTripRest;
import com.trippify.trippify.trip.service.TripService;

public class TestTripService extends TestWithSpringBoot {

	@Autowired
	private TripService tripService;

	@Test
	void regUserCreateTripSingleTripDestSuccessful() throws Exception {
		ParticularsVO particulars = new ParticularsVO();
		particulars.setEmail("TEST@TEST.COM");
		particulars.setName("TEST USER NAME");
		particulars.setRegUser(true);
		BudgetVO budget = new BudgetVO();
		budget.setAttractionBudget(new BigDecimal(500));
		budget.setFlightBudget(new BigDecimal(2000));
		budget.setFoodBudget(new BigDecimal(500));
		budget.setHotelBudget(new BigDecimal(1000));
		budget.setOtherBudget(new BigDecimal(1000));
		budget.setTotalBudget(new BigDecimal(5500));
		budget.setTransportBudget(new BigDecimal(500));
		budget.setManualCal(true);
		TripDetailsVO tripDetails = new TripDetailsVO();
		tripDetails.setNoOfDestinations(1);
		List<DestinationVO> destTripList = new ArrayList<>();
		DestinationVO dest1 = new DestinationVO();
		dest1.setCtryName("Malaysia");
		dest1.setCityName("Kuala Lumpur");
		dest1.setDateFromStr("24/10/2022");
		dest1.setDateToStr("31/10/2022");
		dest1.setDateFromDayName("MON");
		dest1.setDateToDayName("MON");
		dest1.setNoOfTripDays(8);
		destTripList.add(dest1);
		tripDetails.setDestinations(destTripList);
		CreateTripRest createTripRest = new CreateTripRest();
		createTripRest.setParticulars(particulars);
		createTripRest.setBudget(budget);
		createTripRest.setTripDetails(tripDetails);

		StatusResponse statusResponse = tripService.createTrip(createTripRest);
		assertEquals(0, statusResponse.getStatusCode());
	}
}
