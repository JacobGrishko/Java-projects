package philosophers;

public class Philosopher extends Thread{
	
	int _id;
	PhilStick _stick1;
	PhilStick _stick2;
	boolean first;
	boolean second;
	boolean gotIt;
	boolean eating;
	boolean ate;
	
	PhilView _view;
	
	boolean thinking;
	boolean thought;

	
	public Philosopher(int id, PhilStick stick1, PhilStick stick2) {
		System.out.println(">CREATING PHILISOPHER.....");
		
		_id = id;
		_stick1=stick1;
		_stick2=stick2;
		eating=false;
//		ate=false;
		thinking=false;
//		thought=false;
		
		first=false;
		second=false;
	}
	
	public void run() {
		if(_view==null) {
			try {
				sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(_id%2==0) {
			try {
				System.out.println(_id+ "is waiting a second.");
				sleep(3000);
			} catch (InterruptedException e) {
				System.out.println("ERROR: SLEEP for phil " +_id+ ".");
				e.printStackTrace();
			}
		}
		
		
		while(true) {
				System.out.println(">"+_id+" STARTING RUN.......");

				
				first = _stick1.use(this);
				_view.panel.repaint();
				second = _stick2.use(this);
				_view.panel.repaint();
				
				if(first&&second) {
					eating=true;
					_view.panel.repaint();
					System.out.println("phil " +_id+ " is eating.");
					
					try {
						sleep((int)(Math.random() * 10000));
//						sleep(3000); 				//DEBUG
					} catch (InterruptedException e) {
						System.out.println("ERROR: SLEEP for phil " +_id+ ".");
						e.printStackTrace();
					}
					System.out.println("phil " +_id+ " finishing eating.");
					
					//*********************************************************
					eating=false;
					_view.panel.repaint();
					
					_stick1.release();
					first=false;
					_view.panel.repaint();
					_stick2.release();
					second=false;
					_view.panel.repaint();
					
					System.out.println("phil " +_id+ " done eating and started thinking.");
					thinking=true;
					
					_view.panel.repaint();
					try {
						sleep((int)(Math.random() * 10000));
//						sleep(3000); 			//DEBUG
					} catch (InterruptedException e) {
						System.out.println("ERROR: THINK for phil " +_id+ ".");
						e.printStackTrace();
					}
					thinking=false;
					_view.panel.repaint();
					
					System.out.println("phil " +_id+ " done thinking.");
				}

		}
	}
	
	public void setRef(PhilView view) {
		_view = view;
	}
}
