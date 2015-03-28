package gwu.group15.assignment6;

class WriterPriority {
	int NumOfReader;
	int NumOfWriter;
	int NumOfRequestedWriter;
	WPriorityGUI gui;

	public WriterPriority(WPriorityGUI gui) {
		this.NumOfReader = 0;
		this.NumOfWriter = 0;
		this.NumOfRequestedWriter = 0;
		this.gui = gui;
	}

	public synchronized void requestRead() throws InterruptedException {
		while (this.NumOfWriter > 0 || this.NumOfRequestedWriter > 0) {

			gui.setRReading(this.NumOfReader);
			gui.setWWriting(this.NumOfWriter);
			gui.setWWaiting(this.NumOfRequestedWriter
					+ " writer waiting to write");
			gui.setRWaiting("Wait for writer to complete");
			gui.setRtag(false);
			gui.setWtag(true);

			Thread.sleep(1000);
			wait();
		}

		gui.setRReading(this.NumOfReader);
		gui.setWWriting(this.NumOfWriter);
		gui.setWWaiting("Writers are Done");
		gui.setRWaiting("Reading Now");
		gui.setRtag(true);
		gui.setWtag(false);

		Thread.sleep(1000);
		this.NumOfReader++;
	}

	public synchronized void releaseRead() {
		while (NumOfReader > 0) {
		
			gui.setRReading(this.NumOfReader);
			gui.setWWriting(this.NumOfWriter);
			gui.setWWaiting("Writer Waiting for reading to complete");
			gui.setRWaiting("Reader reading");
			gui.setRtag(true);
			gui.setWtag(false);

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			this.NumOfReader--;
		}

		gui.setRReading(this.NumOfReader);
		gui.setWWriting(this.NumOfWriter);
		gui.setWWaiting("Writing Now");
		gui.setRWaiting("Readers are Done");
		gui.setRtag(false);
		gui.setWtag(false);

		notifyAll();
	}

	public synchronized void requestWrite() throws InterruptedException {
		this.NumOfRequestedWriter++;
		while (this.NumOfReader > 0 || this.NumOfWriter > 0) {
		
			gui.setRReading(this.NumOfReader);
			gui.setWWriting(this.NumOfWriter);
			gui.setWWaiting("Reader reading");
			gui.setRWaiting("Writer waiting for reader to complete");
			gui.setRtag(true);
			gui.setWtag(false);
			Thread.sleep(1000);
			wait();
		}

		this.NumOfRequestedWriter--;

		gui.setRReading(this.NumOfReader);
		gui.setWWriting(this.NumOfWriter);
		gui.setWWaiting(this.NumOfRequestedWriter + " writer waiting to write");
		gui.setRWaiting("Wait for writer to complete");
		gui.setRtag(false);
		gui.setWtag(true);
		Thread.sleep(1000);

		this.NumOfWriter++;
	}

	public synchronized void releaseWrite() {
		while (NumOfWriter > 0) {
			
			gui.setRReading(this.NumOfReader);
			gui.setWWriting(this.NumOfWriter);
			gui.setWWaiting("Writer writing");
			gui.setRWaiting("Reader waiting for writer to complete");
			gui.setRtag(false);
			gui.setWtag(true);
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.NumOfWriter--;
		}
		
		gui.setRReading(this.NumOfReader);
		gui.setWWriting(this.NumOfWriter);
		gui.setWWaiting("Writer are done");
		gui.setRWaiting("Reader can read now");
		gui.setRtag(false);
		gui.setWtag(false);
		
		notifyAll();
	}

	class ThreadRequestRead extends Thread {
		public void run() {
			try {

				requestRead();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	class ThreadReleaseRead extends Thread {
		public void run() {
			releaseRead();
		}
	}

	class ThreadRequestWrite extends Thread {
		public void run() {

			try {
				requestWrite();

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	class ThreadReleaseWrite extends Thread {
		public void run() {
			releaseWrite();
		}
	}

	public void startRequestRead() {
		ThreadRequestRead a = new ThreadRequestRead();
		a.start();
	}

	public void startReleaseRead() {
		ThreadReleaseRead a = new ThreadReleaseRead();
		a.start();
	}

	public void startRequestWrite() {
		ThreadRequestWrite a = new ThreadRequestWrite();
		a.start();
	}

	public void startReleaseWrite() {
		ThreadReleaseWrite a = new ThreadReleaseWrite();
		a.start();
	}
}
