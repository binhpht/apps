package com.binhpht.apps.filters;

import com.binhpht.apps.config.DataLocation;

public class DateTimeVN {
	DataLocation dataLocation;

	public StringBuilder dateTimeVN(String date) {
		StringBuilder builder = new StringBuilder();
		StringBuilder stringBuilder = new StringBuilder(date);
		dataLocation = new DataLocation();
	
		if (stringBuilder.length() >= 11) {
			String firstDate = date.substring(0, 2);
			String month = date.substring(2, 6);
			String year = date.substring(7, 11);
			builder.append(firstDate).append("/")
					.append(dataLocation.returnWeather(month.trim()))
					.append("/").append(year);

		}
		if (stringBuilder.length() < 11) {
			String firstDate = date.substring(0, 1);
			String month = date.substring(1, 5);
			String year = date.substring(6, 10);
			builder.append(firstDate).append("/")
					.append(dataLocation.returnWeather(month.trim()))
					.append("/").append(year);

		}
		return builder;

	
	}
}
