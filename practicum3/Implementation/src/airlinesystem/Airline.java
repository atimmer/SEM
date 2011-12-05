package airlinesystem;

import java.util.*;

public class Airline {
	private String name;
	private ArrayList<Person> persons;
	private ArrayList<Booking> bookings;
	private ArrayList<FlightTemplate> flightTemplates;
	private ArrayList<Flight> flights;
	
	public Airline(String name) {
		this.name = name;
		this.persons = new ArrayList<Person>();
		this.bookings = new ArrayList<Booking>();
		this.flightTemplates = new ArrayList<FlightTemplate>();
		this.flights = new ArrayList<Flight>();
	}
	
	public String getName() {
		return this.name;
	}
	
	// All kinds of creation methods here :)
	// This is where the magic happens
	
	/**
	 * Creates a booking for a certain person on a flight
	 * 
	 * @param person The person that goes on a flight
	 * @param flight The flight the person goes with
	 * @require person != null
	 * @require flight != null
	 * @ensure result != null
	 * @return The newly created booking
	 */
	public Booking createBooking(Person person, Flight flight) {
		Booking b = new Booking(person, flight);
		bookings.add(b);
		return b;
	}
	
	/**
	 * Creates a new person, with an identifier and a name
	 * 
	 * @param identifier The identifier the person should get
	 * @param name The name the person has
	 * 
	 * @require name != null
	 * @ensure result != null
	 * 
	 * @return The newly created person
	 */
	public Person createPerson(int identifier, String name) {
		Person p = new Person(identifier, name);
		persons.add(p);
		return p;
	}
	
	/**
	 * Creates a new employee, with an identifier, a name and a job description
	 * 
	 * @param identifier The identifier the employee should get
	 * @param name The name the employee has
	 * @param jobDescription The description of the job this employee is doing
	 * 
	 * @require name != null && jobDescription != null
	 * @ensure result != null
	 * 
	 * @return The newly created employee
	 */
	public Employee createEmployee(int identifier, String name, String jobDescription) {
		Employee e = new Employee(identifier, name, jobDescription);
		persons.add(e);
		return e;
	}
	
	/**
	 * Creates a new flight from a flight template
	 * 
	 * @param template the template used to create this flight
	 * @param date The date on which this flight flies
	 *
	 * @require template != null && date != null
	 * @ensure result != null
	 * 
	 * @return The newly created flight
	 */
	public Flight createFlightFromTemplate(FlightTemplate template, Date date) {
		Flight f = new Flight(template, date);
		flights.add(f);
		return f;
	}
	
	/**
	 * Creates a new flight template
	 * 
	 * @param flightNumber The number this flight template should get
	 * @param origin       The origin from which all flights created with this template will fly
	 * @param destination  The destination to which all flights created with this template will fly
	 * @param time         The time at which all flights created with this template will fly
	 * 
	 * @require origin != null && destination != null
	 * @ensure result != null
	 * 
	 * @return The newly created flight template
	 */
	public FlightTemplate createFlightTemplate(int flightNumber, String origin, String destination, int time) {
		FlightTemplate ft = new FlightTemplate(flightNumber, origin, destination, time);
		flightTemplates.add(ft);
		return ft;
	}
	
	// All kinds of search / retrieve methods
	
	/**
	 * Gets a person
	 * 
	 * @param identifier The identifier of the person the client wants to get
	 * 
	 * @return the retrieved person
	 */
	public Person personWithIdentifier(int identifier) {
		Person result = null;
		for(int i = 0; i < persons.size() && result == null; i++) {
			if(persons.get(i).getIdentifier() == identifier) {
				result = persons.get(i);
			}
		}
		return result;
	}
	
	/**
	 * Gets a flight
	 * 
	 * @param flightNumber The number of the flight the client wants to get
	 * @param date The date of the flight the client wants to get
	 * 
	 * @return The retrieved flight
	 */
	public Flight flightWithNumberAndDate(int flightNumber, Date date) {
		Flight result = null;
		for(int i = 0; i < flights.size() && result == null; i++) {
			if(flights.get(i).getFlightNumber() == flightNumber && flights.get(i).getDate().equals(date)) {
				result = flights.get(i);
			}
		}
		return result;
	}
	
	/**
	 * Gets a flight template
	 * 
	 * @param flightNumber the number of the flight template the client wants to get
	 * 
	 * @return The retrieved flight template
	 */
	public FlightTemplate flightTemplateWithNumber(int flightNumber) {
		FlightTemplate result = null;
		for(int i = 0; i < flightTemplates.size() && result == null; i++) {
			if(flightTemplates.get(i).getFlightNumber() == flightNumber) {
				result = flightTemplates.get(i);
			}
		}
		return result;
	}
	
	/**
	 * Gets a list of flights with the origin, destination and date specified
	 * 
	 * @param origin The origin of the flights the client wants to get
	 * @param destination The destination of flights the client wants to get
	 * @param date The date of flights the client wants to get
	 * 
	 * @return The retrieved flights
	 */
	public ArrayList<Flight> flightsFromToWithDate(String origin, String destination, Date date) {
		ArrayList<Flight> result = new ArrayList<Flight>();
		for(int i = 0; i < flights.size(); i++) {
			if(flights.get(i).getOrigin().equals(origin) && flights.get(i).getDestination().equals(destination) && flights.get(i).getDate().equals(date)) {
				result.add(flights.get(i));
			}
		}
		return result;
	}
	
	/**
	 * Indicates whether or not the person has a booking on the flight
	 * 
	 * @param person The person that might have a booking on the specified flight
	 * @param flight The flight the person might have a booking on
	 * 
	 * @return Whether or not the person has a booking on the flight
	 */
	public boolean personHasBookingForFlight(Person person, Flight flight) {
		boolean result = false;
		for(int i = 0; i < bookings.size() && !result; i++) {
			if(bookings.get(i).getFlight().equals(flight) && bookings.get(i).getPerson().equals(person)) {
				result = true;
			}
		}
		return result;
	}
	
	@Override
	public String toString() {
		String result; 
		result  = String.format("%-15s %s\n", "Persons", persons);
		result += String.format("%-15s %s\n", "Bookings", bookings);
		result += String.format("%-15s %s\n", "Flights", flights);
		result += String.format("%-15s %s\n", "Templates", flightTemplates);
		return result;
	}	
}
