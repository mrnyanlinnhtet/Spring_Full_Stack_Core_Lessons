package com.ultron.zoo;

public class ZooFactory implements ZooInterface {

	public static ZooInterface zooWithDefalut() {
		return new Zoo();
	}

	public static ZooInterface zooWithEmployee(int count) {
		var zoo = new Zoo();
		zoo.setEmployees(count);
		return zoo;
	}

	public static ZooInterface zooWithAnimals(int count) {
		var zoo = new Zoo();
		zoo.setAnimals(new String[count]);
		return zoo;
		
		
	}

}
