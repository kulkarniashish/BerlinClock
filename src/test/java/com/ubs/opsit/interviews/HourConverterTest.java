package com.ubs.opsit.interviews;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import com.ubs.opsit.interviews.exception.InvalidArgumentException;

public class HourConverterTest {

	private HourConverter hourConverter;

	@Before
	public void setup() {
		hourConverter = new HourConverter();
	}

	@Test
	public void testGetHoursGivenValidInput() {
		try {
			assertEquals("RROO\nOOOO", hourConverter.convertTime("10"));
			assertEquals("RROO\nRRRO", hourConverter.convertTime("13"));
		} catch (Exception e) {
			fail("Exception should not be thrown");
		}

	}

	@Test(expected = InvalidArgumentException.class)
	public void testGetHoursGivenInValidHours()
			throws InvalidArgumentException {

		assertEquals("YYOOOOOOOOO\nOOOO", hourConverter.convertTime("781"));
		assertEquals("YYOOOOOOOOO\nYYYO", hourConverter.convertTime("45"));
	}

	@Test(expected = InvalidArgumentException.class)
	public void testGetHoursGivenNoHours() throws InvalidArgumentException {
		hourConverter.convertTime("");

	}
}
