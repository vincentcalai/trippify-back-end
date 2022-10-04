package com.trippify.trippify.trip.model;

public class TripDetailsVO {

	private int noOfDestinations;
	private DestinationVO[] destinations;

	public int getNoOfDestinations() {
		return noOfDestinations;
	}

	public void setNoOfDestinations(int noOfDestinations) {
		this.noOfDestinations = noOfDestinations;
	}

	public DestinationVO[] getDestinations() {
		return destinations;
	}

	public void setDestinations(DestinationVO[] destinations) {
		this.destinations = destinations;
	}

}
