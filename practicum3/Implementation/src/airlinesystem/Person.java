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
	
	/**
	 * Gets whether or not this person has a booking for the flight
	 * 
	 * @param flight The flight for which the person might have a booking
	 * 
	 * @return Whether or not the person has a booking for the flight
	 */
	public boolean hasBookingForFlight(Flight flight) {
		
		return false;
	}
	
	@Override
	public String toString() {
		return "{" + name + " (" + identifier + ")}";
	}
}
