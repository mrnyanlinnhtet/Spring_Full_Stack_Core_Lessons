package com.ultron.beans;

public class ZooStaticFactory {

	public static Zoo getZoo() {
		return new Zoo();
	}

	public static Zoo zooWithCount(int count) {
		return new Zoo(count);
	}
}
