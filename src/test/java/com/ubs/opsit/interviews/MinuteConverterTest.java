package com.ubs.opsit.interviews;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import com.ubs.opsit.interviews.exception.InvalidArgumentException;

public class MinuteConverterTest {

	private MinuteConverter minuteConverter;

	@Before
	public void setup() {
		minuteConverter = new MinuteConverter();
	}

	@Test
	public void testGetMinutesGivenValidInput() {
		try {
			assertEquals("YYOOOOOOOOO\nOOOO", minuteConverter.convertTime("10"));
			assertEquals("YYOOOOOOOOO\nYYYO", minuteConverter.convertTime("13"));
		} catch (Exception e) {
			fail("Exception should not be thrown");
		}

	}

	@Test(expected = InvalidArgumentException.class)
	public void testGetMinutesGivenInValidMinutes()
			throws InvalidArgumentException {

		assertEquals("YYOOOOOOOOO\nOOOO", minuteConverter.convertTime("781"));
		assertEquals("YYOOOOOOOOO\nYYYO", minuteConverter.convertTime("45"));
	}

	@Test(expected = InvalidArgumentException.class)
	public void testGetMinutesGivenNoMinutes() throws InvalidArgumentException {
		minuteConverter.convertTime("");

	}
}
