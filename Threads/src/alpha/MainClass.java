package alpha;

public class MainClass {

	private int i;

	synchronized public void sharedMethod() {
		Thread t = Thread.currentThread();
		// System.out.println();
		System.out.println("Called by " + t.getName());
		this.i = 100;
		System.out.println(i);
		this.i = 200;
		System.out.println(i);
		this.i = 300;
		System.out.println(i);
	}

	public static void main(String[] args) {

		final MainClass m = new MainClass();

		Thread t1 = new Thread("Thread 1") {

			@Override
			public void run() {

				m.sharedMethod();
			}

		};

		Thread t2 = new Thread("Thread 2") {

			@Override
			public void run() {

				m.sharedMethod();
			}

		};

		t1.start();
		t2.start();
	}
}
