package alerters;

import batteryStates.BreachType;

public class ConsoleNotifier implements IBreachObserver {

	@Override
	public void dispatchAlerts(BreachType breachType) {
		System.out.printf(breachType.getErrorMessage());
	}
}
