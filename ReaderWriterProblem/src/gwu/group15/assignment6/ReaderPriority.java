package gwu.group15.assignment6;

class ReaderPriority {
	int NumOfReader;
	int NumOfWriter;
	public RPriorityGUI gui;

	public ReaderPriority(RPriorityGUI gui) {
		this.gui = gui;
		this.NumOfReader = 0;
		this.NumOfWriter = 0;
	}

	public synchronized void requestRead() throws InterruptedException {
		while (this.NumOfWriter > 0) {
	
			gui.setWWriting(this.NumOfWriter);
			gui.setWWaiting("Writing Now");
			gui.setWtag(true);
			gui.setRtag(false);
			Thread.sleep(1000);
			wait();
		}

		this.NumOfReader++;
		gui.setRReading(this.NumOfReader);
		gui.setWWaiting("Reading Now");
		gui.setWtag(false);
		gui.setRtag(true);
	Thread.sleep(1000);
		
	}

	public synchronized void releaseRead() {
		while (NumOfReader > 0) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.NumOfReader--;
			gui.setRReading(this.NumOfReader);
			gui.setWWaiting("Reading");
			gui.setWtag(false);
			gui.setRtag(true);
		

		}
		gui.setRWaiting("Reading Complete");
		gui.setWtag(false);
		gui.setRtag(false);
	
		notifyAll();
	}

	public synchronized void requestWrite() throws InterruptedException {
		while (this.NumOfReader > 0 || this.NumOfWriter > 0) {
			gui.setRReading(this.NumOfReader);
			gui.setWWriting(this.NumOfWriter);

			gui.setWWaiting("Reading");
			gui.setWWaiting("Waiting");
			gui.setWtag(false);
			gui.setRtag(true);
		

			Thread.sleep(1000);
			wait();
		}
		
		gui.setRWaiting("Writer Writing : All reader Waiting");
		this.NumOfWriter++;
		gui.setWWriting(this.NumOfWriter);
		gui.setWtag(true);
		gui.setRtag(false);
	
		Thread.sleep(1000);
	}

	public synchronized void releaseWrite() {
		while (NumOfWriter > 0) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.NumOfWriter--;
			gui.setWWriting(this.NumOfWriter);
			gui.setWWaiting("Writing");
			gui.setWtag(true);
			gui.setRtag(false);
		
		}
		
		gui.setWWaiting("Writing Done");
		gui.setWtag(false);
		gui.setRtag(false);
	
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
