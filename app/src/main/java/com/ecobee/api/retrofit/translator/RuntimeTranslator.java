package com.ecobee.api.retrofit.translator;

import com.ecobee.api.retrofit.TemperatureUnits;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by eugene on 2015-03-01.
 */
public class RuntimeTranslator {

	private final static BigDecimal UNKNOWN_VALUE = new BigDecimal(-5002);

	public static BigDecimal getActualTemperature(com.ecobee.api.retrofit.Runtime runtime,
	                                              TemperatureUnits desiredUnits) {
		if (desiredUnits==null) {
			throw new IllegalArgumentException("Please specify desired units");
		}
		if (runtime==null || runtime.getActualTemperature()==null) {
			return null;
		}
		BigDecimal result = new BigDecimal(runtime.getActualTemperature());
		if (result.compareTo(UNKNOWN_VALUE)==0) {
			return null;
		}
		result = result.divide(BigDecimal.valueOf(10));
		switch (desiredUnits) {
			case FAHRENHEIT: break; //No further conversion required
			case CELSIUS: {
				//[°C] = ([°F] − 32) × 5⁄9
				result = result.subtract(BigDecimal.valueOf(32));
				result = result.multiply(BigDecimal.valueOf(5));
				result = result.divide(BigDecimal.valueOf(9), 4, RoundingMode.HALF_UP);
				break;
			}
		}
		return result;
	}

}
