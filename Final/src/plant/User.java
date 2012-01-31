package plant;

import java.util.ArrayList;

/**
 * Class to let users login and keep track of that
 * @author Koen van Urk and Anton Timmermans
 *
 */
public class User {

	/**
	 * Class representing a certain person
	 * @author Koen van Urk and Anton Timmermans
	 *
	 */
	private static class Person {
		private String username;
		private String password;
		
		/**
		 * Creates a new person with given username and password
		 * @param username Username
		 * @param password Password
		 */
		public Person(String username, String password) {
			this.username = username;
			this.password = password;
		}
		
		/**
		 * Checks whether the username and password match those of this person
		 * @param username The username to check
		 * @param password The password to check
		 * @return true if username and password match, false otherwise
		 */
		public boolean checkValid(String username, String password) {
			return username.equals(this.username) && password.equals(this.password);
		}
		
		/**
		 * Returns the username for this person
		 * @return Username for this person
		 */
		public String getUsername() {
			return this.username;
		}
	}
	
	private static ArrayList<Person> persons;
	private boolean loggedIn = false;
	private Person currentUser = null;
	
	/**
	 * Adds a user to the userbase
	 * @param username Username for the user
	 * @param password Password for the user
	 * @return true if adding the user was successful, false otherwise (i.e. when user already exists)
	 */
	public static boolean addUser(String username, String password) {
		
		if(persons == null) {
			persons = new ArrayList<Person>();
		}
		
		boolean result = true;
		
		for(int i = 0; i < persons.size() && result; i++) {
			if(persons.get(i).getUsername().equals(username)) {
				result = false;
			}
		}
		
		if(result) {
			persons.add(new Person(username, password));
		}
		
		return result;
	}
	
	/**
	 * Determines whether or not the user is logged in. To login use login(u,p)
	 * @return The current login state
	 */
	public boolean isLoggedIn() {
		return loggedIn;
	}
	
	/**
	 * Tries to log the user in
	 * @param username The username
	 * @param password The password
	 * @return When credentials are valid true, false otherwise
	 */
	public boolean login(String username, String password) {

		if(persons == null) {
			return false;
		}
		
		for(int i = 0; i < persons.size() && !loggedIn; i++) {
			if(persons.get(i).checkValid(username, password)) {
				loggedIn = true;
				currentUser = persons.get(i);
			}
		}
		
		return isLoggedIn();
	}
	
	/**
	 * Returns the username if the user is logged in or null otherwise
	 * @return Username for the logged in user, or null
	 */
	public String getUsername() {
		if(currentUser == null) {
			return null;
		}else{
			return currentUser.getUsername();
		}
	}
	
}
