package alerters;

import batteryStates.BreachType;

public interface IBreachObserver {
	public void dispatchAlerts(BreachType breachType);
}
