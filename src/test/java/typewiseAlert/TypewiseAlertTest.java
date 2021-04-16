package typewiseAlert;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import alerters.IBreachObserver;
import alerters.NotifierFactory;
import alerters.NotifierTarget;
import batteryStates.BatteryCharacter;
import batteryStates.BreachType;
import batteryStates.CoolingType;

import static org.mockito.Mockito.when;

import java.lang.reflect.InvocationTargetException;


@RunWith(MockitoJUnitRunner.class)
public class TypewiseAlertTest 
{
	@Mock 
	NotifierFactory mockNotifierFactory;
	
	@Mock
	private IBreachObserver mockBreachObserver;
	

	@Before
	 public void setup() throws InstantiationException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
     	 
	 when(mockNotifierFactory.getAlerterFactory(NotifierTarget.TO_CONSOLE)).thenReturn(mockBreachObserver);
 
	 }

	@Test
    public void infersBreachAsPerLimits()
    {
      assertTrue(TypewiseAlert.inferBreach(12, 20, 30) ==
        BreachType.TOO_LOW);
      
      assertTrue(TypewiseAlert.inferBreach(82, 20, 30) ==
    	        BreachType.TOO_HIGH);
      
      assertTrue(TypewiseAlert.inferBreach(22, 20, 30) ==
  	        BreachType.NORMAL);
    }
    
    @Test
    public void checkAndAlertTest() throws InstantiationException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
    	IBreachObserver breachObserver = mockNotifierFactory.getAlerterFactory(NotifierTarget.TO_CONSOLE);
    	BatteryCharacter batteryCharacter = new BatteryCharacter();
    	batteryCharacter.coolingType = CoolingType.MED_ACTIVE_COOLING;
    	TypewiseAlert.checkAndAlert(breachObserver, batteryCharacter, 45);
    }
}
