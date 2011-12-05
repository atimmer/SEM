package airlinesystem;

import airlinesystem.payment.*;

public class Booking {

	/**
	 * person != null
	 */
	private Person person;
	
	/**
	 * flight != null
	 */
	private Flight flight;
	
	/**
	 * payment != null
	 */
	private Payment payment;
	
	/**
	 * seatIdentifier != null
	 */
	private String seatIdentifier;
	
	/**
	 * 
	 * @param person
	 * @param flight
	 * 
	 * @require person != null && flight != null
	 * @ensure this.payment != null && this.seat != null && this.person != null && this.flight != null
	 */
	public Booking(Person person, Flight flight) {
		this.person = person;
		this.flight = flight;
		this.payment = new OutstandingPayment(100.00);
		int seat = (int) (Math.random() * 100);
		this.seatIdentifier = seat + "A";
	}
	
	/**
	 * Gets the seat of this booking
	 * 
	 * @ensure result != null
	 * @return The seat of this booking
	 */
	public String getSeat() {
		return this.seatIdentifier;
	}
	
	/**
	 * Cancels this booking
	 * 
	 * @return Whether or not the cancellation was successfull
	 */
	public boolean cancel() {
		flight.removePerson(this.person);
		return true;
	}
	
	/**
	 * Sets the payment of this booking
	 * 
	 * @param payment The desired payment
	 * 
	 * @require payment != null
	 */
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	
	/**
	 * Gets the flight of this booking
	 * 
	 * @ensure result != null 
	 *
	 * @return The flight of this booking
	 */
	public Flight getFlight() {
		return this.flight;
	}
	
	/**
	 * Gets the person of this booking
	 * 
	 * @ensure result != null
	 * 
	 * @return The person of this booking
	 */
	public Person getPerson() {
		return this.person;
	}
	
	/**
	 * Gets the payment of this booking
	 * 
	 * @ensure result != null
	 * 
	 * @return The payment of this booking
	 */
	public Payment getPayment() {
		return this.payment;
	}
	
	@Override
	public String toString() {
		return "{" + person + " goes with flight " + flight + " with payment " + payment + " at seat " + seatIdentifier + "}";
	}
}
