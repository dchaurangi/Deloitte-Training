package io;

import java.io.File;
import java.sql.Date;

public class FileOperations {
	
	public static void main(String [] args)
	{
		File file = new File("NewData");
		//boolean done = file.mkdir();
		
		System.out.println("Folder: "+file.getName());
		
		String[] files = file.list();
		 
        for (String s : files)
        {
        	File f = new File(file.getPath()+"/"+s);
            System.out.println(f.getName()+"   "+new Date(f.lastModified())+"   "+f.length());
        }
	}
}
