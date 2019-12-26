package Inherit;

public class SavingsAccount extends Account {
	
	private static final double MINIMUM=1000;
	
	public SavingsAccount(String name, int number, double balance)
	{
		super(name,number,balance);
		System.out.println("Savings Account Constructor called");	
	}

	
	@Override
	
	public void print(String s)
	{
		super.print(s);
	}
	@Override //we are reimplementing this withdraw func over the withdraw func in the account class
	public void withdraw(double amount)
	{
		if(balance - amount>= MINIMUM)
			balance-=amount;
	}
	
	
}
