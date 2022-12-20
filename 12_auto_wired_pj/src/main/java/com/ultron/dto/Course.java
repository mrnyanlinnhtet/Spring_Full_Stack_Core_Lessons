package com.ultron.dto;

import java.util.Objects;

public class Course {

	public enum Level {
		BASIC, INTERMEDIATE, ADVANCE
	}

	private int id;
	private String name;
	private Level level;
	private int month;
	private double fees;

	@Override
	public int hashCode() {
		return Objects.hash(fees, id, level, month, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		return Double.doubleToLongBits(fees) == Double.doubleToLongBits(other.fees) && id == other.id
				&& level == other.level && month == other.month && Objects.equals(name, other.name);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public double getFees() {
		return fees;
	}

	public void setFees(double fees) {
		this.fees = fees;
	}

}
