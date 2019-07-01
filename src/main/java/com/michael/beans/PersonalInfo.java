package com.michael.beans;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.michael.beans.DAO.noSql.Advertisment;
import com.michael.config.MySpringConfig;

public class PersonalInfo {

	Date firstTime;
	Date firstTimeAfterOneHour;
	List<Advertisment> personalAdList;

	public Date getFirstTimeAfterOneHour() {
		return firstTimeAfterOneHour;
	}

	public void setFirstTimeAfterOneHour(Date firstTimeAfterOneHour) {
		this.firstTimeAfterOneHour = firstTimeAfterOneHour;
	}

	public PersonalInfo(Date firstTime, String gapUnit) {
		this.firstTime = firstTime;

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(firstTime);

		if ("hour".equalsIgnoreCase(gapUnit)) {
			calendar.add(Calendar.HOUR_OF_DAY, 1);
		}

		if ("min".equalsIgnoreCase(gapUnit)) {
			calendar.add(Calendar.MINUTE, 1);
		}

		this.firstTimeAfterOneHour = calendar.getTime();
	}

	public Date getFirstTime() {
		return firstTime;
	}

	public void setFirstTime(Date firstTime) {
		this.firstTime = firstTime;
	}

	public List<Advertisment> getPersonalAdList() {
		return personalAdList;
	}

	public void setPersonalAdList(List<Advertisment> personalAdList) {
		this.personalAdList = personalAdList;
	}

	public PersonalInfo() {
		// TODO Auto-generated constructor stub
	}

}
