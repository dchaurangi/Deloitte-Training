package io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import collection.Student;
public class ObjectCopier {

	public static void main(String[] args) {
		// 

		Student st = new Student("Akash",1245);
		try {
		FileOutputStream fout = new FileOutputStream("std.ser");
				ObjectOutputStream oos = new ObjectOutputStream(fout);
				oos.writeObject(st);
				oos.flush();
				oos.close();
				System.out.println("Object serialized");
	}
		catch(IOException ioe)
		{
			System.out.println("Object filed in serializable"+ioe);
		}

	}

}

