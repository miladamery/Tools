package com.milad.api.utility.date;

import java.util.Date;

import com.ibm.icu.text.SimpleDateFormat;
import com.ibm.icu.util.ULocale;
import com.milad.api.utility.abstracts.dateUtility.DateUtility;

public class PerisanDateUtility implements DateUtility {

	private ULocale locale;

	public PerisanDateUtility() {
		this.locale = new ULocale("fa_IR@calendar=persian");
	}

	private String getSimpleDateFormatResultForCurrentDate(String pattern) {
		SimpleDateFormat formatter = new SimpleDateFormat(pattern, this.locale);
		return formatter.format(new Date());
	}

	public String getToday() {
		return getSimpleDateFormatResultForCurrentDate("yyyy.MM.dd");
	}

	public String getTime() {
		return getSimpleDateFormatResultForCurrentDate("HH:mm");
	}

	public String getCurrentDay() {
		return getSimpleDateFormatResultForCurrentDate("dd");
	}

	public String getCurrentMonth() {
		return getSimpleDateFormatResultForCurrentDate("MM");
	}

	public String getCurrentYear() {
		return getSimpleDateFormatResultForCurrentDate("yyyy");
	}

	public String getCurrentdayName() {
		return getSimpleDateFormatResultForCurrentDate("EEEE");
	}

	public String getCurrentMonthName() {
		return getSimpleDateFormatResultForCurrentDate("MMMM");
	}
}
