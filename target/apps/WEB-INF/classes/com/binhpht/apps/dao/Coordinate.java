package com.binhpht.apps.dao;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the coordinate database table.
 * 
 */
@Entity
@NamedQuery(name="Coordinate.findAll", query="SELECT c FROM Coordinate c")
public class Coordinate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String east;

	private String north;

	private String south;

	private String west;

	public Coordinate() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEast() {
		return this.east;
	}

	public void setEast(String east) {
		this.east = east;
	}

	public String getNorth() {
		return this.north;
	}

	public void setNorth(String north) {
		this.north = north;
	}

	public String getSouth() {
		return this.south;
	}

	public void setSouth(String south) {
		this.south = south;
	}

	public String getWest() {
		return this.west;
	}

	public void setWest(String west) {
		this.west = west;
	}

}