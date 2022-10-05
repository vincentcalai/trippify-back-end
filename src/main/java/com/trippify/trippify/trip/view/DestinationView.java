package com.trippify.trippify.trip.view;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tb_dest")
@SequenceGenerator(name = "tripDestIdSeqGenerator", sequenceName = "S_TRIP_DEST_ID", allocationSize = 1)
public class DestinationView {

	private Long id;
	private Long tripId;
	private String name;
	private Date dateFrom;
	private Date dateTo;
	private Integer days;
	private String createdBy;
	private LocalDateTime createdDt;

//	@ManyToOne(fetch = FetchType.LAZY, optional = false)
//	@JoinColumn(name = "trip_id", nullable = false)
//	private TripView tripView;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tripDestIdSeqGenerator")
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

	@Column(name = "created_by", nullable = false)
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
