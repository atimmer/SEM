package airlinesystem;

public class Person {
	private int identifier;
	private String name;
	
	/**
	 * Initializes a person object
	 * 
	 * @param identifier The identifier this person should get
	 * @param name		 The name this person should get
	 */
	public Person(int identifier, String name) {
		this.identifier = identifier;
		this.name = name;
	}
	
	/**
	 * Gets the name of this person
	 * @return The name of this person
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Gets the identifier of this person
	 * @return
	 */
	public int getIdentifier() {
		return this.identifier;
	}
	
	public String toString() {
		return "{" + name + " (" + identifier + ")}";
	}
}
