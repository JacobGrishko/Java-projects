package chatRoom;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Client extends JFrame{
	static String name;
	static String IP;
	static BufferedReader in;
	static BufferedReader stdIn;
	static PrintWriter out;
	
	static boolean talking=true;
	static boolean starting=true;
	static boolean connected = false;
	
	JFrame window;
	JPanel panel;
	static JTextArea textArea;
	static JTextArea textArea2;
	static JTextField inputArea;
	static JButton btnSend;
	static JButton btnConnect;
	static JButton btnDisconnect;
	
	static Socket socket;
	static clientListener listener;
	static Client client;
	
	static String fromServer;
    static String fromUser;
	
    
    //***************************************************************Constructor
	public Client() {
		window = new JFrame();
		panel = new JPanel();
		
		
//		menuWindow.setLayout(new GridBagLayout());
		window.setSize(500, 700);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
		panel.setLayout(boxlayout);
		
		textArea = new JTextArea(30, 40);
		textArea2 = new JTextArea(2, 40);
		inputArea = new JTextField(30);
		btnSend = new JButton("Send");
		btnConnect = new JButton("Connect");
		btnDisconnect = new JButton("Disconnect");
		
		textArea.setLineWrap(true);
		
		btnConnect.setEnabled(false);
		btnDisconnect.setEnabled(false);
		
		btnSend.addActionListener(new ActionListener() { 
		  public void actionPerformed(ActionEvent e) { 
		    if(connected&&!starting&&!inputArea.getText().equals("")) {
		    	
		    	fromUser = inputArea.getText();
		    	out.println(name+": "+fromUser);
		    	System.out.println(name+": "+fromUser);
		    	inputArea.setText(null);
			
		    }
		    if(starting&&!inputArea.getText().equals("")) {
		    	name = inputArea.getText();
		    	textArea.append(name+"\n");
		    	System.out.println(name);
		    	inputArea.setText(null);
		    	
		    	textArea.append("to what IP would you like to connect to? write the IP and press Connect.\n");
		    	btnSend.setEnabled(false);
		    	btnConnect.setEnabled(true);
		    	
		    	starting=false;
		    	connected=true;
		    }
		  } 
		} );
		
		btnConnect.addActionListener(new ActionListener() { 
		  public void actionPerformed(ActionEvent e) { 
			  IP = inputArea.getText();
			  textArea.append("Trying to connect "+ name+" to "+IP+"\n");
			  inputArea.setText(null);
			  
			  try {
//				  socket = new Socket("127.0.0.1", 7777);
				  socket = new Socket(IP, 7777);
			  } catch (UnknownHostException e1) {
				  // TODO Auto-generated catch block
				  e1.printStackTrace();
			  } catch (IOException e1) {
				  // TODO Auto-generated catch block
				  e1.printStackTrace();
			  }
			  
			  
	          btnSend.setEnabled(true);
	          btnConnect.setEnabled(false);
	          btnDisconnect.setEnabled(true);
	          
	          try {
	        	  init();
	          } catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
	          }
	          
	          out.println(name);
	          textArea.append("Connected.\n");
		  } 
		} );
		
		btnDisconnect.addActionListener(new ActionListener() { 
		  public void actionPerformed(ActionEvent e) { 
			  textArea.append("Disconnecting....\n");
			  out.println("EXIT1");
			  try {
				  socket.close();
			  } catch (IOException e1) {
				  // TODO Auto-generated catch block
				  e1.printStackTrace();
			  }

			  System.exit(1);
		  } 
		} );
		
		
		JScrollPane scrollPane = new JScrollPane(textArea); 
		textArea.setEditable(false);
		
		window.add(panel);
		panel.add(textArea);
		panel.add(textArea2);
		panel.add(inputArea);
		panel.add(btnSend);
		panel.add(btnConnect);
		panel.add(btnDisconnect);
		
		window.pack();
		
		window.setTitle("Chat");
		window.setVisible(true);
	}
	
	//main
	public static void main(String[] args) throws IOException{
		client = new Client();
		textArea.append("whats your name?\n");

	}
	
	//initialize
	public void init() throws IOException {
		listener = new clientListener(this,socket);
		out = new PrintWriter(socket.getOutputStream(), true);
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		fromServer=null;
        fromUser = null;

        connected= true;
	}
	
}
