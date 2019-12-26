package Account;

public class ATM {
	
	private double totalAmount;
	private double withdrawLimit;
	private Account acct;

	public ATM()
	{
		totalAmount=1500000;
		withdrawLimit=4000;
		
	}
	
	public boolean validatePin(int pin)
	{
		return acct.getAccPin()==pin;
	}
	
	public double withdraw(double amt,int pin)
	{
		if(validatePin(pin))
		{
			if(amt<=withdrawLimit)
			{
				if(amt<acct.getAccBalance()-Account.minBalance)
				{
				totalAmount -= amt;
				acct.setAccBalance(acct.getAccBalance()-amt);
				return amt;
				}
		}
		}
		return 0.0;
		
	}
	
	public double deposit(double amt,int pin)
	{
		if(validatePin(pin))
		{
			totalAmount+=amt;
			acct.setAccBalance(acct.getAccBalance()+amt);
		}
		return amt;
	}
	
	

	public Account getAcct() {
		return acct;
	}

	public void setAcct(Account acct) {
		this.acct = acct;
	}

	@Override
	public String toString() {
		return "totalAmount=" + totalAmount;
	}

	public static void main(String[] args) {
		
		ATM atm = new ATM();
		Account act=new Account("Nun",145,21000);
		atm.setAcct(act);
		atm.withdraw(4000,145);
		atm.deposit(1500,145);
		System.out.println(atm);
		System.out.println(atm.getAcct());
		
		
	}

}
