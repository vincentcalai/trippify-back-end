package com.trippify.trip.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trippify.TestWithSpringBoot;
import com.trippify.trippify.trip.model.BudgetVO;
import com.trippify.trippify.trip.model.DestinationVO;
import com.trippify.trippify.trip.model.ParticularsVO;
import com.trippify.trippify.trip.model.TripDetailsVO;
import com.trippify.trippify.trip.model.request.CreateTripRest;

public class TestTripController extends TestWithSpringBoot {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objMapper;

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

	@Test
	void testCreateTrip() throws Exception {
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

		String request = objMapper.writeValueAsString(createSingleTripRest);
		RequestBuilder requestBuilt = MockMvcRequestBuilders.post("/trip/createTrip").content(request)
				.contentType(MediaType.APPLICATION_JSON);
		this.mockMvc.perform(requestBuilt).andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	void testGetAllTrips() throws Exception {
		RequestBuilder requestBuilt = MockMvcRequestBuilders.get("/trip/getTrips").param("page", "1")
				.param("size", "10").contentType(MediaType.APPLICATION_JSON);
		this.mockMvc.perform(requestBuilt).andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	void testDeleteTrip() throws Exception {
		RequestBuilder requestBuilt = MockMvcRequestBuilders.delete("/trip/deleteTrip/{id}", 100L)
				.contentType(MediaType.APPLICATION_JSON);
		this.mockMvc.perform(requestBuilt).andExpect(MockMvcResultMatchers.status().isOk());
	}

}
