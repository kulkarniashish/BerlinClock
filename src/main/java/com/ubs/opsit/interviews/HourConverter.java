package com.ubs.opsit.interviews;

import com.ubs.opsit.interviews.exception.InvalidArgumentException;

public class HourConverter implements TimeConverter {

	public HourConverter() {
	}

	@Override
	public String convertTime(String aTime) throws InvalidArgumentException {
		try {
			Integer hours = Integer.valueOf(aTime);
			if (hours < 0 || hours >= 60)
				throw new InvalidArgumentException(
						"Hours should be between 00 to 23");

			return getFiveHoursRow(hours) + Constants.NEW_LINE
					+ getRemainingHoursRow(hours);
		} catch (NumberFormatException nfe) {
			throw new InvalidArgumentException(nfe);
		}
	}

	private String getFiveHoursRow(int hours) {
		StringBuffer result = new StringBuffer(Constants.ALL_FOUR_LIGHTS_OFF);

		for (int i = 0; i < (hours / 5); i++) {
			result.replace(i, i + 1, Constants.RED_LIGHT);
		}
		return result.toString();
	}

	private String getRemainingHoursRow(int hours) {
		StringBuffer result = new StringBuffer(Constants.ALL_FOUR_LIGHTS_OFF);
		for (int i = 0; i < (hours % 5); i++) {
			result.replace(i, i + 1, Constants.RED_LIGHT);
		}
		return result.toString();
	}

}
