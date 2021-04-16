package typewiseAlert;

import alerters.NotifierTarget;
import alerters.NotifierFactory;

import java.lang.reflect.InvocationTargetException;

import alerters.IBreachObserver;
import batteryStates.BatteryCharacter;
import batteryStates.BreachType;

public class TypewiseAlert {

	public static BreachType inferBreach(double value, double lowerLimit, double upperLimit) {
		if (value < lowerLimit) {
			return BreachType.TOO_LOW;
		}
		if (value > upperLimit) {
			return BreachType.TOO_HIGH;
		}
		return BreachType.NORMAL;
	}

	public static void checkAndAlert(IBreachObserver alerter, BatteryCharacter batteryChar, double temperatureInC) {
		BreachType breachType = determineBreachType(batteryChar, temperatureInC);
		alerter.dispatchAlerts(breachType);
	}
	
	public static IBreachObserver getBreachObserverInstance(NotifierTarget notifierTarget) throws InstantiationException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException
	{
		NotifierFactory notifierFactory = new NotifierFactory();
		IBreachObserver alerter = notifierFactory.getAlerterFactory(notifierTarget);
		return alerter;
	}

	private static BreachType determineBreachType(BatteryCharacter batteryChar, double temperatureInC) {
		BreachType breachType = inferBreach(temperatureInC, batteryChar.coolingType.getLowerLimit(),
				batteryChar.coolingType.getUpperLimit());
		return breachType;
	}

}
