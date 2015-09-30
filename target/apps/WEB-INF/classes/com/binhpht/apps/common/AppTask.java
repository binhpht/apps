package com.binhpht.apps.common;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.binhpht.apps.AppService;

public class AppTask {
//public static void main (String args[]){
//	System.out.println("Do Task");
//	ApplicationContext context = new ClassPathXmlApplicationContext(
//			"com/binhpht/apps/app.xml");
//	AppService app = (AppService) context.getBean("appService");
//	app.updateWeather();
//
//};
	public void getWeather() {
		System.out.println("Do Task");
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"com/binhpht/apps/app.xml");
		AppService app = (AppService) context.getBean("appService");
		app.updateWeather();

	}

}
