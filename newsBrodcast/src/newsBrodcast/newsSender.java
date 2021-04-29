package newsBrodcast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Iterator;



public class newsSender extends Thread{
	
	private ArrayList<DatagramPacket>  clients;
	private String message;
	
	
	public newsSender(ArrayList<DatagramPacket>  clients,String message) {
		this.clients=clients;
		this.message=message;
		start();
	}
	
	public void run() {
		
		try{
			DatagramSocket inSocket = new DatagramSocket();
			System.out.println("sender: new datagram");
			Iterator clientsIterator = clients.iterator();  
			System.out.println("sender: new iterator");
			while (clientsIterator.hasNext() ){
				System.out.println("sender: next client...");
				DatagramPacket data= (DatagramPacket) clientsIterator.next();
				InetAddress ip=data.getAddress();
				System.out.println("sender: ip- "+ip);
				int port=data.getPort();
				System.out.println("sender: port- "+port);
				
				byte[] buf = message.getBytes();
				System.out.println("sender: created buf with massage "+message);
				DatagramPacket packet = new DatagramPacket(buf, buf.length,ip,port);
				System.out.println("sender: created packet");
				inSocket.send(packet);
				System.out.println("sender: sent.");
				 
			}
			inSocket.close();  

		}
		catch (IOException e){
			e.printStackTrace();
		}
		
	}
	
}
