package com.ubs.opsit.interviews;

import java.time.LocalTime;

/**
 * The default implementation for the Field Processor </BR>
 * This assumes that two lines would be returned based on the value of the field. </BR>
 * The first line will put the colors as per the denominator mentioned. </BR>
 * The remainder will be put in the second line
 * @author Atish
 *
 */
public class DefaultFieldProcessor extends AbstractFieldProcessor{
	
	/**
	 * The lines and the denominator
	 */
	private String[] firstLine;
	private String[] secondLine;
	private int denominator;

	public void setFirstLine(String[] firstLine) {
		this.firstLine = firstLine;
	}
	public void setSecondLine(String[] secondLine) {
		this.secondLine = secondLine;
	}
	public void setDenominator(int denominator) {
		this.denominator = denominator;
	}
	
	@Override
	protected String processLineInternal(int fieldValue, LocalTime time) {
		int firstLineCount = fieldValue / denominator;
		int secondLineCount = fieldValue % denominator;
		
		String[] first = updateStrArray(firstLine, firstLineCount);
		String[] sec = updateStrArray(secondLine, secondLineCount);
		
		String finalStr = "";
		for (String string : first) {
			finalStr = finalStr + string;
		}
		
		finalStr = finalStr + "\n";
		for (String string : sec) {
			finalStr = finalStr + string;
		}
		
		return finalStr;
	}
	
	private String[] updateStrArray(String[] StrArr, int count){
		for (int i = count; i < StrArr.length; i++) {
			StrArr[i] = BerlinClockConverter.LIGHT_OFF;
		}
		return StrArr;
	}

}
