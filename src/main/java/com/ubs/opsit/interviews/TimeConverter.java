package com.ubs.opsit.interviews;

import com.ubs.opsit.interviews.exception.InvalidArgumentException;

public interface TimeConverter {

    String convertTime(String aTime) throws InvalidArgumentException;

}
