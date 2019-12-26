package core;

public class Array {

	public static void main(String[] args) {
		
		String[] str= {"anand","vishal","gautam","ravi","rahul"};
		int i;
		for(i=0;i<str.length;i++)
		{
			System.out.println(str[i]);
		}
		arraymod(str);

	}
	
	/*public static void stringlength(String[] strs)
	{
		int i;
		for(i=0;i<strs.length;i++)
		{
			System.out.println(strs[i]+" "+strs[i].length());
		}
	}*/
	
	public static void arraymod(String[] strs)
	{
		strs[0]="niki";
		strs[1]="geetha";
		int i;
		for(i=0;i<strs.length;i++)
		{
			System.out.println(strs[i]);
		}
	}

}
