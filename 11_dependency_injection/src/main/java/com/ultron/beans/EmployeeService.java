package com.ultron.beans;

public class EmployeeService {

	private EmployeeDao dao;
	
	public EmployeeService() {
		
	}

	public EmployeeService(EmployeeDao dao) {
		super();
		this.dao = dao;
		System.out.println("Constructor Called !");
		System.out.println(dao);
	}

	public void setEmployeeDao(EmployeeDao dao) {
		this.dao = dao;
		System.out.println("Setter Called !");
		System.out.println(dao);
	}

	public void create(Employee e) {
		dao.insert(e);
		System.out.println("Create Method");
	}

}
