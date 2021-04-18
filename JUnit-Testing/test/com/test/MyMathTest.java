package com.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.data.MyMath;

class MyMathTest {
	
	@BeforeClass
	public static void beforeClass() {
		System.out.println("before class");
	}
	
	
	@BeforeEach 
	public void before() {
		System.out.println("before");
	}
	
	@AfterEach 
	public void after() {
		System.out.println("after");
	}
	
	@Test
	void test1() {
		int result = new MyMath().sum(new int[] {1, 2, 3});
		assertEquals(6, result);
		System.out.println("test");
	}

	@Test
	void test() {
		int result = new MyMath().sum(new int[] {1, 2, 3});
		assertEquals(6, result);
		System.out.println("test");
		//check different assert methods of asserts
	}
	
	@AfterClass
	public static void afterClass() {
		System.out.println("after class");
	}

}
