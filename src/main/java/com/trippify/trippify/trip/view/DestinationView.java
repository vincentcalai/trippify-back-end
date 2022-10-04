package com.trippify.trippify.trip.view;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "tb_dest")
public class DestinationView {

	private Long id;
	private String name;
	private Date dateFrom;
	private Date dateTo;
	private Integer days;
	private String createdBy;
	private Date createdDt;

	private TripView tripView;

	@Id
	@Column(name = "id", nullable = false, precision = 22, scale = 0)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "name", length = 100, nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "date_from", nullable = false)
	public Date getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}

	@Column(name = "date_to", nullable = false)
	public Date getDateTo() {
		return dateTo;
	}

	public void setDateTo(Date dateTo) {
		this.dateTo = dateTo;
	}

	@Column(name = "days", nullable = true)
	public Integer getDays() {
		return days;
	}

	public void setDays(Integer days) {
		this.days = days;
	}

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumns({
			@JoinColumn(name = "id", referencedColumnName = "id", unique = true, nullable = false, insertable = false, updatable = false) })
	@OnDelete(action = OnDeleteAction.CASCADE)
	public TripView getTripView() {
		return tripView;
	}

	public void setTripView(TripView tripView) {
		this.tripView = tripView;
	}

	@Column(name = "created_by", nullable = false)
	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Column(name = "created_dt", nullable = false)
	public Date getCreatedDt() {
		return createdDt;
	}

	public void setCreatedDt(Date createdDt) {
		this.createdDt = createdDt;
	}

}
