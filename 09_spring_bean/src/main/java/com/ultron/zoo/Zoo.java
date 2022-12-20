package com.ultron.zoo;

public class Zoo extends ZooAbstract {

	private int employees;
	private int customers;
	private String[] animals;

	public Zoo() {
		System.out.println("Zoo With Default Constructor");
		animals = new String[0];
	}

	public int getEmployees() {
		return employees;
	}

	public void setEmployees(int employees) {
		this.employees = employees;
	}

	public int getCustomers() {
		return customers;
	}

	public void setCustomers(int customers) {
		this.customers = customers;
	}

	public String[] getAnimals() {
		return animals;
	}

	public void setAnimals(String[] animals) {
		this.animals = animals;
	}

}
