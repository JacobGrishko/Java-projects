package chatRoom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;


public class serverListener extends Thread {
	
	ServerSocket _servSock;
	Socket _socket;
	boolean listening;
	Server _server;
	BufferedReader reader;
	String name;
	
	public serverListener(Server server, ServerSocket servSock, Socket socket) {
		System.out.println("new server listener");
		_server = server;
		_servSock = servSock;
		_socket = socket;
		listening = true;
		start();
	}


	public void run() {
		String message;
		try {
			reader = new BufferedReader(new InputStreamReader(_socket.getInputStream()));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		name = _server.users.get(_socket);
		
		while (listening) {
			System.out.println(">>>serv listening");
			try {
				if((message = reader.readLine())!=null){
					if(message.equals("EXIT1")) {
						
						try {
							_server.broadcast("Server> "+name+" has left");
							
						} catch (IOException e1) {
							System.out.println("coundnt broadcast");
							e1.printStackTrace();
						}
//						_server.users.remove(_socket);
//						_socket.close();
						listening=false;
					}else {
						System.out.println(message);
						_server.broadcast(message);
						message=null;
					}
					
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
		_server.users.remove(_socket);	
		try {
			_server.broadcast("users:"+_server.users.values());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		System.out.println(">>>serv stoped listening");
	}
	
}
