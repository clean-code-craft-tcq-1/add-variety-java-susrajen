package batteryStates;

public enum BreachType {
	 NORMAL(""),
     TOO_LOW("Hi, the temperature is too low\n"),
     TOO_HIGH("Hi, the temperature is too high\n");
	
	private String errorMessage;

	BreachType(String errorMessage) {
		this.setErrorMessage(errorMessage);
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
