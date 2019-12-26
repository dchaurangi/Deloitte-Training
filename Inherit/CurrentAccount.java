package Inherit;

public class CurrentAccount extends Account {

	public CurrentAccount(String name, int number, double balance) {
		super(name, number, balance);
		System.out.println("CurrentAccount Constructor called");	
		
	}
	
	@Override //we are reimplementing this withdraw func over the withdraw func in the account class
	public void withdraw(double amount)
	{
		//super.withdraw(amount);
		if(amount < balance)
			balance-=amount;
	}

	
}
