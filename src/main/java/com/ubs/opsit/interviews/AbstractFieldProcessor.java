package com.ubs.opsit.interviews;

import java.time.LocalTime;
import java.time.temporal.TemporalField;

/**
 * This abstract class provides the basic features and the contract for handling one field of the time and return the String accordingly.
 * @author Atish
 *
 */
public abstract class AbstractFieldProcessor {
	
	/**
	 * The field that the processor should process. The data for this field will be picked up and processed
	 */
	protected TemporalField fieldToProcess;
	
	public void setFieldToProcess(TemporalField fieldToProcess) {
		this.fieldToProcess = fieldToProcess;
	}

	/**
	 * The main methos that will call the abstract method that will be implemented by different implementations
	 * @param time
	 * @return
	 */
	public String processField(LocalTime time){
		
		int fieldValue = time.get(fieldToProcess);
		return processLineInternal(fieldValue, time);
		
	}
	
	/**
	 * Individual implementations should overload this method</BR>
	 * The actual value of the field will be passed based on which the string needs to be returned
	 * @param fieldValue - the actual value of the time field (hour, second, minute etc.)
	 * @param time
	 * @return
	 */
	abstract protected String processLineInternal(int fieldValue, LocalTime time);	

}
