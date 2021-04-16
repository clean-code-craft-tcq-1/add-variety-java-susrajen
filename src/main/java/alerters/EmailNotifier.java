package alerters;

import batteryStates.BreachType;

public class EmailNotifier implements IBreachObserver{

	@Override
	public void dispatchAlerts(BreachType breachType) {
		 String recepient = "a.b@c.com";
		 System.out.printf("To: %s\n", recepient);
		 System.out.printf(breachType.getErrorMessage());
	}	

}
