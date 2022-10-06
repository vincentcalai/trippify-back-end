package com.trippify.trippify.trip.model.reponse;

import java.time.LocalDateTime;

import com.trippify.trippify.trip.model.BudgetVO;
import com.trippify.trippify.trip.model.ParticularsVO;
import com.trippify.trippify.trip.model.TripDetailsVO;

public class TripRest {
	private Long id;
	private ParticularsVO particulars;
	private BudgetVO budget;
	private TripDetailsVO tripDetails;
	private String createdBy;
	private LocalDateTime createdDt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDateTime getCreatedDt() {
		return createdDt;
	}

	public void setCreatedDt(LocalDateTime createdDt) {
		this.createdDt = createdDt;
	}

}
