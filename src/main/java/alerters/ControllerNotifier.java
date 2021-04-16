package alerters;

import batteryStates.BreachType;

public class ControllerNotifier implements IBreachObserver {

	@Override
	public void dispatchAlerts(BreachType breachType) {
		int header = 0xfeed;
	    System.out.printf("%i : %i\n", header, breachType);
	}
}
