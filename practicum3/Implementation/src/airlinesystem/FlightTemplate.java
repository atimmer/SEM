package airlinesystem;

public class FlightTemplate {

	private int flightNumber;
	private String origin;
	private String destination;
	private int time;
	
	public FlightTemplate(int flightNumber, String origin, String destination, int time) {
		this.flightNumber = flightNumber;
		this.origin = origin;
		this.destination = destination;
		this.time = time;
	}
	
	public int getFlightNumber() {
		return this.flightNumber;
	}
	
	public String getOrigin() {
		return this.origin;
	}
	
	public String getDestination() {
		return this.destination;
	}
	
	/**
	 * Returns the time (in minutes in minutes after midnight)
	 * 
	 * @return The time in minutes after midnight
	 */
	public int getTime() {
		return this.time;
	}
	
}
