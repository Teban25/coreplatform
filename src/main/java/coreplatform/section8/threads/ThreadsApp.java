package coreplatform.section8.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadsApp {

	public static void main(String[] args) {
		double addAmount = 100.0;
		/*
		 * Basic example using extends Thread class
		 */
		System.out.println("Updating account");
		Account account = new Account(1, 100);
		Thread operation = new Thread(new BasicOperationsAccountThread(account, addAmount));
		
		operation.start();
		
		
		/*
		 * Basic example using implements Runnable interface
		 */
		addAmount = account.getAmount() + 250;
		operation = new Thread(new BasicOperationsAccountRunnable(account, addAmount));
		operation.start();
		
		/*
		 * Basic example using Executor interface
		 */
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		for (int i = 0; i < 5; i++) {
			addAmount = addAmount + 10.0;
			
			BasicOperationsAccountRunnable operationWithExecutor = new BasicOperationsAccountRunnable(account, addAmount);
			executorService.submit(operationWithExecutor);
		}
		
		try{
			executorService.shutdown();
			executorService.awaitTermination(60, TimeUnit.SECONDS);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getStackTrace());
		}
	}
}
