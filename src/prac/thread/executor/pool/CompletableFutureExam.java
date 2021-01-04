package prac.thread.executor.pool;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureExam {
	static int i = 10;

	public static void main(String[] args) {

		CompletableFuture.supplyAsync(() -> calculatePlus(i)).thenApply(num -> calculateMul(num))
				.thenApply(num -> calculateDivision(num)).thenAccept(num -> printNum(num));
	}

	private static int calculateDivision(int num) {
		printNum(num);
		return num / 10;
	}

	private static int calculatePlus(int num) {
		printNum(num);
		return num + 10;
	}

	private static int calculateMul(int num) {
		printNum(num);
		return num * 10;
	}

	private static void printNum(int num) {
		System.out.println("Thread: " + Thread.currentThread().getName() + ", :num: " + num);
	}
}