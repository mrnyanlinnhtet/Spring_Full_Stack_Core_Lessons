package com.ultron.services;

import com.ultron.dto.Course;

public interface CourseService {

	int insertCourse(Course course);

	Course findById(int id);

}
