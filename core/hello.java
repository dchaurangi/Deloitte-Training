package core;

public class hello 
{

	public static void main(String args[])
	{
	
	double a=15.0,b=0.0;
	String opt="/";
	calculate(a,b,opt);
		
	}
	
	public static void calculate(double a,double b,String op)
	{
		switch(op)
		{
		case "+":
			System.out.println("The sum is = "+(a+b));
			break;
		case "-":
			System.out.println("The difference is = "+(a-b));
			break;
		case "*":
			System.out.println("The multiplication is = "+(a*b));
			break;
		case "/":
			if(b==0)
				System.out.println("Not possible");
			else
				System.out.println("The quotient is = "+(a/b));
			break;
		default:
			System.out.println("Wrong choice");
		}
	}
	
}