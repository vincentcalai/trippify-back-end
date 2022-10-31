package com.trippify.trip.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.trippify.TestWithSpringBoot;
import com.trippify.trippify.common.model.StatusResponse;
import com.trippify.trippify.trip.dao.ITripDao;
import com.trippify.trippify.trip.model.BudgetVO;
import com.trippify.trippify.trip.model.DestinationVO;
import com.trippify.trippify.trip.model.ParticularsVO;
import com.trippify.trippify.trip.model.TripDetailsVO;
import com.trippify.trippify.trip.model.reponse.TripRest;
import com.trippify.trippify.trip.model.reponse.TripRestResponse;
import com.trippify.trippify.trip.model.request.CreateTripRest;
import com.trippify.trippify.trip.service.TripService;
import com.trippify.trippify.trip.view.TripView;

public class TestTripService extends TestWithSpringBoot {

	@Autowired
	private TripService tripService;

	@Autowired
	public ITripDao tripDao;

	public ParticularsVO setupParticulars() {
		ParticularsVO particulars = new ParticularsVO();
		particulars.setEmail("TEST@TEST.COM");
		particulars.setName("TEST USER NAME");
		particulars.setRegUser(true);
		return particulars;
	}

	public BudgetVO setupBudgetVO() {
		BudgetVO budget = new BudgetVO();
		budget.setAttractionBudget(new BigDecimal(500));
		budget.setFlightBudget(new BigDecimal(2000));
		budget.setFoodBudget(new BigDecimal(500));
		budget.setHotelBudget(new BigDecimal(1000));
		budget.setOtherBudget(new BigDecimal(1000));
		budget.setTotalBudget(new BigDecimal(5500));
		budget.setTransportBudget(new BigDecimal(500));
		budget.setManualCal(true);
		return budget;
	}

	public List<DestinationVO> setupSingleTripDestination() {
		List<DestinationVO> singleTripDestList = new ArrayList<>();
		DestinationVO dest1 = new DestinationVO();
		dest1.setCtryName("Malaysia");
		dest1.setCityName("Kuala Lumpur");
		dest1.setDateFromStr("24/10/2022");
		dest1.setDateToStr("31/10/2022");
		dest1.setDateFromDayName("MON");
		dest1.setDateToDayName("MON");
		dest1.setNoOfTripDays(8);
		singleTripDestList.add(dest1);
		return singleTripDestList;
	}

	public List<DestinationVO> setupMultiTripDestination() {
		List<DestinationVO> multiTripDestList = new ArrayList<>();

		DestinationVO dest1 = new DestinationVO();
		dest1.setCtryName("Malaysia");
		dest1.setCityName("Kuala Lumpur");
		dest1.setDateFromStr("24/10/2022");
		dest1.setDateToStr("31/10/2022");
		dest1.setDateFromDayName("MON");
		dest1.setDateToDayName("MON");
		dest1.setNoOfTripDays(8);

		DestinationVO dest2 = new DestinationVO();
		dest2.setCtryName("Thailand");
		dest2.setCityName("Hat Yai");
		dest2.setDateFromStr("31/10/2022");
		dest2.setDateToStr("07/11/2022");
		dest2.setDateFromDayName("MON");
		dest2.setDateToDayName("MON");
		dest2.setNoOfTripDays(8);

		DestinationVO dest3 = new DestinationVO();
		dest3.setCtryName("China");
		dest3.setCityName("Shen Zhen");
		dest3.setDateFromStr("07/10/2022");
		dest3.setDateToStr("14/11/2022");
		dest3.setDateFromDayName("MON");
		dest3.setDateToDayName("MON");
		dest3.setNoOfTripDays(8);

		multiTripDestList.add(dest1);
		multiTripDestList.add(dest2);
		multiTripDestList.add(dest3);
		return multiTripDestList;
	}

	@Test
	void createTripSingleTripDestSuccessful() throws Exception {
		ParticularsVO particulars = setupParticulars();
		BudgetVO budget = setupBudgetVO();

		TripDetailsVO tripDetails = new TripDetailsVO();
		tripDetails.setNoOfDestinations(1);
		List<DestinationVO> singleDestTripList = setupSingleTripDestination();
		tripDetails.setDestinations(singleDestTripList);
		CreateTripRest createSingleTripRest = new CreateTripRest();
		createSingleTripRest.setParticulars(particulars);
		createSingleTripRest.setBudget(budget);
		createSingleTripRest.setTripDetails(tripDetails);

		StatusResponse statusResponse = tripService.createTrip(createSingleTripRest);
		assertEquals(0, statusResponse.getStatusCode());
		assertEquals("Trip was created successfully.", statusResponse.getResultMessage());

		Optional<TripView> result = this.tripDao.findById(104L);
		assertFalse(result.isEmpty());
	}

	@Test
	void createTripMultiTripDestSuccessful() throws Exception {
		ParticularsVO particulars = setupParticulars();
		BudgetVO budget = setupBudgetVO();

		TripDetailsVO tripDetails = new TripDetailsVO();
		tripDetails.setNoOfDestinations(1);
		List<DestinationVO> multiDestTripList = setupMultiTripDestination();
		tripDetails.setDestinations(multiDestTripList);
		CreateTripRest createMultiTripRest = new CreateTripRest();
		createMultiTripRest.setParticulars(particulars);
		createMultiTripRest.setBudget(budget);
		createMultiTripRest.setTripDetails(tripDetails);

		StatusResponse statusResponse = tripService.createTrip(createMultiTripRest);
		assertEquals(0, statusResponse.getStatusCode());
		assertEquals("Trip was created successfully.", statusResponse.getResultMessage());

		Optional<TripView> result1 = this.tripDao.findById(104L);
		assertFalse(result1.isEmpty());
	}

	@Test
	void createTripFail_invalidDate() throws Exception {
		ParticularsVO particulars = setupParticulars();
		BudgetVO budget = setupBudgetVO();

		TripDetailsVO tripDetails = new TripDetailsVO();
		tripDetails.setNoOfDestinations(1);
		List<DestinationVO> singleTripDestList = new ArrayList<>();
		DestinationVO dest1 = new DestinationVO();
		dest1.setCtryName("Malaysia");
		dest1.setCityName("Kuala Lumpur");
		dest1.setDateFromStr("24/10/2022");
		dest1.setDateToStr("aa/11/2022");
		dest1.setDateFromDayName("MON");
		dest1.setDateToDayName("MON");
		dest1.setNoOfTripDays(8);
		singleTripDestList.add(dest1);

		tripDetails.setDestinations(singleTripDestList);
		CreateTripRest createMultiTripRest = new CreateTripRest();
		createMultiTripRest.setParticulars(particulars);
		createMultiTripRest.setBudget(budget);
		createMultiTripRest.setTripDetails(tripDetails);

		StatusResponse statusResponse = tripService.createTrip(createMultiTripRest);
		assertEquals(1, statusResponse.getStatusCode());
		assertEquals("Exception parsing dateFrom or dateTo", statusResponse.getResultMessage());

		Optional<TripView> result1 = this.tripDao.findById(104L);
		assertTrue(result1.isEmpty());
	}

	@Test
	void findAllTripsSuccess() throws Exception {
		TripRestResponse tripRestResponse = new TripRestResponse();
		tripRestResponse = tripService.findAllTrips(1, 10);
		List<TripRest> result = tripRestResponse.getTripList().get().toList();
		assertEquals(4, result.size());
	}

	@Test
	void deleteTripSuccess() throws Exception {
		tripService.deleteTrip(103L);
		long count = tripDao.count();
		assertEquals(3, count);
	}
}
