package airlinesystem;

import java.util.*;

public class Flight extends FlightTemplate {

	private Date date;
	private ArrayList<Person> passengers;
	
	public Flight(FlightTemplate template, Date date) {
		super(template.getFlightNumber(), template.getOrigin(), template.getDestination(), template.getTime());
		this.date = date;
		this.passengers = new ArrayList<Person>();
	}
	
	public Date getDate() {
		return this.date;
	}

	public void removePerson(Person person) {
		this.passengers.remove(person);
	}
	
	public ArrayList<Person> getPassengers() {
		return this.passengers;
	}

}
