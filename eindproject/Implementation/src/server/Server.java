package server;

import java.net.ServerSocket;

public class Server implements Runnable {

	/**
	 * The server socket: listens for clients who want to connect.
	 */
	private ServerSocket serverSocket = null;
	
	/**
	 * The connection listener thread.
	 */
	private Thread connectionListener;
	
	public Server() {
		startListening();
	}
	
	public Server(int port) {
		startListening(port);
	}
	
	public void startListening() {
		startListening(1337);
	}
	
	public void startListening(int port) {
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
