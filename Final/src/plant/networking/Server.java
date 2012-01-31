package plant.networking;

import java.util.*;
import java.io.*;
import java.net.*;
import plant.*;

/**
 * Class representing the central server of the manufacturing plant
 * 
 * @author Koen van Urk and Anton Timmermans
 */
public class Server extends Thread {

	private ServerSocket server;
	private List<ClientHandler> clients;
	private int port;
	private Factory factory;
	
	/**
	 * Creates a new server with the given port
	 * @param port The port number for this server
	 */
	public Server(int port) {
		clients = new ArrayList<ClientHandler>();
		this.port = port;
		this.factory = new Factory("Stuffed Animals LLC");
	}
	
	/**
	 * Method that continually listens for new clients and accepts them
	 */
	public void run() {
		
		try {
			server = new ServerSocket(port);
		} catch(IOException e) {
			System.out.println("Server could not be started. Exiting.");
			System.exit(1);
		}
		
		System.out.println("OK!");

		try {
			// Keep listening for incoming connections
			while(true) {
				ClientHandler c = new ClientHandler(this, server.accept());
				clients.add(c);
				c.start();
			}
		} catch(IOException e) {
			System.out.println("An error occured while trying to accept a new client");
		}
		
	}
	
	/**
	 * Removes a client from the list
	 * @param c The client to remove
	 */
	public void removeClient(ClientHandler c) {
		clients.remove(c);
	}
	
	/**
	 * Returns the factory managed by this server
	 * @return A factory
	 */
	public Factory getFactory() {
		return this.factory;
	}
	
	/**
	 * This is the start of the app, where you start the server
	 * @param args No arguments accepted
	 */
	public static void main(String[] args) {
		User.addUser("koen", "mypass");
		(new Server(1238)).start();
	}
	
}
