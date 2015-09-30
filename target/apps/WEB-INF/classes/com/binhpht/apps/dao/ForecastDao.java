package com.binhpht.apps.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
@Component("forecastDao")
public class ForecastDao {
	@Autowired
	private SessionFactory sessionFactory;

	public Session session() {

		return sessionFactory.getCurrentSession();

	}

	@Transactional
	public void saveForestcast(Forecast forest) {
		System.out.println("Save forecast for WOEID=: " + forest.getWoeid());
		session().save(forest);
		for (ForecastNext forecastNext2 : forest.getForecastNext()) {
			if (null != forecastNext2) {
				session().save(forecastNext2);

			}

		}

	}

	public Forecast getWeatherByWoeid(String woeid) {
		Query query = session().createQuery(
				"from Forecast where woeid = :woeid");
		query.setParameter("woeid", woeid);
		return (Forecast) query.list().get(0);
	}

	public List<Forecast> getAllWeather() {
		DetachedCriteria maxQuery = DetachedCriteria.forClass(Forecast.class);
		maxQuery.setProjection(Projections.max("weatherupdated"));
		Criteria query = session().createCriteria(Forecast.class);
		query.add(Property.forName("weatherupdated").eq(maxQuery));
		query.setProjection(Projections
				.projectionList()
				.add(Projections.property("woeid"), "woeid")
				.add(Projections.property("geoLat"), "geoLat")
				.add(Projections.property("geoLong"), "geoLong")
				.add(Projections.property("weatherlocation"), "weatherlocation")
				.add(Projections.property("angstromLevel"), "angstromLevel")
				.add(Projections.property("chill"), "chill")
				.add(Projections.property("urlimage"), "urlimage")
				.add(Projections.property("weatherdescription"),
						"weatherdescription")
				.add(Projections.property("forecastfulldesc"),
						"forecastfulldesc"));

		List<Object[]> rows = query.list();
		List<Forecast> forecasts = new ArrayList<Forecast>();
		Forecast forecast1;
		for (Object[] row : rows) {
			forecast1 = new Forecast(row[0].toString(), row[1].toString(),
					row[2].toString(), row[3].toString(),
					Integer.parseInt(row[4].toString()), row[5].toString(),
					row[6].toString(), row[7].toString(), row[8].toString());
			forecasts.add(forecast1);

		}
		return forecasts;
	}

	public String updatedTime() {

		Date updated = null;
		DetachedCriteria maxQuery = DetachedCriteria.forClass(Forecast.class);
		maxQuery.setProjection(Projections.max("weatherupdated"));
		Criteria query = session().createCriteria(Forecast.class);
		query.add(Property.forName("weatherupdated").eq(maxQuery));
		query.setProjection(Projections.property("weatherupdated"));
		Object date = query.list().get(0);

		return date.toString();

	}

	public List<Forecast> getAllWeatherbyIdLocation(int districtID) {

		DetachedCriteria locationCriteria = DetachedCriteria
				.forClass(Location.class);
		locationCriteria.add(Restrictions.eq("district", districtID));
		locationCriteria.setProjection(Projections.property("woeid"));
		DetachedCriteria maxQuery = DetachedCriteria.forClass(Forecast.class);
		maxQuery.setProjection(Projections.max("weatherupdated"));
		Criteria query = session().createCriteria(Forecast.class);
		query.add(Property.forName("weatherupdated").eq(maxQuery));
		query.add(Property.forName("woeid").in(locationCriteria));
		query.setProjection(Projections
				.projectionList()
				.add(Projections.property("woeid"), "woeid")
				.add(Projections.property("geoLat"), "geoLat")
				.add(Projections.property("geoLong"), "geoLong")
				.add(Projections.property("weatherlocation"), "weatherlocation")
				.add(Projections.property("angstromLevel"), "angstromLevel")
				.add(Projections.property("chill"), "chill")
				.add(Projections.property("urlimage"), "urlimage")
				.add(Projections.property("weatherdescription"),
						"weatherdescription")
				.add(Projections.property("forecastfulldesc"), "forecastfulldesc"));
		List<Object[]> rows = query.list();
		List<Forecast> forecasts = new ArrayList<Forecast>();
		Forecast forecast1;
		for (Object[] row : rows) {
			forecast1 = new Forecast(row[0].toString(), row[1].toString(),
					row[2].toString(), row[3].toString(),
					Integer.parseInt(row[4].toString()), row[5].toString(),
					row[6].toString(), row[7].toString(), row[8].toString());
			forecasts.add(forecast1);

		}
		return forecasts;
	}

	public List<Location> getLstLocation(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
