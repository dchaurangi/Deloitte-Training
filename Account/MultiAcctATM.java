package Account;

public class MultiAcctATM {
	
	private double withdrawLimit;
	private double totalAmount;
	private Account[] accts;
	int counters=0;
	int limit=3;
	Account currentAccountHolder;
	

	public MultiAcctATM(double totalAmount, double withdrawLimit) {
		
		this.withdrawLimit = withdrawLimit;
		accts= new Account[limit];
	}
	
	
	public void addAccount(Account acct)
	{
		if(counters<limit)
		{
			accts[counters++]=acct;
		}
	}
	
	public boolean validate(int pin)
	{
		for (Account act: accts) {
			if(act.getAccPin()==pin)
			{
				
				return true;
			}
	}
	return false;

	}
	
	public boolean validatePin(int pin)
	{
		return currentAccountHolder.getAccPin()==pin;
	}
	
	public double deposit(double amt,int pin)
	{
		if(validatePin(pin))
		{
			currentAccountHolder.setAccBalance(currentAccountHolder.getAccBalance()+amt);
		}
		return amt;
	}
	
	
	public double withdraw(double amt,int pin)
	{
		if(validatePin(pin))
		{
			if(amt<=withdrawLimit)
			{
				if(amt<currentAccountHolder.getAccBalance()-Account.minBalance)
				{
				currentAccountHolder.setAccBalance(currentAccountHolder.getAccBalance()-amt);
				return amt;
				}
		}
		}
		return 0.0;
		
	}

	public static void main(String[] args) {
		
		MultiAcctATM atm = new MultiAcctATM(50000,4000);
		Account a1 = new Account("neha",1458,15000);
		Account a2 = new Account("asha",8958,15900);
		
		
		atm.addAccount(a1);
		atm.addAccount(a2);
		
		atm.withdraw(3500.00,8958);
		System.out.println(a1);
		

	}

}
