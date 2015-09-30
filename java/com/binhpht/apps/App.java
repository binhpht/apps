package com.binhpht.apps;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.binhpht.apps.dao.*;

public class App {

	public static void main(String agrs[]) {

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"com/binhpht/apps/app.xml");
		AppService app = (AppService) context.getBean("appService");
		app.updateWeather();


	}

}
