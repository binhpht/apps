package com.binhpht.apps.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
@Component("ocationDao")
public class LocationDao {
	@Autowired
	private SessionFactory sessionFactory;

	public Session session() {

		return sessionFactory.getCurrentSession();

	}

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

	public List<Location> getAllLocation() {
		Criteria query = session().createCriteria(Location.class);
		query.setProjection(Projections.projectionList()
				.add(Projections.property("lat"), "lat")
				.add(Projections.property("locality"), "locality")
				.add(Projections.property("long_"), "long_")
				.add(Projections.property("name"), "name")
				.add(Projections.property("sforest"), "sforest")
				.add(Projections.property("woeid"), "woeid"));
		List<Object[]> rows = query.list();
		List<Location> locations = new ArrayList<Location>();
		Location location;
		for (Object[] row : rows) {
			location = new Location(row[0].toString(), row[1].toString(),
					row[2].toString(), row[3].toString(), row[4].toString(),
					row[5].toString());

			locations.add(location);
		}
		return locations;
	}
	public List<Location> getAllLocation(int locationID) {
		Criteria query = session().createCriteria(Location.class);
		query.add(Restrictions.eq("district", locationID));
		query.setProjection(Projections.projectionList()
				.add(Projections.property("lat"), "lat")
				.add(Projections.property("locality"), "locality")
				.add(Projections.property("long_"), "long_")
				.add(Projections.property("name"), "name")
				.add(Projections.property("sforest"), "sforest")
				.add(Projections.property("woeid"), "woeid"));
		List<Object[]> rows = query.list();
		List<Location> locations = new ArrayList<Location>();
		Location location;
		for (Object[] row : rows) {
			location = new Location(row[0].toString(), row[1].toString(),
					row[2].toString(), row[3].toString(), row[4].toString(),
					row[5].toString());

			locations.add(location);
		}
		return locations;
	}
}
