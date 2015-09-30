package com.binhpht.apps.dao;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the latude database table.
 * 
 */
@Entity
@NamedQuery(name="Latude.findAll", query="SELECT l FROM Latude l")
public class Latude implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String lat;

	private String lon;

	public Latude() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLat() {
		return this.lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLon() {
		return this.lon;
	}

	public void setLon(String lon) {
		this.lon = lon;
	}

}