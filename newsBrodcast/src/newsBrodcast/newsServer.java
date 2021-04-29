package newsBrodcast;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class newsServer {

	JFrame window;
	JPanel panel;
	
	static JTextField inputArea;
	static JButton btnSend;
	
	static DatagramSocket socket;
	static DatagramPacket packet;
	
	private static ArrayList<DatagramPacket>  clients  = new ArrayList<DatagramPacket>();
	
	public newsServer() {
		window = new JFrame();
		panel = new JPanel();
		
		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
		panel.setLayout(boxlayout);
		
		inputArea = new JTextField(30);
		
		btnSend = new JButton("Send");
		
		btnSend.addActionListener(new ActionListener() { 
		  public void actionPerformed(ActionEvent e) { 
			  new newsSender(clients,inputArea.getText());
			  inputArea.setText("");
		  } 
		} );

		window.add(panel);

		panel.add(inputArea);
		panel.add(btnSend);

		window.pack();
		
		window.setTitle("SENDING NEWS!");
		window.setVisible(true);
	}
	
	public static void main(String[] args) {
		newsServer server = new newsServer();
		try {
			listen();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void listen() throws IOException {
		
		boolean listening=true;
		
		try {
			socket = new DatagramSocket(7777);
			System.out.println("new listening packet");
			while (listening) {
				
				byte[] buf = new byte[256];
				packet = new DatagramPacket(buf, buf.length);
				socket.receive(packet);//block
				System.out.println("got something");
				clients.add(packet);
				System.out.println("added to clients");
			}
			
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			socket.close();
		}
	
	}

}
