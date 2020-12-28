package prac.thread.concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CyclicBarrierExam {

	public static void main(String[] args) {
		final CyclicBarrier cb = new CyclicBarrier(3, () -> {
			System.out.println("CyclicBarrier Runnable...");
		});

		ExecutorService es = Executors.newSingleThreadExecutor();

		for (int i = 0; i < 3; i++) {
			es.execute(() -> {
				System.out.println("Inside Run: " + Thread.currentThread().getId());
				try {
					TimeUnit.SECONDS.sleep(3);
					cb.await();

					/*
					 * Below method is as similar of CountDownLatch, in case of await hanged for
					 * more then given time it will break the await with TimeOutException.
					 */
					// cb.await(5, TimeUnit.SECONDS);
				} catch (InterruptedException | BrokenBarrierException e) {
					e.printStackTrace();
				}
				System.out.println("Outside Run: " + Thread.currentThread().getId());
			});
		}
		System.out.println("All Task Submitted...");
	}
}