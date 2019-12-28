package collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class VowelCount {
	
	public static Map<String,Integer> map = new HashMap<>(); 
	public static List<String> wordList = new ArrayList<String>();

	public static void getWord()
	{
		Scanner sc = new Scanner(System.in);
		String st = sc.nextLine();
		while(!st.equalsIgnoreCase("quit"))
			{
			buildWordList(st);
			st = sc.nextLine();
			}
		
	}
	
	public static void buildWordList(String str)
	{
		wordList.add(str);
	}
	
	public static void mapWord() {
		
		for(int i=0;i<wordList.size();i++)
			map.put(wordList.get(i), countVowel(wordList.get(i)));
	}
	
	
	public static Integer countVowel(String st) {
		
		int count =0;
		for(int i=0;i<st.length()-1;i++) {
			if(st.charAt(i)=='a'||st.charAt(i)=='o'||st.charAt(i)=='i'||st.charAt(i)=='e'||st.charAt(i)=='u') {
				count++;
			}
		}
		return count;
	}

	public static void userInput()
	{
		Scanner sc = new Scanner(System.in);
		String st = sc.nextLine();
		while(!st.equalsIgnoreCase("quit"))
			{
			printVowelCount(st);
			st= sc.nextLine();
			}
	}
	
	public static void printVowelCount(String st) {

		if(map.containsKey(st))
			System.out.println("The total no. of vowels in the word "+st+" are : "+map.get(st));
		else
			System.out.println("Word not found");
	}

	public static void main(String[] args) 
	{
		getWord();
		mapWord();
		userInput();
	}
}
