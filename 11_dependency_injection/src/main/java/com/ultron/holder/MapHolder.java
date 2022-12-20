package com.ultron.holder;

import java.time.LocalDate;
import java.util.Map;

public class MapHolder {

	private Map<String, LocalDate> date;

	public void setDate(Map<String, LocalDate> date) {
		this.date = date;
	}

	public Map<String, LocalDate> getDate() {
		return date;
	}

}
