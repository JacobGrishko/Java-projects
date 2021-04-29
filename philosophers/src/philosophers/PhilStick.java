package philosophers;

public class PhilStick {

	boolean stick1=false;
	boolean stick2=false;
	boolean stick3=false;
	boolean stick4=false;
	boolean stick5=false;
	
	boolean inUse = false;
	int stickNum;
	
	Philosopher _user;
	
	public PhilStick(int num) {
		stickNum=num;
	}
	
	//use method to get a stick
	public synchronized boolean use(Philosopher user) {
		while(_user!=null) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("stick "+stickNum+"in use by "+user._id);
		inUse=true;
		_user=user;
		return true;
	}
	
	//method to release a stick after eating
	public synchronized void release() {
		System.out.println("stick "+stickNum+"released");
		inUse=false;
		_user = null;
		notifyAll();
	}
}
