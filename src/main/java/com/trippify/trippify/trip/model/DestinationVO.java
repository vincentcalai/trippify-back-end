package com.trippify.trippify.trip.model;

public class DestinationVO {

	public String name;
	public String dateFromStr;
	public String dateFromDayName;
	public String dateToStr;
	public String dateToDayName;
	public int noOfTripDays;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDateFromStr() {
		return dateFromStr;
	}

	public void setDateFromStr(String dateFromStr) {
		this.dateFromStr = dateFromStr;
	}

	public String getDateFromDayName() {
		return dateFromDayName;
	}

	public void setDateFromDayName(String dateFromDayName) {
		this.dateFromDayName = dateFromDayName;
	}

	public String getDateToStr() {
		return dateToStr;
	}

	public void setDateToStr(String dateToStr) {
		this.dateToStr = dateToStr;
	}

	public String getDateToDayName() {
		return dateToDayName;
	}

	public void setDateToDayName(String dateToDayName) {
		this.dateToDayName = dateToDayName;
	}

	public int getNoOfTripDays() {
		return noOfTripDays;
	}

	public void setNoOfTripDays(int noOfTripDays) {
		this.noOfTripDays = noOfTripDays;
	}
}
