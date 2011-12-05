package airlinesystem.input;

import java.io.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

import airlinesystem.Airline;
import airlinesystem.Flight;
import airlinesystem.FlightTemplate;
import airlinesystem.Person;

public class CommandLine {
	
	private BufferedReader reader;
	private Airline akAirlines;
	
	/**
	 * Initializes the CommandLine object
	 * @require inputStream != null
	 */
	public CommandLine(InputStream inputStream) {
		reader = new BufferedReader(new InputStreamReader(inputStream));
		akAirlines = new Airline("akAirlines");
	}
	
	/**
	 * Starts up the CommandLine program, reads from the command line indefinitely
	 */
	public void init() {
		System.out.println("Welcome to the Airline System");
		
		try {
			String input; boolean continueLooping = true;
			while(continueLooping && (input = reader.readLine()) != null) {
				ArrayList<String> inputArray = splitCommand(input);
				Command cmd = processCommand(inputArray.get(0));
				
				if (cmd == null) {
					cmd = new HelpCommand();
				}
				cmd.execute(inputArray);
				continueLooping = cmd.continueLooping();
			}
		} catch (IOException e) {
			System.out.println("An IOexception has occured");
		}
	}
	
	private ArrayList<String> splitCommand(String input) {
		ArrayList<String> result = new ArrayList<String>();
		Scanner scn = new Scanner(input);
		while(scn.hasNext()) {
			result.add(scn.next());
		}
		
		return result;
	}
	
	private Command processCommand(String command) {
		Command result;
		
		result = new ExitCommand();
		if(command.equals(result.commandString())) {
			return result;
		}
		
		result = new CreateBookingCommand();
		if(command.equals(result.commandString())) {
			return result;
		}
		
		result = new CreatePersonCommand();
		if(command.equals(result.commandString())) {
			return result;
		}
		
		result = new CreateEmployeeCommand();
		if(command.equals(result.commandString())) {
			return result;
		}
		
		result = new CreateFlightFromTemplateCommand();
		if(command.equals(result.commandString())) {
			return result;
		}
		
		result = new CreateFlightTemplateCommand();
		if(command.equals(result.commandString())) {
			return result;
		}
		
		result = new GetPersonCommand();
		if(command.equals(result.commandString())) {
			return result;
		}
		
		result = new GetFlightCommand();
		if(command.equals(result.commandString())) {
			return result;
		}
		
		result = new GetFlightsCommand();
		if(command.equals(result.commandString())) {
			return result;
		}
		
		result = new GetHasBookingCommand();
		if(command.equals(result.commandString())) {
			return result;
		}
		
		result = new ShowAirlineCommand();
		if(command.equals(result.commandString())) {
			return result;
		}
		
		return null;
	}
	
	public static void main(String args[]) {		
		new CommandLine(System.in).init();
	}
	
	private abstract class Command {
		
		/**
		 * Executes the command
		 * @param params These are the params needed for the command
		 * @require params != null
		 */
		public abstract void execute(ArrayList<String> inputArray);
		
		/**
		 * Returns the string needed to trigger this command
		 * @return The string needed to trigger this command
		 * @ensure result != null
		 */
		public abstract String commandString();
		
		/**
		 * Function to determine if the program should still run after this command
		 * @return Whether or not the program should continue running after this command
		 */
		public boolean continueLooping() {
			return true;
		}
	}
	
	private class ExitCommand extends Command {
		public void execute(ArrayList<String> input) {
			System.out.println("Now exiting...");
		}
		
		public boolean continueLooping() {
			return false;
		}

		@Override
		public String commandString() {
			return "exit";
		}
	}
	
	private class HelpCommand extends Command {
		public void execute(ArrayList<String> input) {
			p("This is the help");
			p("Commands (date's in this format: yyyy-mm-dd)");
			p(String.format("%-50s- %s", "createbooking person flight flightDate", "Creates a booking for the person on the flight"));
			p(String.format("%-50s- %s", "createperson id name", "Creates a person with id and name"));
			p(String.format("%-50s- %s", "createemployee id name job", "Creates a person with id and name and the job"));
			p(String.format("%-50s- %s", "createflight flighttemplate date", "Creates a booking for the person with personId as identifier"));
			p(String.format("%-50s- %s", "createtemplate id, origin, destination, time", "Creates a booking for the person with personId as identifier"));
			p(String.format("%-50s- %s", "getperson id", "Displays the person with id"));
			p(String.format("%-50s- %s", "gettemplate id", "Get's the template with the id"));
			p(String.format("%-50s- %s", "getflights origin destination date", "Gets all flights with the specified origin, destination and date"));
			p(String.format("%-50s- %s", "hasbooking person flight date", "Returns whether this person has a booking for the specified flight"));
			p(String.format("%-50s- %s", "show", "Show the airline"));
			p(String.format("%-50s- %s", "anything not specified", "Shows this message"));
		}
		
		public String commandString() { return ""; }
	}
	
	private class CreateBookingCommand extends Command {
		public void execute(ArrayList<String> input) {
			Person person = akAirlines.personWithIdentifier(Integer.parseInt(input.get(1)));
			Flight flight = akAirlines.flightWithNumberAndDate(Integer.parseInt(input.get(2)), Date.valueOf(input.get(3)));
			
			akAirlines.createBooking(person, flight);
			p("Succesfully created a booking");
		}
		
		public String commandString() { return "createbooking"; }
	}
	
	private class CreatePersonCommand extends Command  {
		public void execute(ArrayList<String> input) {
			akAirlines.createPerson(Integer.parseInt(input.get(1)), input.get(2));
			p("Person successfully created");
		}

		public String commandString() { return "createperson"; }
	}
	
	private class CreateEmployeeCommand extends Command  {
		public void execute(ArrayList<String> input) {
			akAirlines.createEmployee(Integer.parseInt(input.get(1)), input.get(2), input.get(3));
			p("Employee successfully created");
		}
		
		public String commandString() { return "createemployee"; }
	}
	
	private class CreateFlightFromTemplateCommand extends Command  {
		public void execute(ArrayList<String> input) {
			FlightTemplate template = akAirlines.flightTemplateWithNumber(Integer.parseInt(input.get(1)));
			akAirlines.createFlightFromTemplate(template, Date.valueOf(input.get(2)));
			p("Flight succesfully created from flight template");
		}
		
		public String commandString() { return "createflight"; }
	}
	
	private class CreateFlightTemplateCommand extends Command  {
		public void execute(ArrayList<String> input) {
			akAirlines.createFlightTemplate(Integer.parseInt(input.get(1)), input.get(2), input.get(3), Integer.parseInt(input.get(4)));
			p("Flight template successfully created");
		}
		
		public String commandString() { return "createtemplate"; }
	}
	
	private class GetPersonCommand extends Command  {
		public void execute(ArrayList<String> input) {
			p("This is the person you requested:");
			p(akAirlines.personWithIdentifier(Integer.parseInt(input.get(1))));
		}
		
		public String commandString() { return "getperson"; }
	}
	
	private class GetFlightCommand extends Command  {
		public void execute(ArrayList<String> input) {
			p("This is the flight template you requested:");
			p(akAirlines.flightTemplateWithNumber(Integer.parseInt(input.get(1))));
		}
		
		public String commandString() { return "gettemplate"; }
	}
	
	private class GetFlightsCommand extends Command  {
		public void execute(ArrayList<String> input) {
			p(akAirlines.flightsFromToWithDate(input.get(1), input.get(2), Date.valueOf(input.get(3))));
		}
		
		public String commandString() { return "getflights"; }
	}
	
	private class GetHasBookingCommand extends Command  {
		public void execute(ArrayList<String> input) {
			p(akAirlines.personHasBookingForFlight(akAirlines.personWithIdentifier(Integer.parseInt(input.get(1))), akAirlines.flightWithNumberAndDate(Integer.parseInt(input.get(2)), Date.valueOf(input.get(3)))));
		}
		
		public String commandString() { return "hasbooking"; }
	}
	
	private class ShowAirlineCommand extends Command {
		public void execute(ArrayList<String> input) {
			p(akAirlines);
		}
		
		public String commandString() { return "show"; }
	}
	
	private void p(Object something) {
		System.out.println(something);
	}
}
