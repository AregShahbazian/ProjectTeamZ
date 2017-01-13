package com.teamz;

import org.junit.Test;

public class DemoTest {
	
	@Test
	public void someTest(){
		
		//simple example of test
		int actual = 3;
		int expected = 3;
		
		org.junit.Assert.assertEquals(actual, expected);
	}
}
