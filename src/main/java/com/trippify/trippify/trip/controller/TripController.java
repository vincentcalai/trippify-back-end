package com.trippify.trippify.trip.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trippify.trippify.trip.model.reponse.AngularHttpResponse;
import com.trippify.trippify.trip.model.request.CreateTripRest;

@CrossOrigin(origins = "http://localhost:4401", allowedHeaders = "*")
@RestController
@RequestMapping(path = "/trip")
public class TripController {
	@PostMapping(value = "/create-trip")
	public AngularHttpResponse createTrip(@RequestBody CreateTripRest tripInput) {
		System.out.println("TEST OK");
		AngularHttpResponse response = new AngularHttpResponse();
		response.setResponseValue("test");
		return response;
	}
}
