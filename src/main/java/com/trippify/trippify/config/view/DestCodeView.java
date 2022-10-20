package com.trippify.trippify.config.view;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_dest_cd")
public class DestCodeView {

	private long id;
	private String ctry;
	private String city;

	@Id
	@Column(name = "id", nullable = false, precision = 22, scale = 0)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "ctry", length = 100, nullable = false)
	public String getCtry() {
		return ctry;
	}

	public void setCtry(String ctry) {
		this.ctry = ctry;
	}

	@Column(name = "city", length = 100, nullable = false)
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
