package com.binhpht.apps;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.binhpht.apps.config.DataLocation;
import com.binhpht.apps.dao.Forecast;
import com.binhpht.apps.dao.ForecastDao;

@Component
public class AppService {
	@Autowired
	ForecastDao forecastDao;
	Forecast forecast;

	@Autowired
	WeatherYahooService weatherYahooService;

	public void saveWeather(String woeid,java.util.Date date) {
		forecast = new Forecast();
		forecast = weatherYahooService.getWeather(woeid, date);
		forecastDao.saveForestcast(forecast);

	}

	public void updateWeather() {
		DataLocation data = new DataLocation();
		java.util.Date dt = new java.util.Date();
	    Timestamp timestamp = new Timestamp(dt.getTime());
		for (String strLeThuy : data.createData()) {
			System.out.println("List code"+strLeThuy);
			saveWeather(strLeThuy, timestamp);
		}

	}

}
