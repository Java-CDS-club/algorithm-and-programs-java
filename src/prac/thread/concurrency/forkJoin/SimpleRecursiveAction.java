package prac.thread.concurrency.forkJoin;

import java.util.concurrent.RecursiveAction;

public class SimpleRecursiveAction extends RecursiveAction {

	private static final long serialVersionUID = 1L;

	private int input;

	public SimpleRecursiveAction(int input) {
		this.input = input;
	}

	@Override
	protected void compute() {
		if (input > 50) {
			System.out.println("Task is in " + "devide...:" + input);
			SimpleRecursiveAction sra1 = new SimpleRecursiveAction(input / 2);
			SimpleRecursiveAction sra2 = new SimpleRecursiveAction(input / 2);

			sra1.fork();
			sra2.fork();
		} else {
			System.out.println("Task is not big enough to further devide...:" + input);
		}
	}
}
