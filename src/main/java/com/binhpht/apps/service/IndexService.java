package com.binhpht.apps.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.binhpht.apps.dao.Forecast;
import com.binhpht.apps.dao.ForecastDao;
import com.binhpht.apps.dao.Location;
import com.binhpht.apps.dao.LocationDao;

@Service("indexService")
public class IndexService {
	@Autowired
	private LocationDao locationDao;
	private ForecastDao forcastDao;
	@Autowired
	private List<Forecast> forecast;

	public ForecastDao getForcastDao() {
		return forcastDao;
	}

	@Autowired
	public void setForcastDao(ForecastDao forcastDao) {
		this.forcastDao = forcastDao;
	}

	public List<Forecast> getAllForecast()

	{
		forecast = forcastDao.getAllWeather();
		return forecast;

	}

	public void getValuebyWoeid(String woeid) {
		Forecast a = forcastDao.getWeatherByWoeid("91884946");
		System.out.println("nhiet do" + a.getChill());
	}

	public List<Forecast> getAllWeather() {
		return forcastDao.getAllWeather();
	}

	public List<Location> getAllocation() {
		// TODO Auto-generated method stub
		return locationDao.getAllLocation();
	}

	public LocationDao getLocationDao() {
		return locationDao;
	}

	public void setLocationDao(LocationDao locationDao) {
		this.locationDao = locationDao;
	}

	public List<Forecast> getWeatherbyID(int id) {
		// TODO Auto-generated method stub
		return forcastDao.getAllWeatherbyIdLocation(id);
	}

	public List<Location> getAllLocation(int locationID) {
		// TODO Auto-generated method stub
		return locationDao.getAllLocation(locationID);
	}

	public String getUpdatedTime() {
		// TODO Auto-generated method stub
		return forcastDao.updatedTime();
	}

	
}
