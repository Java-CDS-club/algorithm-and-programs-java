package prac.thread.concurrency;

import java.util.concurrent.TimeUnit;

public class SynchronizedExam {
	static int j = 10;

	final static Object lock = new Object();
	final Object lock1 = new Object();

	void fourthThread() {
		System.out.println(Thread.currentThread().getName());
		synchronized (lock1) {
			while (j > 0) {
				print();
			}
		}
	}

	void thirdThread() {
		System.out.println(Thread.currentThread().getName());
		synchronized (lock1) {
			while (j > 0) {
				print();
			}
		}
	}

	static void secondThread() {
		synchronized (lock) {
			while (j > 0) {
				print();
			}
		}
	}

	static void mainThread() {
		System.out.println(Thread.currentThread().getName());
		synchronized (lock) {
			while (j > 0) {
				print();
			}
		}
	}

	static void print() {
		System.out.println(Thread.currentThread().getName() + ":j:" + j--);
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		SynchronizedExam tExam = new SynchronizedExam();
		Thread t1 = new Thread(() -> {
			mainThread();
		}, "1");

		Thread t2 = new Thread(() -> {
			secondThread();
		}, "2");

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
