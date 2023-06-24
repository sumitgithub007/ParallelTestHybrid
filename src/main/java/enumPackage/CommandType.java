package enumPackage;

public enum CommandType {

	CLICK("click"),

	TYPE("type"),

	DOUBLECLICK("doubleclick");

	private final String name;

	CommandType(final String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return this.name;
	}

}