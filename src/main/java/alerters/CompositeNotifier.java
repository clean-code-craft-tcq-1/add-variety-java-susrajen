package alerters;

import java.util.ArrayList;
import java.util.List;

import batteryStates.BreachType;

public class CompositeNotifier implements IBreachObserver {
	
	List<IBreachObserver> breachObservers = new ArrayList<IBreachObserver>();

	@Override
	public void dispatchAlerts(BreachType breachType) {
	  this.notifyAllTargets(breachType);
	}

	private void notifyAllTargets(BreachType breachType) {
		for(IBreachObserver breachObserver: breachObservers) {
			breachObserver.dispatchAlerts(breachType);
		}
	}

}
