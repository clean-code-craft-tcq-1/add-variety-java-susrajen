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
	 when(mockNotifierFactory.getAlerterFactory(NotifierTarget.TO_EMAIL)).thenReturn(mockBreachObserver);
	 when(mockNotifierFactory.getAlerterFactory(NotifierTarget.TO_ALL)).thenReturn(mockBreachObserver);
	 when(mockNotifierFactory.getAlerterFactory(NotifierTarget.TO_CONTROLLER)).thenReturn(mockBreachObserver);
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
    public void checkAndAlertConsoleTest() throws InstantiationException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
    	IBreachObserver breachObserver = mockNotifierFactory.getAlerterFactory(NotifierTarget.TO_CONSOLE);
    	BatteryCharacter batteryCharacter = new BatteryCharacter();
    	batteryCharacter.coolingType = CoolingType.MED_ACTIVE_COOLING;
    	TypewiseAlert.checkAndAlert(breachObserver, batteryCharacter, 45);
    }
    
    @Test
    public void checkAndAlertAllTargetsTest() throws InstantiationException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
    	IBreachObserver breachObserver = mockNotifierFactory.getAlerterFactory(NotifierTarget.TO_ALL);
    	BatteryCharacter batteryCharacter = new BatteryCharacter();
    	batteryCharacter.coolingType = CoolingType.MED_ACTIVE_COOLING;
    	TypewiseAlert.checkAndAlert(breachObserver, batteryCharacter, 45);
    }
    
    @Test
    public void checkAndAlertControllerTest() throws InstantiationException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
    	IBreachObserver breachObserver = mockNotifierFactory.getAlerterFactory(NotifierTarget.TO_CONTROLLER);
    	BatteryCharacter batteryCharacter = new BatteryCharacter();
    	batteryCharacter.coolingType = CoolingType.MED_ACTIVE_COOLING;
    	TypewiseAlert.checkAndAlert(breachObserver, batteryCharacter, 45);
    }
    
    @Test
    public void checkAndAlertEmailTest() throws InstantiationException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
    	IBreachObserver breachObserver = mockNotifierFactory.getAlerterFactory(NotifierTarget.TO_EMAIL);
    	BatteryCharacter batteryCharacter = new BatteryCharacter();
    	batteryCharacter.coolingType = CoolingType.MED_ACTIVE_COOLING;
    	TypewiseAlert.checkAndAlert(breachObserver, batteryCharacter, 45);
    }
}
