package chatRoom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class serverAdder extends Thread{
	
	Server _server;
	private Socket _sock;
	String name;

	BufferedReader MyReader;
	PrintWriter myWriter;
	
	boolean talking=true;
	boolean nameCheck =true;
	boolean listening = true;
	
	public serverAdder(Server server,Socket sock) {
		_server = server;
		_sock = sock;
		start();
	}
	
	public void run() {
		try {
			MyReader = new BufferedReader(new InputStreamReader(_sock.getInputStream()));
			myWriter = new PrintWriter(_sock.getOutputStream(), true);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String fromClient=null;
//		String fromServer=null;
		

		try {
			fromClient = MyReader.readLine();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		name = fromClient;
		myWriter.println("Server> Hello "+name+ " try to be nice to the others.");
		
		_server.clients.add(_sock);
		_server.users.put(_sock, name);
		
	
		if(_server.clients.size()!=0) {
			myWriter.println("users:"+_server.users.values());
		}else
			myWriter.println("Server> You are the first in the chat.");
		

		try {
			_server.inform(_sock);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			_server.broadcast("Server> "+_server.users.get(_sock)+" has joined");
			_server.broadcast("users:"+_server.users.values());
		} catch (IOException e1) {
			System.out.println("coundnt broadcast");
			e1.printStackTrace();
		}
		

	}
}
