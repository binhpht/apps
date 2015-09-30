package com.binhpht.apps.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.binhpht.apps.dao.Forecast;
import com.binhpht.apps.dao.Location;
import com.binhpht.apps.service.IndexService;

@Controller
public class IndexController {
	@Autowired
	private IndexService indexService;

	@RequestMapping("/")
	public String showHome(Model mode) {
		List<Forecast> a = indexService.getAllWeather();
		String updated = indexService.getUpdatedTime();
		mode.addAttribute("listAllWeather", a);
		mode.addAttribute("updated", updated);

		return "index1";

	}

	@RequestMapping("/forest")
	public String showLocation(Model mode,
			@RequestParam(required = false) String id) {
		List<Location> a;
		if (!("").equals(id) && null != id && !id.trim().isEmpty()
				& Integer.parseInt(id) >= 0) {
			
			a = indexService.getAllLocation(Integer.parseInt(id));
		} else {
			a = indexService.getAllocation();
		}
		mode.addAttribute("listLocation", a);
		return "location";

	}

	@RequestMapping("/locationID")
	public String showWeatherLocationID(Model mode,
			@RequestParam("id") String id) {
		String updated = indexService.getUpdatedTime();
		List<Forecast> a = indexService.getWeatherbyID(Integer.parseInt(id));
		mode.addAttribute("weatherlocation", a);
		mode.addAttribute("updated", updated);

		return "weatherlocation";

	}

}