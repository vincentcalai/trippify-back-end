package com.trippify.trippify.trip.model;

public class DestinationVO {

	private String ctryName;
	private String cityName;
	private String dateFromStr;
	private String dateFromDayName;
	private String dateToStr;
	private String dateToDayName;
	private int noOfTripDays;

	public String getCtryName() {
		return ctryName;
	}

	public void setCtryName(String ctryName) {
		this.ctryName = ctryName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
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
