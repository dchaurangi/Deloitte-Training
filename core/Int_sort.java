package core;

import java.util.Arrays;

public class Int_sort {

	public static void main(String[] args) {
		
		
		int [] num= {23,13,56,45,21,76,83,90,67,45};
		intsort(num);

	}

	public static void intsort(int [] nums)
	{
		Arrays.sort(nums);
		for(int i=0;i<nums.length;i++)
			System.out.println(nums[i]);
	}
}
