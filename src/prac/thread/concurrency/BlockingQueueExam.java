package prac.thread.concurrency;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueExam {

	public static void main(String[] args) {
		BlockingQueue<Integer> bq = new ArrayBlockingQueue<>(5);
		
		new Thread(()->{
			System.out.println("inside Producer...");
			int count=0;
			while(true) {
				try {
					bq.put(count);
					TimeUnit.SECONDS.sleep(1);
					System.out.println("data added in q: "+count);
					count++;
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();

		new Thread(()->{
			System.out.println("inside Consumer...");
			while(true) {
				try {
					int data = bq.take();
					TimeUnit.SECONDS.sleep(4);
					System.out.println("data taken from q: "+data);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
		System.out.println("Done!!!");	
	}
}
