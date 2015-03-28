import java.util.concurrent.*;

public class ModifiedBarbershop extends Thread {

	// customers waiting for service
	public static Semaphore customers = new Semaphore(0);

	// barbers waiting for customers
	public static Semaphore barbers = new Semaphore(0);

	public static Semaphore mutex = new Semaphore(1);

	public static int waiting = 0;

	public static final int numSofa = 4;

	public static final int roomCapacity = 14;

	public ModifiedSleepingBarberGUI gui;

	public ModifiedBarbershop(ModifiedSleepingBarberGUI gui) {
		this.gui = gui;

	}

	class Barber extends Thread {
		private int myNumber;
		public ModifiedSleepingBarberGUI gui;

		public Barber(int i, ModifiedSleepingBarberGUI gui) {
			myNumber = i;
			this.gui = gui;
		}

		public void run() {
			while (true) {
				try {
					customers.acquire(); // Acquire lock on customers
					mutex.acquire(); // Acquire lock on waiting
					waiting = waiting - 1; // Decrement count of waiting
					barbers.release(); // Awake barber
					mutex.release(); // Unlock waiting
					cut_hair();
					get_cash();
				} catch (InterruptedException e) {
				}
			}
		}

		public void cut_hair() {

			gui.setBarberStatus(myNumber, false);
			gui.setBaberNote(myNumber, "Barber cutting hair");
			if (waiting <= numSofa) {
				gui.setSofaCount(waiting);
				gui.setQueueCount(0);

			} else {

				gui.setSofaCount(numSofa);
				gui.setQueueCount(waiting - numSofa);

			}

			try {
				sleep(2000);

			} catch (InterruptedException ex) {
			}

		}

		public void get_cash() {

			gui.payment(myNumber);
			gui.setBaberNote(myNumber, "Barber Collecting cash");

			try {
				sleep(1000);
			} catch (InterruptedException ex) {
			}
			gui.paymentDone(myNumber);
			gui.setBaberNote(myNumber, "Payment Done. Customer is Leaving!!");

			if (waiting == 0) {
				gui.setBarberStatus(myNumber, true);
				gui.setBaberNote(myNumber, "");

			}

		}

	}

	private class Customer extends Thread {
		private int myNumber;
		public ModifiedSleepingBarberGUI gui;

		public Customer(int i, ModifiedSleepingBarberGUI gui) {
			myNumber = i;
			this.gui = gui;
		}

		public void run() { // What a customer does

			try {
				if (waiting < numSofa) {
					mutex.acquire(); // Acquire lock on waiting

					waiting = waiting + 1; // Increment count of waiting

					gui.setSofaCount(waiting);
					gui.setQueueCount(0);

					customers.release();// release lock on customers

					mutex.release(); // Unlock waiting
					barbers.acquire(); // Acquire lock on barber
					get_haircut();
					give_cash();

				}
				// if no space on sofa left, customer stand in queue
				else if (waiting >= numSofa && waiting < roomCapacity) {
					mutex.acquire(); // Acquire lock on waiting

					waiting = waiting + 1; // Increment count of waiting

					gui.setSofaCount(numSofa);
					gui.setQueueCount(waiting - numSofa);

					customers.release(); // release lock on customers
					mutex.release(); // Release waiting
					barbers.acquire(); // Acquire lock on barber
					get_haircut();
					give_cash();

				}

				// if no waititng space, customer leave
				else if (waiting >= roomCapacity) {

					gui.setRoomFull("No space in the shop. CUSTOMER Leave..!!");
				}

				if (waiting <= numSofa) {
					gui.setSofaCount(waiting);
					gui.setQueueCount(0);

				} else {

					gui.setSofaCount(numSofa);
					gui.setQueueCount(waiting - numSofa);

				}

			} catch (InterruptedException e) {
			}
		}

		public void get_haircut() {
			try {
				sleep(2000);

			} catch (InterruptedException ex) {
			}
		}

		public void give_cash() {
			try {
				sleep(1000);
			} catch (InterruptedException ex) {
			}
			gui.setRoomFull("Customer #" + myNumber
					+ " done with payment. Exit shop!!!");

		}

	}

	public void run() {

		waiting = 0;

		final int BARBERS = 3;

		Barber aBarber;
		Customer aCustomer;

		for (int i = 1; i <= BARBERS; i++) {

			aBarber = new Barber(i, gui);
			aBarber.start();
		}

		int customerNumber = 1;
		while (customerNumber < 30) {

			aCustomer = new Customer(customerNumber++, gui);

			aCustomer.start();
			gui.setCustomerIn(true);
			try {
				sleep(100);
			} catch (InterruptedException ex) {

			}
			gui.setCustomerIn(false);
			try {
				sleep(100);
			} catch (InterruptedException ex) {

			}

		}

	}

}
