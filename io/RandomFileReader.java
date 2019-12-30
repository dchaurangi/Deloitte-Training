package io;

import java.io.IOException;  
import java.io.RandomAccessFile;  
  
public class RandomFileReader {  
    static final String FILEPATH ="C:\\Users\\admin\\Desktop\\Password.txt";  
    public static void main(String[] args) {  
        try {  
            System.out.println(new String(readFromFile(FILEPATH, 22, 16)));  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
    private static byte[] readFromFile(String filePath, int position, int size)  
            throws IOException {  
        RandomAccessFile file = new RandomAccessFile(filePath, "r");  
        file.seek(position);  
        byte[] bytes = new byte[size];  
        file.read(bytes);  
        file.close();  
        return bytes;  
    }  
    
} 