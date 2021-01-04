package prac.thread.concurrency;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueExam {

	public static void main(String[] args) {
		BlockingQueue<Integer> bq = new ArrayBlockingQueue<>(5);
		
		new Thread(()->{
			System.out.println(Thread.currentThread().getName()+": inside");
			int count=0;
			while(true) {
				try {
					bq.put(count);
					TimeUnit.SECONDS.sleep(1);
					System.out.println(Thread.currentThread().getName()+": data : "+count);
					count++;
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, "Producer").start();

		new Thread(()->{
			System.out.println(Thread.currentThread().getName()+": inside");
			while(true) {
				try {
					int data = bq.take();
					TimeUnit.SECONDS.sleep(2);
					System.out.println(Thread.currentThread().getName()+": data: "+data);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, "Consumer-1").start();
		
		new Thread(()->{
			System.out.println(Thread.currentThread().getName()+": inside");
			while(true) {
				try {
					int data = bq.take();
					TimeUnit.SECONDS.sleep(2);
					System.out.println(Thread.currentThread().getName()+": data : "+data);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, "Consumer-2").start();	
		System.out.println("Done!!!");	
	}
}
