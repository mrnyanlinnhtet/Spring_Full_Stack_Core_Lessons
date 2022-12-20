package com.ultron.zoo;

public class InstanceFactory {

	private boolean bigSize;

	public InstanceFactory(boolean bigSize) {
		this.bigSize = bigSize;
	}

	public ZooInterface getZoo() {
		var zoo = new Zoo();
		zoo.setAnimals(new String[bigSize ? 100 : 30]);
		zoo.setEmployees(bigSize ? 30 : 20);
		zoo.setCustomers(bigSize ? 100 : 50);

		return zoo;
	}

}
