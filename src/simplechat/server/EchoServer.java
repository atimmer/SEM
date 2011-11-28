package simplechat.server;

// This file contains material supporting section 3.7 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at www.lloseng.com

import java.io.*;

import simplechat.common.*;
import ocsf.server.*;

/**
 * This class overrides some of the methods in the abstract
 * superclass in order to give more functionality to the server.
 *
 * @author Dr Timothy C. Lethbridge
 * @author Dr Robert Lagani&egrave;re
 * @author Fran&ccedil;ois B&eacute;langer
 * @author Paul Holden
 * @version July 2000
 */
public class EchoServer extends AbstractServer
{
  //Class variables *************************************************

  /**
   * The default port to listen on.
   */
  final public static int DEFAULT_PORT = 5555;

  //Constructors ****************************************************

  /**
   * Constructs an instance of the echo server.
   *
   * @param port The port number to connect on.
   */
  public EchoServer(int port)
  {
    super(port);
  }


  //Instance methods ************************************************
  
  private void sendErrorToClient(ConnectionToClient client) {
	  try {
			client.sendToClient("* ERROR. INVALID COMMAND!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  }
  
  private void sendConfirmationToClient(ConnectionToClient client) {
	  try {
			client.sendToClient("+ Success");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  }

  /**
   * This method handles any messages received from the client.
   *
   * @param msg The message received from the client.
   * @param client The connection from which the message originated.
   */
  public void handleMessageFromClient
    (Object msg, ConnectionToClient client)
  {
    System.out.println("Message received: " + msg + " from " + client);
    
    String message = (String)msg;
    
    Person p = (Person)client.getInfo("User");
    
    if(message.length() < 2 || message.charAt(0) != ':' || message.charAt(1) == ':') {
    	// We have a normal message here. 
    	if(p != null && p.loggedIn()) {
    		this.sendToAllClients(p.getNickname() + ": " + message);
    	}else{
    		this.sendErrorToClient(client);
    	}
    }else{
    	if(message.length() < 5) {
    		this.sendErrorToClient(client);
    	}else{
    		String command = message.substring(1, 5);
    		
    		if(command.equals("USER")) {
    			if(message.length() < 7) {
    				this.sendErrorToClient(client);
    			}else{
    				client.setInfo("Username", message.substring(6));
    			}
    		}else if(command.equals("PASS")) {
    			if(message.length() < 7) {
    				this.sendErrorToClient(client);
    			}else{
    				String password = message.substring(6);
    				String username = (String)client.getInfo("Username");
    				
    				if(password == null || username == null) {
    					this.sendErrorToClient(client);
    				}else{
    					Person authenticated = Person.authenticate(username, password);
    					
    					if(authenticated != null) {
    						this.sendConfirmationToClient(client);
    						client.setInfo("User", authenticated);
    					}else{
    						this.sendErrorToClient(client);
    					}
    				}
    			}
    		}else if(command.equals("NWNN")) {
    			// NeW NickName
    			if(message.length() < 7 || p == null || p.loggedIn() == false) {
    				this.sendErrorToClient(client);
    			}else{
    				boolean succeeded = p != null && p.changeNickname(message.substring(6));
    				if(succeeded) {
    					this.sendConfirmationToClient(client);
    				}else{
    					this.sendErrorToClient(client);
    				}
    			}
    		}else if(command.equals("RGT1")) {
    			if(message.length() < 7) {
    				this.sendErrorToClient(client);
    			}else{
    				String parameter = message.substring(6);
    				client.setInfo("RGT1", parameter);
    			}
    		}else if(command.equals("RGT2")) {
    			if(message.length() < 7) {
    				this.sendErrorToClient(client);
    			}else{
    				String parameter = message.substring(6);
    				client.setInfo("RGT2", parameter);
    			}
    		}else if(command.equals("RGT3")) {
    			if(message.length() < 7) {
    				this.sendErrorToClient(client);
    			}else{
    				String rgt1 = (String)client.getInfo("RGT1");
    				String rgt2 = (String)client.getInfo("RGT2");
    				String rgt3 = message.substring(6);
    				
    				if(rgt1 == null || rgt2 == null || rgt3 == null || rgt1.length() == 0 || rgt2.length() == 0 || rgt3.length() == 0) {
    					this.sendErrorToClient(client);
    				}else{
    					Person newPerson = Person.register(rgt1, rgt2, rgt3);
    					if(newPerson == null) {
    						this.sendErrorToClient(client);
    					}else{
    						client.setInfo("User", newPerson);
    						newPerson.authenticate(rgt1, rgt2);
    						this.sendConfirmationToClient(client);
    					}
    				}
    				
    			}
    		}else if(command.equals("CHN1")) {
    			if(message.length() < 7) {
    				this.sendErrorToClient(client);
    			}else{
    				String parameter = message.substring(6);
    				client.setInfo("CHN1", parameter);
    			}
    		}else if(command.equals("CHN2")) {
    			if(message.length() < 7) {
    				this.sendErrorToClient(client);
    			}else{
    				String parameter = message.substring(6);
    				client.setInfo("CHN2", parameter);
    			}
    		}else if(command.equals("CHN3")) {
    			if(message.length() < 7) {
    				this.sendErrorToClient(client);
    			}else{
    				String rgt1 = (String)client.getInfo("CHN1");
    				String rgt2 = (String)client.getInfo("CHN2");
    				String rgt3 = message.substring(6);
    				
    				if(rgt1 == null || rgt2 == null || rgt3 == null || rgt1.length() == 0 || rgt2.length() == 0 || rgt3.length() == 0) {
    					this.sendErrorToClient(client);
    				}else{
    					boolean success = p.changePassword(rgt2, rgt3, rgt1);
    					if(success) {
    						this.sendConfirmationToClient(client);
    					}else{
    						this.sendErrorToClient(client);
    					}
    				}
    				
    			}
    		}
    		
    		else{
    			this.sendErrorToClient(client);
    		}
    	}
    }
  }

  /**
   * This method overrides the one in the superclass.  Called
   * when the server starts listening for connections.
   */
  protected void serverStarted()
  {
    System.out.println
      ("Server listening for connections on port " + getPort());
  }

  /**
   * This method overrides the one in the superclass.  Called
   * when the server stops listening for connections.
   */
  protected void serverStopped()
  {
    System.out.println
      ("Server has stopped listening for connections.");
  }

  
  protected void clientConnected(ConnectionToClient con) {
	  System.out.println("A new client has connected.");
  }
  
  protected void clientDisconnected(ConnectionToClient con) {
	  System.out.println("A client has disconnection.");
  }
  
  protected void clientException(ConnectionToClient con, Throwable e) {
	  System.out.println("A client triggered an exception." + e.getMessage());
  }
  
  
  //Class methods ***************************************************

  /**
   * This method is responsible for the creation of
   * the server instance (there is no UI in this phase).
   *
   * @param args[0] The port number to listen on.  Defaults to 5555
   *          if no argument is entered.
   */
  public static void main(String[] args)
  {
    int port = 0; //Port to listen on

    try
    {
      port = Integer.parseInt(args[0]); //Get port from command line
    }
    catch(Throwable t)
    {
      port = DEFAULT_PORT; //Set port to 5555
    }

    EchoServer sv = new EchoServer(port);

    try
    {
      sv.listen(); //Start listening for connections
    }
    catch (Exception ex)
    {
      System.out.println("ERROR - Could not listen for clients!");
    }
  }
}
//End of EchoServer class
