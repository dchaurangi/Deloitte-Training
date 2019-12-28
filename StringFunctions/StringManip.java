package StringFunctions;

public class StringManip {

	public static void main(String[] args) {


		String str= new String();
		str = "this is a String";
		String st = new String("this is not a string");
		System.out.println(str==st);
		System.out.println(str.equals(st));
		str=st;
		System.out.println(str==st);
		System.out.println(str.equals(st));
		
		int len = str.length();
		
		int index = str.indexOf('t');
		System.out.println(index);
		
		int lastindex=str.lastIndexOf('t');
		System.out.println(lastindex);
		
		int c=0;
		for(int i=0;i<str.length();i++)
		{
			if(str.charAt(i)=='t')
				c++;
		}
		System.out.println(c);
		locate("text","this is a text");
		
		StringBuffer buffer = new StringBuffer();
		buffer.append("<html");
		buffer.append("<head><title>My web page</title></head>");
		buffer.append("<body>");
		buffer.append("</body></html>");
		
		System.out.println(buffer.toString());
		System.out.println(pallindrome("malayalam"));
		charCount("welcome");
	

	}
	
	public static void locate(String word, String line)
	{
		if(line.contains(word))
		{
		int firstIndex = line.indexOf(word);
		System.out.println("First Index");
	    System.out.println(firstIndex); 
	    
	    int lastIndex = firstIndex + word.length() ;
	    System.out.println("Last Index");
	    System.out.println(lastIndex);
	    System.out.println(line.substring(firstIndex, lastIndex));
		}
		else
			System.out.println("Word not present");
	}
	
	public static boolean pallindrome(String word)
	{
		StringBuffer buffer = new StringBuffer(word);
		buffer.reverse();
		String str = buffer.toString();
		if(word.equalsIgnoreCase(str))
			return true;
		else
			return false;
		
	}
	
	public static void charCount(String text)
	{
		String str="";
		for(char c :text.toCharArray()) {
			if(!str.contains(c+"")&&c!=' ')
				str+=c;
		}
		System.out.println(str.length());
		
	}
	

	}
		
	


