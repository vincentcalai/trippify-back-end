package com.trippify.trippify.trip.model.request;

import com.trippify.trippify.trip.model.BudgetVO;
import com.trippify.trippify.trip.model.ParticularsVO;
import com.trippify.trippify.trip.model.TripDetailsVO;

public class CreateTripRest {
	private ParticularsVO particulars;
	private BudgetVO budget;
	private TripDetailsVO tripDetails;

	public ParticularsVO getParticulars() {
		return particulars;
	}

	public void setParticulars(ParticularsVO particulars) {
		this.particulars = particulars;
	}

	public BudgetVO getBudget() {
		return budget;
	}

	public void setBudget(BudgetVO budget) {
		this.budget = budget;
	}

	public TripDetailsVO getTripDetails() {
		return tripDetails;
	}

	public void setTripDetails(TripDetailsVO tripDetails) {
		this.tripDetails = tripDetails;
	}

}
