package newsBrodcast;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class newsClient {

	static newsClient client;
	
	JFrame window;
	JPanel panel;
	
	static JTextArea textArea;
	static JTextField inputArea;
	
	static JButton btnConnect;
	static JButton btnDisconnect;
	static JButton btnClear;
	
	static InetAddress address;
	static DatagramSocket socket;
	static DatagramPacket packet;
	static byte[] buf;
	static String serverName;
	
	static boolean listening;
	
	public newsClient() {
		
		
		window = new JFrame();
		panel = new JPanel();
		
		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
		panel.setLayout(boxlayout);
		
		textArea = new JTextArea(30, 40);
		inputArea = new JTextField();
		
		inputArea.setText("server name (like 'localhost')");
		
		textArea.setLineWrap(true);
		
		btnClear = new JButton("Clear");
		btnConnect = new JButton("Connect");
		btnDisconnect = new JButton("Disconnect");
		
		btnDisconnect.setEnabled(false);
		
		btnClear.addActionListener(new ActionListener() { 
		  public void actionPerformed(ActionEvent e) { 
			  textArea.setText("");
		  } 
		} );
		
		btnConnect.addActionListener(new ActionListener() { 
		  public void actionPerformed(ActionEvent e) { 
		        socket = null;
		        
				try {
					socket = new DatagramSocket();
					System.out.println("new datagram socket");
				} catch (SocketException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}

		        buf = new byte[256];
		        address = null;
		        
				try {
					address = InetAddress.getByName(inputArea.getText());
					System.out.println("got address "+address);
				} catch (UnknownHostException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} //InetAddress ahs no constructor
				
		        packet = new DatagramPacket(buf, buf.length, address, 7777);
		        System.out.println("created packet");
		        try {
					socket.send(packet);
					System.out.println("sent packet");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		        
		        textArea.append("connected.\n");
		        
		        listening=true;
		        btnConnect.setEnabled(false);
		        btnDisconnect.setEnabled(true);
		        
		        System.out.println("starting receiving..");
		        
		        new newsReceiver(client);

		        System.out.println("receive stoped");
		  } 
		} );
		
		btnDisconnect.addActionListener(new ActionListener() { 
		  public void actionPerformed(ActionEvent e) { 
			  listening=false;
			  btnConnect.setEnabled(true);
		      btnDisconnect.setEnabled(false);
		      socket.close();
		  } 
		} );
		
		JScrollPane scrollPane = new JScrollPane(textArea); 
		textArea.setEditable(false);
		
		window.add(panel);
		panel.add(textArea);
		panel.add(inputArea);
		panel.add(btnClear);
		panel.add(btnConnect);
		panel.add(btnDisconnect);
		
		
		window.pack();
		
		window.setTitle("GETTING NEWS!");
		window.setVisible(true);
	}
	
	public static void receiveNews() throws IOException {
		System.out.println("listening before while");	
			while(listening) {
				System.out.println("inside while loop");
				packet = new DatagramPacket(buf, buf.length);
				System.out.println("new packet");
		        socket.receive(packet);//block
		        System.out.println("got some news");
		        System.out.println(new String(packet.getData()).trim());
			}
	}
	
	public static void main(String[] args) throws IOException {
		client = new newsClient();	

	}

}
