package airlinesystem;

import java.util.*;

public class Flight extends FlightTemplate {

	/**
	 * date != null
	 */
	private Date date;
	
	/**
	 * passengers != null
	 */
	private ArrayList<Person> passengers;
	
	/**
	 * Initializes a flight object
	 * 
	 * @param template The template with which this flight flies
	 * @param date The date at which this flight flies
	 * 
	 * @require template != null && date != null
	 */
	public Flight(FlightTemplate template, Date date) {
		super(template.getFlightNumber(), template.getOrigin(), template.getDestination(), template.getTime());
		this.date = date;
		this.passengers = new ArrayList<Person>();
	}
	
	/**
	 * Gets the date of this flight
	 * 
	 * @ensure result != null
	 * 
	 * @return The date of this flight
	 */
	public Date getDate() {
		return this.date;
	}

	/**
	 * Removes a person from the passengers
	 * 
	 * @param person The person to be removed from the passengers
	 */
	public void removePerson(Person person) {
		this.passengers.remove(person);
	}
	
	/**
	 * Gets the passengers on this flight
	 * 
	 * @ensure result != null
	 * 
	 * @return An ArrayList containing all the passengers on this flight
	 */
	public ArrayList<Person> getPassengers() {
		return this.passengers;
	}

	@Override
	public String toString() {
		return "{flightTemplate: " + super.toString() + " on date " + date + "}";
	}
}
