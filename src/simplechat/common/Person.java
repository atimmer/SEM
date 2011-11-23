package simplechat.common;

public class Person
{
  private String nickname;
  private String password;
  
  private static ArrayList<Person> persons;
  
  public Person(String nickname, String password) {
    this.nickname = nickname;
    this.password = password;
  }
  
  public static Person register(String nickname, String password, String passwordConfirmation) {
    Person result = null;
    if (password == passwordConfirmation) { 
      result = new Person(nickname, password);
      persons.add(result);
    }
    return result;
  }
  
  public boolean authenticate(String nickname, String password) {
    return this.nickname == nickname && this.password == password;
  }
  
  public boolean changeNickname(String newNickname, String password) {
    boolean result = false;
    if (this.password == password) {
      this.nickname = newNickname;
      result = true;
    }
    return result;
  }
  
  public boolean changePassword(String newPassword, String password, String passwordConfirmation) {
    boolean result = false;
    if (this.password == password && password == passwordConfirmation) {
      this.password = newPassword;
      result = true;
    }
    return result
  }
  
  public static boolean userExists(String nickname) {
    boolean found = false;
    for (int i=0; i<persons.size() && found == false; i++) {
      if (persons.get(i).nickname == nickname) {
        found = true;
      }
    }
    return found;
  }

  public boolean equals(Object other) {
    return other instanceof Person && other.nickname == this.nickname
  }
  
}
