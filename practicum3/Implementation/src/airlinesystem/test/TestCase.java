package airlinesystem.test;

import java.sql.Date;

import airlinesystem.*;

public class TestCase {

	public static void main(String[] args) {
		(new TestCase()).run();
	}
	
	private Airline airline;
	private Person p1;
	private Person p2;
	private FlightTemplate t1;
	private Flight f1;
	
	/**
	 * Runs all tests
	 */
	public void run() {
		System.out.println("AIRLINE SYSTEM TESTS");
		System.out.println("--------------------");
		System.out.println("");
		
		testBookingAFlight();
		testFlightIsBooked();
	}
	
	/**
	 * Setup the test variables
	 */
	private void setup() {
		this.airline = new Airline("AK Airlines");
		
		p1 = airline.createPerson(1076884, "Koen");
		p2 = airline.createPerson(1074229, "Anton");
		
		t1 = airline.createFlightTemplate(9382, "AMSTERDAM", "CHICAGO", 635);
		f1 = airline.createFlightFromTemplate(t1, Date.valueOf("2011-02-19"));
	}
	
	/**
	 * The first test: try to book a flight
	 */
	public void testBookingAFlight() {
		setup();
		
		System.out.println("Test: Booking a flight");
		
		Booking booking = airline.createBooking(p1, f1);
		assertEquals(booking == null, false);
	}
	
	/**
	 * The second test: check if a person has booked a certain flight
	 */
	public void testFlightIsBooked() {
		setup();
		
		System.out.println("Test: Check person has booked a specific flight");
		
		// Flight should not yet be booked
		assertEquals(airline.personHasBookingForFlight(p1, f1), false);
		
		airline.createBooking(p1, f1);
		
		// Flight should be booked
		assertEquals(airline.personHasBookingForFlight(p1, f1), true);
	}

	
	/**
	 * Asserts that o1 equals (using the equals function) o2, displaying a message with the result
	 * @param o1 Object 1
	 * @param o2 Object 2
	 */
	private void assertEquals(Object o1, Object o2) {
		if(o1.equals(o2)) {
			System.out.println("+ OK");
		}else{
			System.out.println("- Error: " + o1 + " is not equal to " + o2);
		}
	}
	
}
