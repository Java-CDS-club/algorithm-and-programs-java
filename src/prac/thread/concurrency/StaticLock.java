package prac.thread.concurrency;

import java.util.concurrent.TimeUnit;

public class StaticLock {
	static int count = 0;
	static Object lock = new Object();

	static synchronized void thread1() {
		while (true) {
			print();
		}
	}

	synchronized void thread2() {
		while (true) {
			print();
		}
	}

	static void print() {
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "::" + count++);
	}

	public static void main(String[] args) {
		Thread t1 = new Thread(() -> {
			thread1();
		}, "T1");

		StaticLock sl = new StaticLock();

		Thread t2 = new Thread(() -> {
			sl.thread2();
		}, "T2");

		t1.start();
		t2.start();
	}
}