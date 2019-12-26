package ReverseString;

public class StringReverse {

	public static void main(String[] args) {

		int i,count=0;
		String str="Deloitte";
		String str1 = str.toUpperCase();
		System.out.print("The Finsl String after reversal is : ");
		for(i=str.length()-1;i>=0;i--)
		{
			System.out.print(str.charAt(i));
			if(str1.charAt(i)=='A'||str1.charAt(i)=='E'||str1.charAt(i)=='I'||str1.charAt(i)=='O'||str1.charAt(i)=='U')
				count++;
		}
		System.out.println("\nThe total number of vowels in the string are : "+count);
		
		

	}

}
