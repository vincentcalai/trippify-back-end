package com.trippify.trippify.trip.model.reponse;

import java.util.List;

import com.trippify.trippify.common.model.StatusResponse;

public class TripRestResponse extends StatusResponse {
	private List<TripRest> tripList;

	public List<TripRest> getTripList() {
		return tripList;
	}

	public void setTripList(List<TripRest> tripList) {
		this.tripList = tripList;
	}
}
