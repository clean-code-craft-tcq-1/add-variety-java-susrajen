package alerters;

import java.lang.reflect.InvocationTargetException;

public class NotifierFactory {

	String className = "Notifier";
	
	public IBreachObserver getAlerterFactory(NotifierTarget targetType) throws InstantiationException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		 Class<IBreachObserver> breachClass = (Class<IBreachObserver>) Class.forName(targetType.getClassName() + className);
		 return breachClass.getDeclaredConstructor().newInstance();
	}
}
