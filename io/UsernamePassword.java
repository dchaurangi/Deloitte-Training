package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class UsernamePassword {

	private static String fileName="C:\\Users\\admin\\Desktop\\Password.txt";

	public static void main(String[] args) {
		
		File file = new File(fileName);
		boolean fileExists = file.exists();
		//System.out.println("file available ? "+fileExists);
		if(fileExists) {
		//System.out.println(file.getPath());
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
			String []Username = line.split(":");
			for (String a : Username) 
	            System.out.println(a);
			while(line!=null) {
				line = buffer.readLine();
				String []Username1 = line.split(":");
				for (String a : Username1) 
		            System.out.println(a);
				//System.out.println(line);
			}
		} catch(IOException e)
		{
			System.out.println("Error reading file : "+e);
		}
		

	}

}
}
