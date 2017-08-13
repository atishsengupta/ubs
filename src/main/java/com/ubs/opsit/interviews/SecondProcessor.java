package com.ubs.opsit.interviews;

import java.time.LocalTime;

public class SecondProcessor extends AbstractFieldProcessor{

	@Override
	protected String processLineInternal(int fieldValue, LocalTime time) {
		if(fieldValue % 2 == 0)
			return String.valueOf(BerlinClockConverter.LIGHT_AMBER);
		return String.valueOf(BerlinClockConverter.LIGHT_OFF);
	}

}
