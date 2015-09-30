package com.binhpht.apps.dao;

import java.io.Serializable;

import javax.persistence.*;

/**
 * The persistent class for the Location database table.
 * 
 */
@Entity
@NamedQuery(name = "Location.findAll", query = "SELECT l FROM Location l")
public class Location implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private int coordinateid;

	private String country;

	private int district;

	private String lat;

	private int latudeid;

	private String locality;

	@Column(name = "long")
	private String long_;

	private String name;

	private String ne;

	private String postcode;

	private String province;

	private String sforest;

	private String sw;

	private String tforest;

	private String woeid;

	public Location() {
	}

	public Location(String lat, String locality, String long_, String name,
			String sforest, String woeid) {
		this.lat = lat;
		this.locality = locality;
		this.long_ = long_;
		this.name = name;
		this.sforest = sforest;
		this.woeid = woeid;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCoordinateid() {
		return this.coordinateid;
	}

	public void setCoordinateid(int coordinateid) {
		this.coordinateid = coordinateid;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getDistrict() {
		return this.district;
	}

	public void setDistrict(int district) {
		this.district = district;
	}

	public String getLat() {
		return this.lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public int getLatudeid() {
		return this.latudeid;
	}

	public void setLatudeid(int latudeid) {
		this.latudeid = latudeid;
	}

	public String getLocality() {
		return this.locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getLong_() {
		return this.long_;
	}

	public void setLong_(String long_) {
		this.long_ = long_;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNe() {
		return this.ne;
	}

	public void setNe(String ne) {
		this.ne = ne;
	}

	public String getPostcode() {
		return this.postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getSforest() {
		return this.sforest;
	}

	public void setSforest(String sforest) {
		this.sforest = sforest;
	}

	public String getSw() {
		return this.sw;
	}

	public void setSw(String sw) {
		this.sw = sw;
	}

	public String getTforest() {
		return this.tforest;
	}

	public void setTforest(String tforest) {
		this.tforest = tforest;
	}

	public String getWoeid() {
		return this.woeid;
	}

	public void setWoeid(String woeid) {
		this.woeid = woeid;
	}

	@Override
	public String toString() {
		return "[" + lat + "," + long_ + ","+"'" + locality
				+ "'" + ","+"'" + name + "'" + "," +"'"+ sforest+"'"
				+ "," + woeid + "]";
	}

}