package airlinesystem;

public class FlightTemplate {

	private int flightNumber;
	
	/**
	 * origin != null
	 */
	private String origin;
	
	/**
	 * destination != null
	 */
	private String destination;
	
	private int time;
	
	/**
	 * Initializes a flight template
	 * 
	 * @param flightNumber The flight number this flight template should have
	 * @param origin The origin of which a flight created from this flight template departs
	 * @param destination The destination to which a flight created from this flight flies
	 * @param time The time at which flights created from this template depart
	 * 
	 * @require origin != null && destination != null
	 */
	public FlightTemplate(int flightNumber, String origin, String destination, int time) {
		this.flightNumber = flightNumber;
		this.origin = origin;
		this.destination = destination;
		this.time = time;
	}
	
	/**
	 * Gets the flight number of this flight template
	 * 
	 * @return the flight number of this flight template
	 */
	public int getFlightNumber() {
		return this.flightNumber;
	}
	
	/**
	 * Gets the origin of this flight template
	 * 
	 * @ensure result != null
	 * 
	 * @return The origin of this flight template
	 */
	public String getOrigin() {
		return this.origin;
	}
	
	/**
	 * Gets the destination of this flight template
	 * 
	 * @ensure result != null
	 * 
	 * @return The destination of this flight template
	 */
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
	
	@Override
	public String toString() {
		return "{flightTemplate " + flightNumber + " from " + origin + " to " + destination + " at " + time + " a clock}"; 
	}
	
}
