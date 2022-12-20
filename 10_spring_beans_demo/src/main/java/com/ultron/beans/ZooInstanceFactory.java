package com.ultron.beans;

public class ZooInstanceFactory {

	public enum Type {
		DEFALUT, BIG, SMALL
	}

	private Type type;

	public ZooInstanceFactory(Type type) {
		super();
		this.type = type;
	}

	public Zoo getZoo() {

		return switch (type) {

		case BIG -> new Zoo(100);
		case SMALL -> new Zoo(10);
		default -> new Zoo();
		};
	}

	public Zoo getZoo(int count) {
		return new Zoo(count);
	}
}
