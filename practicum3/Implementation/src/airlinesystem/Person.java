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
	
	public boolean hasBookingForFlight(Flight flight) {
		
		return false;
	}
	
	public String toString() {
		return "{" + name + " (" + identifier + ")}";
	}
}
