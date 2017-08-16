package com.ubs.opsit.interviews;

import com.ubs.opsit.interviews.exception.InvalidArgumentException;

public class SecondConverter implements TimeConverter {

	public SecondConverter() {
	}

	@Override
	public String convertTime(String aTime) throws InvalidArgumentException {
		try {
			Integer seconds = Integer.valueOf(aTime);

			if (seconds < 0 || seconds >= 60)
				throw new InvalidArgumentException(
						"Seconds should be between 00 to 59");

			if (seconds % 2 == 0)
				return "Y";
			return "O";
		} catch (NumberFormatException nfe) {
			throw new InvalidArgumentException(nfe);
		}
	}
}
