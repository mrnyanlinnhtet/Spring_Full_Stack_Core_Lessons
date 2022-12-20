package com.ultron.dao;

import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.stereotype.Component;

import com.ultron.dto.Course;
import com.ultron.dto.Course.Level;
import com.ultron.services.CourseService;

@Component
public class CourseDao implements CourseService {

	private DataSource dataSource;

	public CourseDao(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}

	@Override
	public int insertCourse(Course course) {
		final String INSERT = """
				INSERT INTO courses(name,level,month,fees)VALUES(?,?,?,?);
				""";

		try (var con = dataSource.getConnection();
				var stm = con.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);) {

			stm.setString(1, course.getName());
			stm.setInt(2, course.getLevel().ordinal());
			stm.setInt(3, course.getMonth());
			stm.setDouble(4, course.getFees());

			int result = stm.executeUpdate();

			if (result > 0) {

				var rs = stm.getGeneratedKeys();

				while (rs.next()) {
					return rs.getInt(1);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Course findById(int id) {
		final String FIND_BY_ID = "SELECT * FROM courses WHERE id = ?";

		try (var con = dataSource.getConnection(); var stm = con.prepareStatement(FIND_BY_ID)) {

			stm.setInt(1, id);

			var rs = stm.executeQuery();

			while (rs.next()) {

				Course c = new Course();
				c.setId(rs.getInt("id"));
				c.setName(rs.getString("name"));
				c.setLevel(Level.values()[rs.getInt("level")]);
				c.setMonth(rs.getInt("month"));
				c.setFees(rs.getDouble("fees"));

				return c;
			}

		} catch (SQLException e) {

		}
		return null;
	}

}
