import java.util.concurrent.*;

public class BirdFeeder extends Thread {

	public static Semaphore spaceFree = new Semaphore(3, true);

	public BirdFeederGUI gui;

	BirdFeeder(String ThreadName, BirdFeederGUI gui) {
		super(ThreadName);
		this.gui = gui;

	}

	public void birdWantToEnter(int button) {
		try {

			spaceFree.acquire();
			openDoorForEnter(button);

		} catch (InterruptedException ex) {
		}

	}

	public void birdWantToLeave(int button) {
		try {

			openDoorForExit(button);
			spaceFree.release();
		} catch (Exception ex) {
		}

	}

	public void openDoorForEnter(int button) {

		gui.enterBird(Thread.currentThread().getName());
		gui.openDoor(button);

	}

	public void openDoorForExit(int button) {

		gui.leaveBird(Thread.currentThread().getName());
		gui.openDoor(button);

	}

	public void run() {

		while (true) {

			int doorNumber = 1 + (int) (Math.random() * ((3 - 1) + 1));
			birdWantToEnter(doorNumber);
			try {

				sleep(1000 * doorNumber);
			} catch (InterruptedException ex) {
			}

			birdWantToLeave(doorNumber);

			try {

				sleep(1000 * doorNumber);
			} catch (InterruptedException ex) {
			}

		}

	}

}