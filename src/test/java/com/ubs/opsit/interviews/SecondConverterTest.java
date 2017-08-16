package com.ubs.opsit.interviews;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import com.ubs.opsit.interviews.exception.InvalidArgumentException;

public class SecondConverterTest {

	private SecondConverter secondConverter;

	@Before
	public void setup() {
		secondConverter = new SecondConverter();
	}

	@Test
	public void testGetSecondsGivenValidSeconds() {
		try {
			assertEquals("O", secondConverter.convertTime("01"));
			assertEquals("Y", secondConverter.convertTime("10"));
		} catch (Exception e) {
			fail("Exception should not be thrown");
		}

	}

	@Test(expected = InvalidArgumentException.class)
	public void testGetSecondsGivenInValidSeconds()
			throws InvalidArgumentException {

		assertEquals("O", secondConverter.convertTime("781"));
		assertEquals("Y", secondConverter.convertTime("45"));
	}

	@Test(expected = InvalidArgumentException.class)
	public void testGetSecondsGivenNoSeconds() throws InvalidArgumentException {
		secondConverter.convertTime("");

	}
}
