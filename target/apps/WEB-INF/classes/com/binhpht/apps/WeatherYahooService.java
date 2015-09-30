package com.binhpht.apps;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.binhpht.apps.config.DataLocation;
import com.binhpht.apps.dao.Forecast;
import com.binhpht.apps.dao.ForecastNext;
import com.binhpht.apps.filters.Angstrom;
import com.binhpht.apps.filters.DateTimeVN;
import com.binhpht.apps.filters.VNCharacterUtils;

@Component("weatherYahooService")
public class WeatherYahooService {
	InputStream inputXml = null;
	String date = null;
	String low = null;
	String high = null;
	String text = null;
	String code = null;
	String day = null;
	private Float angstromLevel = (float) 0;
	private Integer lastUpdateNumber = 0;

	@Autowired
	private Forecast forecast;

	private ForecastNext forecastNext;
	private DataLocation dataLocation;
	StringBuilder weatherString;
	StringBuilder dateString;
	DateTimeVN dateTimeVN;

	public ForecastNext getForecastNext() {
		return forecastNext;
	}

	public void setForecastNext(ForecastNext forecastNext) {
		this.forecastNext = forecastNext;
	}

	private List<ForecastNext> forecastNexts;

	public Forecast getWeather(String woeid, java.util.Date date2) {
		try {
			inputXml = new URL("http://weather.yahooapis.com/forecastrss?w="
					+ woeid + "&u=c").openConnection().getInputStream();

			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();

			DocumentBuilder builder = null;

			try {
				builder = factory.newDocumentBuilder();
			} catch (ParserConfigurationException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Document doc = null;

			try {
				doc = builder.parse(inputXml);

			} catch (SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			doc.getDocumentElement().normalize();
			NodeList nodeList = doc.getElementsByTagName("channel");

			System.out.println("Root element :"
					+ doc.getDocumentElement().getNodeName());
			for (int temp = 0; temp < nodeList.getLength(); temp++) {
				forecast.setWoeid(woeid);
				NodeList buildDates = doc.getElementsByTagName("lastBuildDate");
				Element buildDate = (Element) buildDates.item(0);
				String strBuildDate = buildDate.getTextContent();
				System.out.println("Build Date: - " + strBuildDate);
				forecast.setLastBuildDate(strBuildDate);

				NodeList locations = doc
						.getElementsByTagName("yweather:location");
				Element location = (Element) locations.item(0);
				String strLocation = location.getAttribute("city");
				System.out.println("Location: - "
						+ VNCharacterUtils.removeAccent(strLocation));
				forecast.setWeatherlocation(strLocation);
				NodeList winds = doc.getElementsByTagName("yweather:wind");
				Element wind = (Element) winds.item(0);
				String chill = wind.getAttribute("chill");
				System.out.println("chill: - " + chill);
				String direction = wind.getAttribute("direction");
				System.out.println("direction: - " + direction);
				String speed = wind.getAttribute("speed");
				System.out.println("speed: - " + speed);
				forecast.setChill(chill);
				forecast.setSpeed(speed);

				NodeList atmospheres = doc
						.getElementsByTagName("yweather:atmosphere");
				Element atmosphere = (Element) atmospheres.item(0);
				String humidity = atmosphere.getAttribute("humidity");
				System.out.println("humidity " + humidity);
				String visibility = atmosphere.getAttribute("visibility");
				System.out.println("visibility " + visibility);

				String pressure = atmosphere.getAttribute("pressure");
				System.out.println("pressure " + pressure);

				String rising = atmosphere.getAttribute("rising");
				System.out.println("rising " + rising);

				forecast.setHumidity(humidity);
				forecast.setVisibility(visibility);
				forecast.setPressure(pressure);
				forecast.setRising(rising);
				NodeList astronomys = doc
						.getElementsByTagName("yweather:astronomy");
				Element astronomy = (Element) astronomys.item(0);
				String sunrise = astronomy.getAttribute("sunrise");
				System.out.println("sunrise " + sunrise);
				String sunset = astronomy.getAttribute("sunset");
				System.out.println("sunset " + sunset);
				forecast.setSunrise(sunrise);
				forecast.setSunset(sunset);

				NodeList urlImages = doc.getElementsByTagName("description");

				Element urlImage = (Element) urlImages.item(1);
				String imgRegex = "<img[^>]+src\\s*=\\s*['\"]([^'\"]+)['\"][^>]*>";
				Pattern p = Pattern.compile(imgRegex);
				Matcher m = p.matcher(urlImage.getTextContent());
				String urlYahoo = null;
				if (m.find()) {
					String src = m.group(1);
					urlYahoo = src;
				}
				System.out.println("Description images urlYahoo: " + urlYahoo);
				forecast.setUrlimage(urlYahoo);

				NodeList conditions = doc
						.getElementsByTagName("yweather:condition");
				Element condition = (Element) conditions.item(0);
				String conditionText = condition.getAttribute("text");
				String conditionCode = condition.getAttribute("code");
				String conditionTemp = condition.getAttribute("temp");
				String conditionDate = condition.getAttribute("date");
				forecast.setConditioncode(conditionCode);
				forecast.setConditiondate(conditionDate);
				forecast.setConditiontemp(conditionTemp);
				forecast.setConditiontext(conditionText);

				NodeList lats = doc.getElementsByTagName("geo:lat");

				Element lat = (Element) lats.item(0);
				System.out.println(lat.getTextContent());
				forecast.setGeoLat(lat.getTextContent());

				NodeList longs = doc.getElementsByTagName("geo:long");

				Element long1 = (Element) longs.item(0);
				System.out.println(long1.getTextContent());
				forecast.setGeoLong(long1.getTextContent());

				NodeList forecasts = doc
						.getElementsByTagName("yweather:forecast");
				forecastNexts = new ArrayList<ForecastNext>();
				Element weatherDescription = (Element) forecasts.item(0);
				dataLocation = new DataLocation();
				String weatherDes = weatherDescription.getAttribute("code");
				forecast.setWeatherdescription(dataLocation
						.returnWeather(weatherDes));
				weatherString = new StringBuilder();
				for (int i = 0; i < forecasts.getLength(); i++) {
					Element forecast = (Element) forecasts.item(i);
					System.out.println("Elements+:  " + i);
					forecastNext = new ForecastNext(
							forecast.getAttribute("date"),
							forecast.getAttribute("low"),
							forecast.getAttribute("high"),
							forecast.getAttribute("text"),
							forecast.getAttribute("code"),
							forecast.getAttribute("day"), this.forecast);
					weatherString.append(dataLocation.returnWeather(forecast
							.getAttribute("day")));
			
					dateTimeVN = new DateTimeVN();
					weatherString.append(" "+dateTimeVN.dateTimeVN(forecast.getAttribute("date")));
					weatherString.append(" Nhiệt độ "
							+ forecast.getAttribute("low"));
					weatherString.append(" - " + forecast.getAttribute("high"));

					weatherString.append(" Mô tả: "
							+ dataLocation.returnWeather(forecast
									.getAttribute("code")));
					weatherString.append("</br>");
					forecastNexts.add(forecastNext);

					System.out.println(forecast.getAttribute("day"));
					System.out.println(forecast.getAttribute("date"));
					System.out.println(forecast.getAttribute("low"));
					System.out.println(forecast.getAttribute("high"));
					System.out.println(forecast.getAttribute("code"));
					System.out.println(forecast.getAttribute("text"));

				}

				forecast.setForecastNext(forecastNexts);
				forecast.setForecastfulldesc(weatherString.toString());
				forecast.setAngstromLevel(Angstrom.calAngstrom(
						Float.parseFloat(chill), Float.parseFloat(humidity)));
				forecast.setLastUpdateNumber(1);

				forecast.setWeatherupdated(date2);

			}

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return forecast;

	}

	public Forecast getForestcast() {
		return forecast;
	}

	public void setForestcast(Forecast forestcast) {
		this.forecast = forestcast;
	}

	public float getAngstromLevel() {
		return angstromLevel;
	}

	public void setAngstromLevel(float angstromLevel) {
		this.angstromLevel = angstromLevel;
	}

	public int getLastUpdateNumber() {
		return lastUpdateNumber;
	}

	public void setLastUpdateNumber(int lastUpdateNumber) {
		this.lastUpdateNumber = lastUpdateNumber;
	}

}
