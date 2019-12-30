package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class MyFileCopier {
	
	private static String fileName="C:\\Users\\admin\\Desktop\\Password.txt";

	private static String fileName1 = "C:\\Users\\admin\\Desktop\\Password1.txt";
	public static void main(String[] args) {
		
		File file = new File(fileName);
		boolean fileExists = file.exists();
		//System.out.println("file available ? "+fileExists);
		if(fileExists) {
		System.out.println("File copied");
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
		FileWriter fw = null;
		try {
			fw = new FileWriter(fileName1);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			line = buffer.readLine();
			PrintWriter out = null;
			out = new PrintWriter(fw);
			out.println(line);
			out.flush();
			System.out.println(line);
			while(line!=null) {
				line = buffer.readLine();
				PrintWriter out1 = null;
				out1 = new PrintWriter(fw);
				out1.println(line);
				out1.flush();
				//System.out.println(line);
			}
		} catch(IOException e)
		{
			System.out.println("Error reading file : "+e);
		}
		

	}

}
}



