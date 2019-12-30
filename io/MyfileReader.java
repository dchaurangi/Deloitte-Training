package io;
import java.io.*;


public class MyfileReader {
	
	private static String fileName="C:\\Users\\admin\\Desktop\\hello.txt";

	public static void main(String[] args) {
		
		File file = new File(fileName);
		boolean fileExists = file.exists();
		System.out.println("file available ? "+fileExists);
		if(fileExists) {
		System.out.println(file.getPath());
		FileReader reader = null;
		BufferedReader buffer = null;
		//reads content
		
		try {
			 reader = new FileReader(file);
		} catch (FileNotFoundException e) {
			System.out.println("File does not exist");
			e.printStackTrace();
		}
		
		buffer = new BufferedReader(reader);
		String line = "";
		try {
			line = buffer.readLine();
			//System.out.println(line);
			while(line!=null) {
				line = buffer.readLine();
				System.out.println(line);
			}
		} catch(IOException e)
		{
			System.out.println("Error reading file : "+e);
		}
		

	}

}
}
