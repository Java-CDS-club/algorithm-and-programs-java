package prac.thread.concurrency.forkJoin;

import java.util.concurrent.ForkJoinPool;

public class SimpleRecursiveActionClient {

	public static void main(String[] args) {
		ForkJoinPool fjp = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
		System.out.println("Processors: "+Runtime.getRuntime().availableProcessors());
		SimpleRecursiveAction sra = new SimpleRecursiveAction(100);
		fjp.invoke(sra);
	}
}
