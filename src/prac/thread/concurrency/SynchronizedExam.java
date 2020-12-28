package prac.thread.concurrency;

public class SynchronizedExam {
	static int j = 10;

	final static Object lock = new Object();
	final Object lock1 = new Object();

	void thirdThread() {
		System.out.println(Thread.currentThread().getName());
		synchronized (lock1) {
			while (j > 0)
				System.out.println(Thread.currentThread().getName() + ":j:" + j--);
		}
	}

	void fourthThread() {
		System.out.println(Thread.currentThread().getName());
		synchronized (lock1) {
			while (j > 0)
				System.out.println(Thread.currentThread().getName() + ":j:" + j--);
		}
	}

	static void secondThread() {
		synchronized (lock) {
			while (j > 0)
				System.out.println(Thread.currentThread().getName() + ":j:" + j--);
		}
	}

	static void mainThread() {
		System.out.println(Thread.currentThread().getName());
		synchronized (lock) {
			while (j > 0)
				System.out.println(Thread.currentThread().getName() + ":j:" + j--);
		}
	}

	public static void main(String[] args) {
		Thread t1 = new Thread(() -> {
			mainThread();
		}, "1");

		Thread t2 = new Thread(() -> {
			secondThread();
		}, "2");
		SynchronizedExam tExam = new SynchronizedExam();

		Thread t3 = new Thread(() -> {
			tExam.thirdThread();
		}, "3");

		Thread t4 = new Thread(() -> {
			tExam.fourthThread();
		}, "4");

		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}
