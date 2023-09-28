package com.tests;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.BaseTest;
import com.pages.TestPage;

public class TestDemo extends BaseTest{
	TestPage tp;
	
	public TestDemo() throws IOException {
		super();
	}

	@Test
	public void test() throws InterruptedException
	{
		SoftAssert softAssert = new SoftAssert();
		
		tp = new TestPage(driver);
		tp.goToOnDemand();
		String actualRating = tp.checkRating();
		String expectedResults = "18+ | 2015 | Horror | 1h 38m";
		
		softAssert.assertEquals(actualRating, expectedResults);
		//Capturing the failures when executing through soft assert using  assertAll
		softAssert.assertAll();
		
	}
	
	

}
