package com.trippify.trippify.trip.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.trippify.trippify.common.model.StatusResponse;
import com.trippify.trippify.trip.model.reponse.TripRestResponse;
import com.trippify.trippify.trip.model.request.CreateTripRest;
import com.trippify.trippify.trip.service.TripService;

@CrossOrigin(origins = "http://localhost:4401", allowedHeaders = "*")
@RestController
@RequestMapping(path = "/trip")
public class TripController {

	@Autowired
	TripService tripService;

	@PostMapping(value = "/createTrip")
	public StatusResponse createTrip(@RequestBody CreateTripRest tripInput) {
		return tripService.createTrip(tripInput);
	}

	@GetMapping(value = "/getTrips")
	public TripRestResponse getAllTrips(@RequestParam("page") int page, @RequestParam("size") int size) {
		return tripService.findAllTrips(page, size);
	}

	@DeleteMapping(value = "/deleteTrip/{id}")
	public StatusResponse deleteTrip(@PathVariable Long id) {
		return tripService.deleteTrip(id);
	}
}
