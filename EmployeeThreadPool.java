package tiaa;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javafx.concurrent.Worker;

public class EmployeeThreadPool {
	private static final int NTHREDS = 3;

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(NTHREDS);
		for (int i = 0; i < 10; i++) {
			Runnable worker = new RunnableThread(i, true);
			executor.execute(worker);

		}

		if (!RunnableThread.isMoreProductsFlag()) {
			executor.shutdown();
		}
		while (!executor.isTerminated()) {
		}
		System.out.println("Finished all threads");
	}
}
