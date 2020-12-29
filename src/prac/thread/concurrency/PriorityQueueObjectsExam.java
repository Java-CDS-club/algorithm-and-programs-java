package prac.thread.concurrency;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

class User implements Comparable<User> {
	int id;
	String name;

	User(int id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public int compareTo(User o) {
		return this.name.compareTo(o.name);
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + "]";
	}
}

public class PriorityQueueObjectsExam {

	static void writeThread(BlockingQueue<User> bq) {
		bq.add(new User(1, "Sam"));
		bq.add(new User(200, "Piter"));
		bq.add(new User(10, "Arno"));
		bq.add(new User(5, "Wishly"));
		
	}

	static void readThread(BlockingQueue<User> bq) {
		try {
			TimeUnit.SECONDS.sleep(5);
			while (!bq.isEmpty()) {
				System.out.println("Thread-" + Thread.currentThread().getName() + " :takeNum: " + bq.take().toString());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		BlockingQueue<User> bq = new PriorityBlockingQueue<>();
		new Thread(() -> {
			writeThread(bq);
		}, "1").start();

		new Thread(() -> {
			readThread(bq);
		}, "2").start();
	}
}
