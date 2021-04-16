package alerters;

public enum NotifierTarget {
	TO_CONTROLLER("Controller"),
    TO_EMAIL("Email"),
    TO_CONSOLE("Console"),
	TO_ALL("Composite");

	private String className;
	
	NotifierTarget(String className) {
		this.setClassName(className);
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
}
