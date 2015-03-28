package test1;

class Smokers {
	private boolean paper;
	private boolean tobacco;
	private boolean match;

	public Smokers() {
		paper = true;
		tobacco = true;
		match = true;
	}

	public synchronized void getPaper() throws InterruptedException {
		while (!paper) {
			System.out.println("smoker of kind 2 are waiting for paper");
			Test1 t = new Test1();
			Smoker2Dialog d = new Smoker2Dialog();
			d.showDialog(t, "waiting for paper", 8);
			Thread.sleep(500);
			wait();
		}
		System.out.println("smoker of kind 2 got paper");
		Test1 t = new Test1();
		Smoker2Dialog d = new Smoker2Dialog();
		d.showDialog(t, "got paper", 8);
		Thread.sleep(500);
		paper = false;
		notifyAll();
	}

	public synchronized void getTobacco() throws InterruptedException {
		while (!tobacco) {
			System.out.println("smoker of kind 3 waiting for tobacco");
			Test1 t = new Test1();
			Smoker3Dialog d = new Smoker3Dialog();
			d.showDialog(t, "waiting for tobacco", 8);
			Thread.sleep(500);
			wait();
		}
		System.out.println("smoker of kind 3 got tobacco");
		Test1 t = new Test1();
		Smoker3Dialog d = new Smoker3Dialog();
		d.showDialog(t, "got tobacco", 8);
		Thread.sleep(500);
		tobacco = false;
		notifyAll();
	}

	public synchronized void releasePaper() throws InterruptedException {
		while (paper) {
			wait();
		}
		System.out.println("smoker of kind 2 release paper");
		Test1 t = new Test1();
		Smoker2Dialog d = new Smoker2Dialog();
		d.showDialog(t, "release paper", 8);
		Thread.sleep(500);

		paper = true;
		notifyAll();
	}

	public synchronized void releaseTobacco() throws InterruptedException {
		while (tobacco) {
			wait();
		}
		System.out.println("smoker of kind 3 release tobacco");
		Test1 t = new Test1();
		Smoker3Dialog d = new Smoker3Dialog();
		d.showDialog(t, "release tobacco", 8);
		Thread.sleep(500);
		tobacco = true;
		notifyAll();
	}

	public synchronized void getMatch() throws InterruptedException {
		while (!match) {
			System.out.println("smoker of kind 1 are waiting for match");
			Test1 t = new Test1();
			Smoker1Dialog d = new Smoker1Dialog();
			d.showDialog(t, "waiting for match", 8);
			Thread.sleep(500);
			wait();
		}
		System.out.println("smoker of kind 1 got match");
		Test1 t = new Test1();
		Smoker1Dialog d = new Smoker1Dialog();
		d.showDialog(t, "got match", 8);
		Thread.sleep(500);
		match = false;
		notifyAll();
	}

	public synchronized void releaseMatch() throws InterruptedException {
		while (match) {
			wait();
		}
		System.out.println("smoker of kind 1 release match");
		Test1 t = new Test1();
		Smoker1Dialog d = new Smoker1Dialog();
		d.showDialog(t, "release match", 8);
		Thread.sleep(500);
		match = true;
		notifyAll();
	}

	class SmokersWithoutPaperGet extends Thread {
		public void run() {
			try {
				getPaper();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	class SmokersWithoutPaperRelease extends Thread {
		public void run() {
			try {
				releasePaper();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void startThreadOneGet() {
		SmokersWithoutPaperGet pg = new SmokersWithoutPaperGet();
		pg.start();
	}

	public void startThreadOneRelease() {
		SmokersWithoutPaperRelease pr = new SmokersWithoutPaperRelease();
		pr.start();
	}

	class SmokersWithoutTobaccoGet extends Thread {
		public void run() {
			try {
				getTobacco();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	class SmokersWithoutTobaccoRelease extends Thread {
		public void run() {
			try {
				releaseTobacco();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void startThreadTwoGet() {
		SmokersWithoutTobaccoGet tg = new SmokersWithoutTobaccoGet(); 
		tg.start();
		
	}

	public void startThreadTwoRelease() {

		SmokersWithoutTobaccoRelease tr = new SmokersWithoutTobaccoRelease();
		tr.start();
	}

	class SmokersWithoutMatchGet extends Thread {
		public void run() {
			try {
				getMatch();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	class SmokersWithoutMatchRelease extends Thread {
		public void run() {
			try {
				releaseMatch();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void startThreadThreeGet() {
		SmokersWithoutMatchGet mg = new SmokersWithoutMatchGet();
		mg.start();
	}

	public void startThreadThreeRelease() {
		SmokersWithoutMatchRelease mr = new SmokersWithoutMatchRelease();
		mr.start();
	}
}
