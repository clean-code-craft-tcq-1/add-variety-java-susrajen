package batteryStates;

public enum CoolingType {
	PASSIVE_COOLING(0, 30),
    HI_ACTIVE_COOLING(0, 45),
    MED_ACTIVE_COOLING(0, 40);

	private int lowerLimit;
	private int upperLimit;
	
	CoolingType(int lowerLimit, int upperLimit) {
		this.setLowerLimit(lowerLimit);
		this.setUpperLimit(upperLimit);
	}

	public int getLowerLimit() {
		return lowerLimit;
	}

	public void setLowerLimit(int lowerLimit) {
		this.lowerLimit = lowerLimit;
	}

	public int getUpperLimit() {
		return upperLimit;
	}

	public void setUpperLimit(int upperLimit) {
		this.upperLimit = upperLimit;
	}
}
