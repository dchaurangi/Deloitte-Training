package Account;


public class Account {
	
	String accHolder;
	int accPin;
	double accBalance;
	static final double minBalance=1000;
	
	public Account(String accHolder, int accPin, double accBalance)
	{
		super();
		this.accHolder=accHolder;
		this.accPin=accPin;
		this.accBalance=accBalance;
	}
	
	

	public String getAccHolder() {
		return accHolder;
	}



	public void setAccHolder(String accHolder) {
		this.accHolder = accHolder;
	}



	public int getAccPin() {
		return accPin;
	}



	public void setAccPin(int accPin) {
		this.accPin = accPin;
	}



	public double getAccBalance() {
		return accBalance;
	}



	public void setAccBalance(double accBalance) {
		this.accBalance = accBalance;
	}
	

	@Override
	public String toString() {
		return "Account [accHolder=" + accHolder + ", accPin=" + accPin + ", accBalance=" + accBalance + "]";
	}



	

}
