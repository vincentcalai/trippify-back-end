package com.trippify.trippify.trip.model.reponse;

import org.springframework.data.domain.Page;

import com.trippify.trippify.common.model.StatusResponse;

public class TripRestResponse extends StatusResponse {
	private Page<TripRest> tripList;

	public Page<TripRest> getTripList() {
		return tripList;
	}

	public void setTripList(Page<TripRest> tripList) {
		this.tripList = tripList;
	}
}
