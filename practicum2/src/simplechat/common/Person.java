package simplechat.common;

import java.util.ArrayList;

public class Person
{
  private String nickname;
  private String password;
  private boolean loggedIn;
  
  private static ArrayList<Person> persons;
  
  private Person(String nickname, String password) {
    this.nickname = nickname;
    this.password = password;
  }
  
  public static Person register(String nickname, String password, String passwordConfirmation) {
	  if(persons == null) {
		  persons = new ArrayList<Person>();
	  }
    Person result = null;
    if (!userExists(nickname) && password.equals(passwordConfirmation)) { 
      result = new Person(nickname, password);
      persons.add(result);
    }
    return result;
  }
  
  public String getNickname() {
	  return this.nickname;
  }
  
  public static Person authenticate(String nickname, String password) {
	  
	  Person result = null;
	  
	  if(userExists(nickname)) {
		  
		  for (int i=0; i<persons.size() && result == null; i++) {
		      if (persons.get(i).nickname.equals(nickname)) {
		    	  result = persons.get(i);
		    	  
		    	  if(result.nickname.equals(nickname) && result.password.equals(password)) {
		    		  // Logged in!
		    		  result.loggedIn = true;
		    	  }else{
		    		  result = null;
		    	  }
		      }
		  }
		  
	  }
	 
	  return result;
  }
  
  public boolean loggedIn() {
	  return this.loggedIn;
  }
  
  public void logout() {
	  this.loggedIn = false;
  }
  
  public boolean changeNickname(String newNickname) {
    boolean result = false;
    if (this.loggedIn && !userExists(newNickname)) {
      this.nickname = newNickname;
      result = true;
    }
    return result;
  }
  
  public boolean changePassword(String newPassword, String newPasswordConfirmation, String passwordConfirmation) {
    boolean result = false;
    if (this.password.equals(passwordConfirmation) && newPassword.equals(newPasswordConfirmation)) {
      this.password = newPassword;
      result = true;
    }
    return result;
  }
  
  public static boolean userExists(String nickname) {
    boolean found = false;
    for (int i=0; i<persons.size() && found == false; i++) {
      if (persons.get(i).nickname.equals(nickname)) {
        found = true;
      }
    }
    return found;
  }

  public boolean equals(Object other) {
	  
    return other instanceof Person && ((Person)other).nickname.equals(this.nickname);
  }
  
}
