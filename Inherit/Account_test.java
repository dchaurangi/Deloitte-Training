package Inherit;

public class Account_test {
	
	
	
	public static void showBalance(Account ac)
	{
		System.out.println(ac.getBalance());
	}
	
	public static void printAccount(Account ac, Printer p)
	{
		ac.print("from account");
		p.print("From printer class");
		
	}

	public static void main(String[] args) {
		
		SavingsAccount sa= new SavingsAccount("Neha",125,10000);
		/*System.out.println(sa);
		sa.withdraw(4000);
		System.out.println(sa);
		
		CurrentAccount ca= new CurrentAccount("Rahul",478,500000);
		System.out.println(ca);
		ca.withdraw(4000);
		System.out.println(ca);*/
		
		Account ac = new SavingsAccount("Amit",897,30000);
		/*System.out.println(ac);
		ac.withdraw(5000);
		System.out.println(ac);*/
		
		/*Account ac1 = new CurrentAccount("Amrita",742,250000);
		System.out.println(ac1);
		ac1.withdraw(5000);
		System.out.println(ac1);
		System.out.println("--------------------------");
		showBalance(sa);
		System.out.println("--------------------------");
		showBalance(ca);
		System.out.println("--------------------------");
		showBalance(ac);
		System.out.println("--------------------------");
		showBalance(ac1);*/
		
		ac.print("Arjun");
		sa.print("From savings");
		ac.print("Arjun");
		
		printAccount(ac, new Console_printer());
		printAccount(ac, new File_printer());

	}

}