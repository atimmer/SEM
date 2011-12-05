package airlinesystem;

import airlinesystem.payment.*;

public class Booking {

	private Person person;
	private Flight flight;
	private Payment payment;
	private String seatIdentifier;
	
	public Booking(Person person, Flight flight) {
		this.person = person;
		this.flight = flight;
		this.payment = new OutstandingPayment(100.00);
		int seat = (int) (Math.random() * 100);
		this.seatIdentifier = seat + "A";
	}
	
	public String getSeat() {
		return this.seatIdentifier;
	}
	
	public boolean cancel() {
		flight.removePerson(this.person);
		return false;
	}
	
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	
	public Payment getPayment() {
		return this.payment;
	}
	
	public String toString() {
		return "{" + person + " goes with flight " + flight + " with payment " + payment + " at seat " + seatIdentifier + "}";
	}
}
