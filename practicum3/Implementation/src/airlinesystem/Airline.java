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
	
	public Booking createBooking(Person person, Flight flight) {
		Booking b = new Booking(person, flight);
		bookings.add(b);
		return b;
	}
	
	public Person createPerson(int identifier, String name) {
		Person p = new Person(identifier, name);
		persons.add(p);
		return p;
	}
	
	public Employee createEmployee(int identifier, String name, String jobDescription) {
		Employee e = new Employee(identifier, name, jobDescription);
		persons.add(e);
		return e;
	}
	
	public Flight createFlightFromTemplate(FlightTemplate template, Date date) {
		Flight f = new Flight(template, date);
		flights.add(f);
		return f;
	}
	
	public FlightTemplate createFlightTemplate(int flightNumber, String origin, String destination, int time) {
		FlightTemplate ft = new FlightTemplate(flightNumber, origin, destination, time);
		flightTemplates.add(ft);
		return ft;
	}
	
	// All kinds of search / retrieve methods
	
	public Person personWithIdentifier(int identifier) {
		Person result = null;
		for(int i = 0; i < persons.size() && result == null; i++) {
			if(persons.get(i).getIdentifier() == identifier) {
				result = persons.get(i);
			}
		}
		return result;
	}
	
	public Flight flightWithNumberAndDate(int flightNumber, Date date) {
		Flight result = null;
		for(int i = 0; i < flights.size() && result == null; i++) {
			if(flights.get(i).getFlightNumber() == flightNumber && flights.get(i).getDate().equals(date)) {
				result = flights.get(i);
			}
		}
		return result;
	}
	
	public FlightTemplate flightTemplateWithNumber(int flightNumber) {
		FlightTemplate result = null;
		for(int i = 0; i < flightTemplates.size() && result == null; i++) {
			if(flightTemplates.get(i).getFlightNumber() == flightNumber) {
				result = flightTemplates.get(i);
			}
		}
		return result;
	}
	
	public ArrayList<Flight> flightsFromToWithDate(String origin, String destination, Date date) {
		ArrayList<Flight> result = new ArrayList<Flight>();
		for(int i = 0; i < flights.size(); i++) {
			if(flights.get(i).getOrigin().equals(origin) && flights.get(i).getDestination().equals(destination) && flights.get(i).getDate().equals(date)) {
				result.add(flights.get(i));
			}
		}
		return result;
	}
	
	public boolean personHasBookingForFlight(Person person, Flight flight) {
		boolean result = false;
		for(int i = 0; i < bookings.size() && !result; i++) {
			if(bookings.get(i).getFlight().equals(flight) && bookings.get(i).getPerson().equals(person)) {
				result = true;
			}
		}
		return result;
	}
	
}
