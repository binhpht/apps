package com.binhpht.apps.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.binhpht.apps.dao.Forecast;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "forecastnext")
public class ForecastNext {

	public ForecastNext() {

	}

	public ForecastNext(String date, String low, String high, String text,
			String code, String day, Forecast forecast) {
		this.date = date;
		this.low = low;
		this.high = high;
		this.text = text;
		this.code = code;
		this.day = day;
		this.forecast = forecast;
	}

	public ForecastNext(String date, String low, String high, String text,
			String code, String day) {
		this.date = date;
		this.low = low;
		this.high = high;
		this.text = text;
		this.code = code;
		this.day = day;
	}

	public ForecastNext(int id, String date, String low, String high,
			String text, String code, String day, Forecast forecast) {
		this.id = id;
		this.date = date;
		this.low = low;
		this.high = high;
		this.text = text;
		this.code = code;
		this.day = day;
		this.setForecast(forecast);
	}

	@Id
	@GeneratedValue
	private int id;
	private String date;
	private String low;
	private String high;
	private String text;
	private String code;
	private String day;

	@ManyToOne
	@JoinColumn(name = "forecastid", referencedColumnName = "id")
	private Forecast forecast;

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getLow() {
		return low;
	}

	public void setLow(String low) {
		this.low = low;
	}

	public String getHigh() {
		return high;
	}

	public void setHigh(String high) {
		this.high = high;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Forecast getForecast() {
		return forecast;
	}

	public void setForecast(Forecast forecast) {
		this.forecast = forecast;
	}

}
