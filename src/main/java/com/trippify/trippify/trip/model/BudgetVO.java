package com.trippify.trippify.trip.model;

import java.math.BigDecimal;

public class BudgetVO {

	private boolean isManualCal;
	private BigDecimal flightBudget;
	private BigDecimal hotelBudget;
	private BigDecimal attractionBudget;
	private BigDecimal transportBudget;
	private BigDecimal foodBudget;
	private BigDecimal otherBudget;
	private BigDecimal totalBudget;

	public boolean isManualCal() {
		return isManualCal;
	}

	public void setManualCal(boolean isManualCal) {
		this.isManualCal = isManualCal;
	}

	public BigDecimal getFlightBudget() {
		return flightBudget;
	}

	public void setFlightBudget(BigDecimal flightBudget) {
		this.flightBudget = flightBudget;
	}

	public BigDecimal getHotelBudget() {
		return hotelBudget;
	}

	public void setHotelBudget(BigDecimal hotelBudget) {
		this.hotelBudget = hotelBudget;
	}

	public BigDecimal getAttractionBudget() {
		return attractionBudget;
	}

	public void setAttractionBudget(BigDecimal attractionBudget) {
		this.attractionBudget = attractionBudget;
	}

	public BigDecimal getTransportBudget() {
		return transportBudget;
	}

	public void setTransportBudget(BigDecimal transportBudget) {
		this.transportBudget = transportBudget;
	}

	public BigDecimal getFoodBudget() {
		return foodBudget;
	}

	public void setFoodBudget(BigDecimal foodBudget) {
		this.foodBudget = foodBudget;
	}

	public BigDecimal getOtherBudget() {
		return otherBudget;
	}

	public void setOtherBudget(BigDecimal otherBudget) {
		this.otherBudget = otherBudget;
	}

	public BigDecimal getTotalBudget() {
		return totalBudget;
	}

	public void setTotalBudget(BigDecimal totalBudget) {
		this.totalBudget = totalBudget;
	}

}
