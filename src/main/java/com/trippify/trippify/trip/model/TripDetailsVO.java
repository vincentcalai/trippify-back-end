package com.trippify.trippify.trip.model;

import java.util.Date;

public class TripDetailsVO {

	public int noOfDestinations;
	public DestinationVO[] destinations;
	public String createdBy;
	public Date createdDt;

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

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDt() {
		return createdDt;
	}

	public void setCreatedDt(Date createdDt) {
		this.createdDt = createdDt;
	}

}
