package Inherit;

public abstract class Account implements Printer{
	
	protected String name;
	protected int number;
	protected double balance;

	public Account(String name, int number, double balance)
	{
		super();
		this.name= name;
		this.number= number;
		this.balance= balance;
		System.out.println("Account Constructor called");		
	}
	
	public void print(String s)
	{
		System.out.println("Printing account info...."+s);
	}
	
	public abstract void withdraw(double amount);
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getNumber() {
		return number;
	}


	public void setNumber(int number) {
		this.number = number;
	}


	public double getBalance() {
		return balance;
	}


	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account [name=" + name + ", number=" + number + ", balance=" + balance + "]";
	}
	
	


	

	

}
