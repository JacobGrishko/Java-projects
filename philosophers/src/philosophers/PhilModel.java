package philosophers;

public class PhilModel {
	
	PhilView _view;	
	
	PhilStick stick1= new PhilStick(1);
	PhilStick stick2= new PhilStick(2);
	PhilStick stick3= new PhilStick(3);
	PhilStick stick4= new PhilStick(4);
	PhilStick stick5= new PhilStick(5);
		
	Philosopher phil1;
	Philosopher phil2;
	Philosopher phil3;
	Philosopher phil4;
	Philosopher phil5;
	
	public boolean started=false;
	
	//constructor
	public PhilModel() {
		createPhilosophers();
		startPhilosophers();
	}
	
	//create philosophers and attach relevant sticks
	public void createPhilosophers() {
		phil1 = new Philosopher(1,stick1,stick2);
		phil2 = new Philosopher(2,stick2,stick3);
		phil3 = new Philosopher(3,stick3,stick4);
		phil4 = new Philosopher(4,stick4,stick5);
		phil5 = new Philosopher(5,stick5,stick1);
	}
	
	//start all phil threads
	public void startPhilosophers() {
		started=true;
		phil1.start();
		phil2.start();
		phil3.start();
		phil4.start();
		phil5.start();
	}
	
	//send reference 
	public void sendRef(PhilView view) {
		_view = view;
		phil1.setRef(view);
		phil2.setRef(view);
		phil3.setRef(view);
		phil4.setRef(view);
		phil5.setRef(view);
	}
}
