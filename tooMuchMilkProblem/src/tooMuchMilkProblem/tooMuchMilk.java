package tooMuchMilkProblem;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;

public class tooMuchMilk extends Thread {

	private final Lock rlock = new ReentrantLock();

	public static boolean noMilk = true;
	public tooMuchMilkGUI gui;

	tooMuchMilk(tooMuchMilkGUI gui) {
		this.gui = gui;

	}

	class Roommate1 extends Thread {

		Roommate1(String RoomateName) {
			super(RoomateName);
		}

		public void run() {

			while (true) {
				rlock.lock();

				try {

					if (noMilk) {

						noMilk = false;

						gui.setMilk(false);
						gui.setNoMilk(true);
						gui.setRoomate1Note("Going to bring Milk");
						gui.setRoomate2Note("Stays at Home");

						try {
							sleep(2000);
						} catch (InterruptedException ex) {
						}

						gui.setMilk(true);
						gui.setNoMilk(false);
						gui.setRoomate1Note("");
						gui.setRoomate2Note("");

						try {
							sleep(2000);
						} catch (InterruptedException ex) {
						}

					}

				} finally {
					rlock.unlock();
				}

				noMilk = true;
				gui.setMilk(false);
				gui.setNoMilk(true);
				gui.setRoomate1Note("");
				gui.setRoomate2Note("");

			}

		}
	}

	class Roommate2 extends Thread {

		Roommate2(String RoomateName) {
			super(RoomateName);
		}

		public void run() {

			while (true) {
				rlock.lock();

				try {
					if (noMilk) {

						noMilk = false;
						gui.setMilk(false);
						gui.setNoMilk(true);
						gui.setRoomate1Note("Stays at Home");
						gui.setRoomate2Note("Goes to bring Milk");

						try {
							sleep(2000);
						} catch (InterruptedException ex) {
						}

						gui.setMilk(true);
						gui.setNoMilk(false);
						gui.setRoomate1Note("");
						gui.setRoomate2Note("");

						try {
							sleep(2000);
						} catch (InterruptedException ex) {
						}

					}

				} finally {
					rlock.unlock();
				}
				noMilk = true;
				gui.setMilk(false);
				gui.setNoMilk(true);
				gui.setRoomate1Note("");
				gui.setRoomate2Note("");

			}

		}

	}

	public void run() {

		Roommate1 R1 = new Roommate1("A");
		Roommate2 R2 = new Roommate2("B");
		R1.start();
		R2.start();

	}

}