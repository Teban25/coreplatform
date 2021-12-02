package coreplatform.threads;

public class BasicOperationsAccountRunnable implements Runnable {

	private Account account;
	private double entryAmount;

	public BasicOperationsAccountRunnable(Account account, double entryAmount) {
		super();
		this.account = account;
		this.entryAmount = entryAmount;
	}

	private void addAmount() {
		if (entryAmount > 0.0) {
			double currentAmount = account.getAmount();
			account.setAmount(entryAmount + currentAmount);
			System.out.println(String.format("In %s, new amount for account: %d is: $%,.2f",
					this.getClass().getSimpleName(), account.getId(), account.getAmount()));
		}
	}

	@Override
	public void run() {
		synchronized (account) {
			addAmount();
		}
	}
}
