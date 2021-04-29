package newsBrodcast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class newsReceiver extends Thread{
	
	newsClient client;
	DateTimeFormatter dtf;
    LocalDateTime now;
    
	public newsReceiver(newsClient client) {
		System.out.println("new receiver");
		this.client=client;
		start();
	}
	
	public void run() {
		System.out.println("listening before while");	
		while(client.listening) {
			System.out.println("inside while loop");
			client.packet = new DatagramPacket(client.buf, client.buf.length);
			System.out.println("new packet");
			try {
				client.socket.receive(client.packet);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//block
	        System.out.println("got some news");
	        String message = new String(client.packet.getData()).trim();
	        
	        dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");  
	        now = LocalDateTime.now();  
	        System.out.println(dtf.format(now)+">>>"+message+"\n"); 
	        
	        client.textArea.append(dtf.format(now)+">>>"+message+"\n");
//	        client.textArea.append(">>>"+message+"\n");
	        System.out.println("printed");
	        
	        client.buf = new byte[256];
	        dtf=null;
	        now=null;
		}
	}
}
