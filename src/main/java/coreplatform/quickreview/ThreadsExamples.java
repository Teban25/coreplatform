package coreplatform.quickreview;


public class ThreadsExamples {

	public static void main(String[] args) {
		Thread thread1 = new Example1("Example1.1");
		Thread thread2 = new Thread(new Example2(20), "Example2.2");
		Thread thread3 = new Thread(new Example2(30), "Example2.3");
		Thread thread4 = new Thread(new Example2(45), "Example2.4");
		
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
	}
	
	private static class Example1 extends Thread {

		public Example1(String name) {
			super(name);
		}
		
		@Override
		public void run() {
			System.out.println("I'm Example1.... Starting.");
			
			System.out.println("I'm Example1.... Finishing.");
		}
		
	}
	
	private static class Example2 implements Runnable {
		
		private ThreadLocal<Integer> balance = ThreadLocal.<Integer>withInitial((() -> { return new Integer(0); }));
		private final Integer addition;
		
		public Example2(int addition) {
			this.addition = addition;
		}

		@Override
		public void run() {
			balance.set(new Integer(balance.get() + addition));
			System.out.println("I'm Example2.... Starting.");
			for (int i = 0; i < 2; i++) {
				balance.set(new Integer(balance.get() + 10));
			}
			System.out.println("For: " + Thread.currentThread().getName() + ", the balance is: " + balance.get());
			System.out.println("I'm Example2.... Finishing.");
		}
	}
}
