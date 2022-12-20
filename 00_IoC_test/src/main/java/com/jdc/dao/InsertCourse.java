package com.jdc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.jdc.dto.Course;

public class InsertCourse {

	private DataSource datasource;

	public InsertCourse(DataSource datasource) {
		super();
		this.datasource = datasource;
	}

	private static final String INSERT = "INSERT INTO courses(name,fees,duration)VALUES(?,?,?)";

	public void insertProcess(Course c) {

		try (Connection con = datasource.getConnection(); PreparedStatement statement = con.prepareStatement(INSERT);) {

			statement.setString(1, c.getName());
			statement.setDouble(2, c.getFees());
			statement.setInt(3, c.getDuration());

			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
