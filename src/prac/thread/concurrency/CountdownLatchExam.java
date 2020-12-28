package prac.thread.concurrency;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CountdownLatchExam {

	private static void countDownLatchWithTimeoutAwait() throws InterruptedException {
		ExecutorService es = Executors.newSingleThreadExecutor();
		final CountDownLatch cdLatch = new CountDownLatch(5);
		for (int i = 0; i < 3; i++) {
			es.execute(() -> {
				System.out.println("Inside Run..." + Thread.currentThread().getId());
				try {
					TimeUnit.SECONDS.sleep(3);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				cdLatch.countDown();
			});
		}

		System.out.println("All Task Submited, and latch counter is waitng for 0...");
		cdLatch.await(10, TimeUnit.SECONDS);
		System.out.println("All task finished...");

	}

	static void countDownLatchKeepWaiting() throws InterruptedException {
		ExecutorService es = Executors.newSingleThreadExecutor();
		final CountDownLatch cdLatch = new CountDownLatch(5);
		for (int i = 0; i < 3; i++) {
			es.execute(() -> {
				System.out.println("Inside Run..." + Thread.currentThread().getId());
				try {
					TimeUnit.SECONDS.sleep(3);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				cdLatch.countDown();
			});
		}

		System.out.println("All Task Submited, and latch counter is waitng for 0...");
		cdLatch.await();
		System.out.println("All task finished...");
	}

	public static void main(String[] args) throws InterruptedException {

		/*
		 * await(long timeout, TimeUnit unit), is to timeout the latch in case if
		 * Threads execution not finished in given timeunit.
		 */
		countDownLatchWithTimeoutAwait();

		/*
		 * When there is any mismatch in no. of task and threads execution or any of the
		 * thread task failed during execution which miss the cdLatch.countDown()
		 * execution. In such case latch await will keep waiting for Latch to get 0. In
		 * this situation it can wait for infinite time and application will hang in
		 * condition.
		 */
		countDownLatchKeepWaiting();
	}
}