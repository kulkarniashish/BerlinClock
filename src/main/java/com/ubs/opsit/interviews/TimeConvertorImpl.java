package com.ubs.opsit.interviews;

import com.ubs.opsit.interviews.exception.InvalidArgumentException;

/**
 * Time Convertor in Berlin Clock format
 * 
 * @author Ashish
 * 
 */
public class TimeConvertorImpl implements TimeConverter {

	

	@Override
	public String convertTime(String aTime) throws InvalidArgumentException {

		StringBuilder result = new StringBuilder();
		String[] tokens = aTime.split(":");
		
		SecondConverter secondConverter = new SecondConverter();
		result.append(secondConverter.convertTime(tokens[2])).append("\n");
		
		HourConverter hourConverter = new HourConverter();
		result.append(hourConverter.convertTime(tokens[0])).append("\n");

		MinuteConverter minuteConverter = new MinuteConverter();
		result.append(minuteConverter.convertTime(tokens[1])).append("\n");

		return result.toString();
	}

	



}
