// This file contains material supporting section 3.7 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at www.lloseng.com

package simplechat.client;

import ocsf.client.*;
import simplechat.common.*;
import java.io.*;

/**
 * This class overrides some of the methods defined in the abstract
 * superclass in order to give more functionality to the client.
 *
 * @author Dr Timothy C. Lethbridge
 * @author Dr Robert Lagani&egrave;
 * @author Fran&ccedil;ois B&eacute;langer
 * @version July 2000
 */
public class ChatClient extends AbstractClient
{
  //Instance variables **********************************************

  /**
   * The interface type variable.  It allows the implementation of
   * the display method in the client.
   */
  ChatIF clientUI;
  
  int loggingIn;
  int registering;
  int changingPass;


  //Constructors ****************************************************

  /**
   * Constructs an instance of the chat client.
   *
   * @param host The server to connect to.
   * @param port The port number to connect on.
   * @param clientUI The interface type variable.
   */

  public ChatClient(String host, int port, ChatIF clientUI)
    throws IOException
  {
    super(host, port); //Call the superclass constructor
    this.clientUI = clientUI;
    openConnection();

    clientUI.display("A connection has been established to the server, you must first login or register.");
    clientUI.display("For help on the available commands press \"help\"");
  }
  
  private void showHelp() {
	  clientUI.display("login        -- Login to an existing account at the server ");
	  clientUI.display("register     -- Register for an account at the server");
	  clientUI.display("help         -- Display this message");	
  }


  //Instance methods ************************************************

  /**
   * This method handles all data that comes in from the server.
   *
   * @param msg The message from the server.
   */
  public void handleMessageFromServer(Object msg)
  {
    clientUI.display(msg.toString());
  }

  /**
   * This method handles all data coming from the UI
   *
   * @param message The message from the UI.
   */
  public void handleMessageFromClientUI(String message)
  {
    try
    {
    	boolean sendMessage = true;

    	if(message.length() > 0 && message.charAt(0) == ':') {
			message = ":" + message;
		}
    	
    	if(loggingIn == 1) {
    		loggingIn = 2;
    		message = ":USER " + message;
    		clientUI.display("Give your password");
    	} else if(loggingIn == 2) {
    		loggingIn = 0;
    		message = ":PASS " + message;
    	} else if(registering == 1) {
    		loggingIn = 2;
    		message = "RGT1 " + message;
    		clientUI.display("Give your preffered password");
    	} else if(registering == 2) {
    		loggingIn = 3;
    		message = "RGT2 " + message;
    		clientUI.display("Confirm your password");
    	} else if(registering == 3) {
    		loggingIn = 0;
    		message = "RGT3" + message;
    	}
		
		if(message.equals("login")) {
			clientUI.display("Give your username");
			loggingIn = 1;
			sendMessage = false;
		} else if(message.equals("register")) {
			clientUI.display("Give a username");
			registering = 1;
			sendMessage = false;
		} else if(message.equals("help")) {
			showHelp();
			sendMessage = false;
		}
		
		if (sendMessage == true) {
			sendToServer(message);
		}
	
	  
    }
    catch(IOException e)
    {
      clientUI.display
        ("Could not send message to server.  Terminating client.");
      quit();
    }
  }

  /**
   * This method terminates the client.
   */
  public void quit()
  {
    try
    {
      closeConnection();
    }
    catch(IOException e) {}
    System.exit(0);
  }
  
  
  protected void connectionClosed() {
	  System.out.println("The connection was closed -- you have been disconnected!");
	  System.exit(0);
  }
  
  protected void connectionException(Exception e) {
	  System.out.println("An exception has occured -- you have been disconnected!");
	  System.exit(0);
  }
  
}
//End of ChatClient class
