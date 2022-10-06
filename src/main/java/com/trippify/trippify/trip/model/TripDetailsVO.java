package com.trippify.trippify.trip.model;

import java.util.List;

public class TripDetailsVO {

	private int noOfDestinations;
	private List<DestinationVO> destinations;

	public int getNoOfDestinations() {
		return noOfDestinations;
	}

	public void setNoOfDestinations(int noOfDestinations) {
		this.noOfDestinations = noOfDestinations;
	}

	public List<DestinationVO> getDestinations() {
		return destinations;
	}

	public void setDestinations(List<DestinationVO> destinations) {
		this.destinations = destinations;
	}

}
