package com.ultron.beans;

public class EmployeeDao {

	public void insert(Employee e) {

		System.out.println("Employee Id : " + e.getId());
		System.out.println();
		System.out.println("Employee Name : " + e.getName());
		System.out.println();
		System.out.println("Employee Phone : " + e.getPhone());
	}
}
