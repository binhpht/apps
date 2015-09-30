package com.binhpht.apps.dao;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.criterion.Projections;
import org.springframework.stereotype.Component;

/**
 * The persistent class for the forestcast database table.
 * 
 */
@Component
@Entity
@Table(name = "forecast")
public class Forecast implements Serializable {

	public Forecast(String woeid, String geoLat) {
		this.woeid = woeid;
		this.geoLat = geoLat;
	}

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String weatherlocation;
	private String cddata;
    private String weatherdescription;
	private String chill;

	private String conditioncode;

	private String conditiondate;

	private String conditiontemp;

	private String conditiontext;

	private String distance;

	private String lastBuildDate;

	private String pressure;

	private String speed;

	private String sunrise;

	private String sunset;

	private String temperature;

	private String visibility;

	private String weathercol;
	private String woeid;
	private String humidity;
	private String rising;
	private String geoLat;
	private String geoLong;
	private Integer angstromLevel;
	private Integer lastUpdateNumber;
	private String urlimage;
	private String levelurl;
	private String forecastfulldesc;
	@Temporal(TemporalType.TIMESTAMP)
	private Date weatherupdated;
	@OneToMany(mappedBy = "forecast")
	private List<ForecastNext> forecastNext;

	public Forecast() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCddata() {
		return this.cddata;
	}

	public void setCddata(String cddata) {
		this.cddata = cddata;
	}

	public String getChill() {
		return this.chill;
	}

	public void setChill(String chill) {
		this.chill = chill;
	}

	public String getConditioncode() {
		return this.conditioncode;
	}

	public void setConditioncode(String conditioncode) {
		this.conditioncode = conditioncode;
	}

	public String getConditiondate() {
		return this.conditiondate;
	}

	public void setConditiondate(String conditiondate) {
		this.conditiondate = conditiondate;
	}

	public String getConditiontemp() {
		return this.conditiontemp;
	}

	public void setConditiontemp(String conditiontemp) {
		this.conditiontemp = conditiontemp;
	}

	public String getConditiontext() {
		return this.conditiontext;
	}

	public void setConditiontext(String conditiontext) {
		this.conditiontext = conditiontext;
	}

	public String getDistance() {
		return this.distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	public String getLastBuildDate() {
		return this.lastBuildDate;
	}

	public void setLastBuildDate(String lastBuildDate) {
		this.lastBuildDate = lastBuildDate;
	}

	public String getPressure() {
		return this.pressure;
	}

	public void setPressure(String pressure) {
		this.pressure = pressure;
	}

	public String getSpeed() {
		return this.speed;
	}

	public void setSpeed(String speed) {
		this.speed = speed;
	}

	public String getSunrise() {
		return this.sunrise;
	}

	public void setSunrise(String sunrise) {
		this.sunrise = sunrise;
	}

	public String getSunset() {
		return this.sunset;
	}

	public void setSunset(String sunset) {
		this.sunset = sunset;
	}

	public String getTemperature() {
		return this.temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	public String getVisibility() {
		return this.visibility;
	}

	public void setVisibility(String visibility) {
		this.visibility = visibility;
	}

	public String getWeathercol() {
		return this.weathercol;
	}

	public void setWeathercol(String weathercol) {
		this.weathercol = weathercol;
	}

	public String getWoeid() {
		return this.woeid;
	}

	public void setWoeid(String woeid) {
		this.woeid = woeid;
	}

	public List<ForecastNext> getForecastNext() {
		return forecastNext;
	}

	public void setForecastNext(List<ForecastNext> forecastNext) {
		this.forecastNext = forecastNext;
	}

	public String getHumidity() {
		return humidity;
	}

	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}

	public String getRising() {
		return rising;
	}

	public void setRising(String rising) {
		this.rising = rising;
	}

	public String getGeoLat() {
		return geoLat;
	}

	public void setGeoLat(String geoLat) {
		this.geoLat = geoLat;
	}

	public String getGeoLong() {
		return geoLong;
	}

	public void setGeoLong(String geoLong) {
		this.geoLong = geoLong;
	}

	public Integer getAngstromLevel() {
		return angstromLevel;
	}

	public void setAngstromLevel(Integer angstromLevel) {
		this.angstromLevel = angstromLevel;
	}

	public Integer getLastUpdateNumber() {
		return lastUpdateNumber;
	}

	public void setLastUpdateNumber(Integer lastUpdateNumber) {
		this.lastUpdateNumber = lastUpdateNumber;
	}

	public String getUrlimage() {
		return urlimage;
	}

	public void setUrlimage(String urlimage) {
		this.urlimage = urlimage;
	}

	public String getWeatherlocation() {
		return weatherlocation;
	}

	public void setWeatherlocation(String weatherlocation) {
		this.weatherlocation = weatherlocation;
	}

	public Date getWeatherupdated() {
		return weatherupdated;
	}

	public void setWeatherupdated(Date weatherupdated) {
		this.weatherupdated = weatherupdated;
	}

	public Forecast(String woeid, String geoLat, String geoLong,
			String weatherlocation, Integer angstromLevel, String chill,
			String urlimage,String weatherdescription,String forecastfulldesc) {
		this.woeid = woeid;
		this.geoLat = geoLat;
		this.geoLong = geoLong;
		this.weatherlocation = weatherlocation;
		this.angstromLevel = angstromLevel;
		this.chill = chill;
		this.urlimage = urlimage;
		this.weatherdescription=weatherdescription;
		this.forecastfulldesc = forecastfulldesc;

	}

	@Override
	public String toString() {
		return "[" + "'" + weatherlocation + "'" + "," + chill + ","
				+ temperature + "," + woeid + "," + geoLat + "," + geoLong
				+ "," + angstromLevel + "," + lastUpdateNumber + "," 
				+ "'"+urlimage +"'"+","+ "'"+weatherdescription+"'"+","+"'"+forecastfulldesc+"'"+"]";
	}

	public String getWeatherdescription() {
		return weatherdescription;
	}

	public void setWeatherdescription(String weatherdescription) {
		this.weatherdescription = weatherdescription;
	}

	public String getForecastfulldesc() {
		return forecastfulldesc;
	}

	public void setForecastfulldesc(String forecastfulldesc) {
		this.forecastfulldesc = forecastfulldesc;
	}

	public String getLevelurl() {
		return levelurl;
	}

	public void setLevelurl(String levelurl) {
		this.levelurl = levelurl;
	}

	

}