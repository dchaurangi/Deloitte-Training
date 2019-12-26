package core;
import java.util.Scanner;
public class random {
	public static int target=(int)(Math.random()*100)+1;
	private static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		
		for(int i=1;i<=5;i++)
		guessNumber();
		System.out.println(target);
		
		

	}
	private static int getInput()
	{
		
			return sc.nextInt();
		
	}

	
	private static void guessNumber()
	{
		int n=getInput();
		if(n==target)
			System.out.println("You are lucky");
		else
			System.out.println("Better luck next time");
	}

}
