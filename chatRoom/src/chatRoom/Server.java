package chatRoom;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.LinkedList;

public class Server extends Thread{
	
	static LinkedList<Socket> clients;
	static LinkedList<serverAdder> adders;
	HashMap<Socket, String> users;
	static ServerSocket servSock;
	static Socket socket;
	static serverListener manager;
	static Server serv;
	PrintWriter myWriter;
	
	
	//main
	public static void main(String[] args) throws IOException {	
		serv = new Server();
		openServer();	
		listenAdd();
	}
	
	//constructor
	public Server() {
		clients = new LinkedList<Socket>();
		adders = new LinkedList<serverAdder>();
		users = new HashMap<Socket, String>();
	}
	
	//Start the server
	private static void openServer() {
		try {
			servSock = new ServerSocket(7777);
			System.out.println("Open server on port 7777.");
        }
        catch (IOException e) {
            System.err.println("Could not listen on port: 7777");
            System.exit(1);
        }
	}
	
	//listen for new clients and add them to the chat
	private static void listenAdd() throws IOException {
		
		boolean listening = true;
//		BufferedReader MyReader;
//		PrintWriter myWriter = null;			
		
		while (listening) {
			try {
				while(listening) {
					System.out.println("waiting for new client...");
					socket = servSock.accept();
					System.out.println("got one.");
					adders.add( new serverAdder(serv,socket));
					System.out.println("added to take care of him.");
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}	
		servSock.close();	
	}
	
	//Create new listener for the new client
	public synchronized void inform(Socket socket) throws IOException {
		new serverListener(this,servSock,socket);
	}
	
	//Send a massage to all clients
	public synchronized void broadcast(String message) throws IOException {
		for(Socket sock: clients) {
			String _message=message;
			myWriter = new PrintWriter(sock.getOutputStream(), true);
			myWriter.println(_message);
		}
	}
	
}
