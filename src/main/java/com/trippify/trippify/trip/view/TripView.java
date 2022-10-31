package com.trippify.trippify.trip.view;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_trip")
public class TripView {
	private Long id;
	private String name;
	private String email;

	private BigDecimal flightBudget;
	private BigDecimal hotelBudget;
	private BigDecimal attractionBudget;
	private BigDecimal transportBudget;
	private BigDecimal foodBudget;
	private BigDecimal otherBudget;
	private BigDecimal totalBudget;

	private Integer noOfDestinations;
	private List<DestinationView> destinations;

	private String createdBy;
	private LocalDateTime createdDt;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false, precision = 22, scale = 0)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "name", length = 66, nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "email", length = 100, nullable = false)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "flight_bgt", nullable = false)
	public BigDecimal getFlightBudget() {
		return flightBudget;
	}

	public void setFlightBudget(BigDecimal flightBudget) {
		this.flightBudget = flightBudget;
	}

	@Column(name = "hotel_bgt", nullable = false)
	public BigDecimal getHotelBudget() {
		return hotelBudget;
	}

	public void setHotelBudget(BigDecimal hotelBudget) {
		this.hotelBudget = hotelBudget;
	}

	@Column(name = "att_bgt", nullable = false)
	public BigDecimal getAttractionBudget() {
		return attractionBudget;
	}

	public void setAttractionBudget(BigDecimal attractionBudget) {
		this.attractionBudget = attractionBudget;
	}

	@Column(name = "trsp_bgt", nullable = false)
	public BigDecimal getTransportBudget() {
		return transportBudget;
	}

	public void setTransportBudget(BigDecimal transportBudget) {
		this.transportBudget = transportBudget;
	}

	@Column(name = "food_bgt", nullable = false)
	public BigDecimal getFoodBudget() {
		return foodBudget;
	}

	public void setFoodBudget(BigDecimal foodBudget) {
		this.foodBudget = foodBudget;
	}

	@Column(name = "other_bgt", nullable = false)
	public BigDecimal getOtherBudget() {
		return otherBudget;
	}

	public void setOtherBudget(BigDecimal otherBudget) {
		this.otherBudget = otherBudget;
	}

	@Column(name = "total_bgt", nullable = false)
	public BigDecimal getTotalBudget() {
		return totalBudget;
	}

	public void setTotalBudget(BigDecimal totalBudget) {
		this.totalBudget = totalBudget;
	}

	@Column(name = "no_of_dest", nullable = false)
	public Integer getNoOfDestinations() {
		return noOfDestinations;
	}

	public void setNoOfDestinations(Integer noOfDestinations) {
		this.noOfDestinations = noOfDestinations;
	}

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "trip_id", referencedColumnName = "id")
	public List<DestinationView> getDestinations() {
		return destinations;
	}

	public void setDestinations(List<DestinationView> destinations) {
		this.destinations = destinations;
	}

	@Column(name = "created_by", length = 20, nullable = false)
	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Column(name = "created_dt", nullable = false)
	public LocalDateTime getCreatedDt() {
		return createdDt;
	}

	public void setCreatedDt(LocalDateTime createdDt) {
		this.createdDt = createdDt;
	}

}