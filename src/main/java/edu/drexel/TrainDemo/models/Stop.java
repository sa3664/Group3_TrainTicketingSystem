package edu.drexel.TrainDemo.models;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "stop")
public class Stop {

	@Id
	private String id;
	private String name;
	private BigDecimal lat;
	private BigDecimal lon;
	private String external_url;

	protected Stop() {
	}

	public Stop(String id, String name, BigDecimal lat, BigDecimal lon, String external_url) {
		this.id = id;
		this.name = name;
		this.lat = lat;
		this.lon = lon;
		this.external_url = external_url;
	}

	@Override
	public String toString() {
		return "Stop{" + "id='" + id + '\'' + ", name='" + name + '\'' + ", lat=" + lat + ", lon=" + lon
				+ " external_url=" + external_url + '}';
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getLat() {
		return lat;
	}

	public void setLat(BigDecimal lat) {
		this.lat = lat;
	}

	public BigDecimal getLon() {
		return lon;
	}

	public void setLon(BigDecimal lon) {
		this.lon = lon;
	}

	public String getExternal_url() {
		return external_url;
	}

	public void setExternal_url(String external_url) {
		this.external_url = external_url;
	}

}
