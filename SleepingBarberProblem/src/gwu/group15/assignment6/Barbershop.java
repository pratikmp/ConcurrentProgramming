package gwu.group15.assignment6;

public class Barbershop extends Thread {

	// Customers waiting for service
	public static Semaphore customers = new Semaphore(0);

	// Barbers waiting for customers
	public static Semaphore barbers = new Semaphore(0);

	public static Semaphore mutex = new Semaphore(1);

	public static int waiting;

	public static final int numSofa = 4;

	private ShopHGUI shopGUI;

	public Barbershop(ShopHGUI gui) {

		shopGUI = gui;

	}

	class Barber extends Thread {
		
	    public void run() {
			while (true) {
				customers.acquire(); // Acquire access to customers
				mutex.acquire(); // Acquire access to waiting
				waiting = waiting - 1; // Decrement count of waiting
				barbers.release(); // One barber is now ready to cut hair
				mutex.release(); // Release waiting
				cut_hair(); 

			}
		}

		public void cut_hair() {

			shopGUI.setBarber("Cutting hair");

			shopGUI.setTotalCapacity(waiting);

			try {
				sleep(4000);

			} catch (InterruptedException ex) {
			}
			
			if (waiting == 0) {
				shopGUI.setBarber("Sleeping");

			}

		}

	}

	private class Customer extends Thread {
		private int myNumber; 

		public Customer(int i) {
			myNumber = i;
		}

		public void run() { 

			if (waiting < numSofa) {
				mutex.acquire(); // Acquire access to waiting

				waiting = waiting + 1; // Increment count of waiting
				shopGUI.setTotalCapacity(waiting);

				customers.release();// release access of customers

				mutex.release(); // Release waiting
				barbers.acquire(); // Acquire access to barber
				get_haircut(); 

			}
			// No sofa left, Customer stand in the waiting room
			else {

				shopGUI.setExitStatus("Customer #" + (myNumber + 1) + ": Left, no waiting space");

			}

			shopGUI.setTotalCapacity(waiting);

		}

		public void get_haircut() {

			shopGUI.setBarberStatus("Customer #" + (myNumber + 1)	+ ": Getting hair cut");

			try {
				sleep(4000);

			} catch (InterruptedException ex) {
			}
			shopGUI.setExitStatus("Customer #" + (myNumber + 1) + ": Leave Now");
			
		}

	}

	public void run() {

		waiting = 0;

		Barber aBarber;
		Customer aCustomer;

		aBarber = new Barber();
		aBarber.start();

		int customerNumber = 0;
		while (customerNumber < 15) {

			aCustomer = new Customer(customerNumber++);

			aCustomer.start();
			try {
				sleep(2000);

			} catch (InterruptedException ex) {
			}

		}

	}

}
