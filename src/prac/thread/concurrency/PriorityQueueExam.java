package prac.thread.concurrency;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

public class PriorityQueueExam {

	static void writeData(BlockingQueue<Integer> bq) {
		Random random = new Random();
		while (bq.size() != 5) {
			int num = random.ints(1, 10).findFirst().getAsInt();
			try {
				bq.put(num);
				System.out.println("Thread-" + Thread.currentThread().getName() + " :addNum: " + num);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	static void readData(BlockingQueue<Integer> bq) {
		try {
			TimeUnit.SECONDS.sleep(5);
			while (!bq.isEmpty()) {
				System.out.println("Thread-" + Thread.currentThread().getName() + " :takeNum: " + bq.take());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		BlockingQueue<Integer> bq = new PriorityBlockingQueue<>();
		new Thread(() -> {
			writeData(bq);
		}, "1").start();

		new Thread(() -> {
			readData(bq);
		}, "2").start();
	}
}