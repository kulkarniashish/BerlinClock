package com.ubs.opsit.interviews;

import com.ubs.opsit.interviews.exception.InvalidArgumentException;

public class MinuteConverter implements TimeConverter {

	public MinuteConverter() {
	}

	@Override
	public String convertTime(String aTime) throws InvalidArgumentException {
		try {
			Integer minutes = Integer.valueOf(aTime);
			if (minutes < 0 || minutes >= 60)
				throw new InvalidArgumentException(
						"Minutes should be between 00 to 59");

			int div = minutes / 5;
			int rem = minutes % 5;
			return getFiveMinutesRow(div) + "\n" + getRemainingMinutesRow(rem);
		} catch (NumberFormatException nfe) {
			throw new InvalidArgumentException(nfe);
		}
	}

	private String getFiveMinutesRow(int div) {

		StringBuffer result = new StringBuffer(Constants.ALL_ELVN_LIGHTS_OFF);
		for (int i = 0; i < div; i++) {
			if (0 == (i + 1) % 3) {
				result.replace(i, i + 1, Constants.RED_LIGHT);
			} else {
				result.replace(i, i + 1, Constants.YELLOW_LIGHT);
			}
		}
		return result.toString();
	}

	private String getRemainingMinutesRow(int rem) {

		StringBuffer result = new StringBuffer(Constants.ALL_FOUR_LIGHTS_OFF);
		for (int i = 0; i < rem; i++) {
			result.replace(i, i + 1, Constants.YELLOW_LIGHT);
		}
		return result.toString();
	}

}
