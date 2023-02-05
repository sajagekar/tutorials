package com.mentes.java8.tests;

public class ExceptionTest {

	public static void main(String[] args) {
		
		try {
			Class<?> t = Class.forName("com.mentes.java8.tests.Test");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}

class Test {
	
}
