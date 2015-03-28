package gwu.group15.assignment6;

class Semaphore extends Object {
	private int count;

	public Semaphore(int startingCount) {
		count = startingCount;
	}

	public void acquire() {
		synchronized (this) {
			while (count <= 0) {
				try {
					wait();
				} catch (InterruptedException ex) {
				}
			}

			count--;
		}

	}

	public void release() {
		synchronized (this) {
			count++;
			if (count == 1) {
				notify();
			}
		}
	}
}