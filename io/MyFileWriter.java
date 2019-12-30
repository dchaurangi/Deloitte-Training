package io;

import java.io.*;

public class MyFileWriter {
	
	private static String fileName = "C:\\Users\\admin\\Desktop\\Password.txt";

	public static void main(String[] args) {

		FileWriter fw = null;
		try {
			fw = new FileWriter(fileName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrintWriter out = null;
		out = new PrintWriter(fw);
		out.println("admin:5654652");
		out.println("admin:5654652");
		out.println("admin:5654652");
		out.println("admin:5654652");
		out.println("admin:5654652");
		out.println("admin:5654652");
		out.flush();
		
		if(fw!=null)
		{
			try {
				fw.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}

	}

}
