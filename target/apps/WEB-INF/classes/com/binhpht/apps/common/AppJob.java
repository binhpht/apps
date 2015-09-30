package com.binhpht.apps.common;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class AppJob extends QuartzJobBean {
	private AppTask appTask;

	@Override
	protected void executeInternal(JobExecutionContext context)
			throws JobExecutionException {
		System.out.println("get weather task");
		getAppTask().getWeather();
	}

	public AppTask getAppTask() {
		return appTask;
	}

	public void setAppTask(AppTask appTask) {
		this.appTask = appTask;
	}

	

}
