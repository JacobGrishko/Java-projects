package chatRoom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class clientListener extends Thread{

	Client _client;
	Socket _socket;	
	BufferedReader in;

	//constructor
	public clientListener(Client client, Socket socket) throws IOException {
		_client = client;
		_socket=socket;
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		start();
	}
	
	public void run() {
		String input;
		
		while(_client.talking) {
			try {
				if((input = in.readLine())!=null) {
					if(input.contains("users:")) {
						_client.textArea2.setText(input);
					}else {
						_client.textArea.append(input+"\n");
						System.out.println(input);
					}
					
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			input=null;			
		}		
	}
}
