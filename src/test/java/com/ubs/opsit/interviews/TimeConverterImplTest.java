package com.ubs.opsit.interviews;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class TimeConverterImplTest {

	@Test
	public void testConvertTimeGivenValidTime() {
		TimeConvertorImpl convertorImpl = new TimeConvertorImpl();
		try {
		    assertEquals("O\n" +
		            "RROO\n" +
		            "RRRO\n" +
		            "YYROOOOOOOO\n" +
		            "YYOO\n", convertorImpl.convertTime("13:17:01"));		
		}
		catch(Exception e){
			fail("Exception should not be thrown");
		}
		
	}
	
	@Test
	public void testConvertTimeGiven00_00_00() {
		TimeConvertorImpl convertorImpl = new TimeConvertorImpl();
		try {
			assertEquals("Y\n" +
	            "OOOO\n" +
	            "OOOO\n" +
	            "OOOOOOOOOOO\n" +
	            "OOOO\n", convertorImpl.convertTime("00:00:00"));
		}
		catch(Exception e){
			fail("Exception should not be thrown");
		}
	}
}
