package airlinesystem;

public class Person {
	private int identifier;
	private String name;
	
	public Person(int identifier, String name) {
		this.identifier = identifier;
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getIdentifier() {
		return this.identifier;
	}
	
}
