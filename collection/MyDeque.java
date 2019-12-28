package collection;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class MyDeque {
	
	 public static void main(String[] args) 
	    { 
	        Deque<String> deque = new LinkedList<String>(); 
	  
	        deque.add("1");
	        deque.addFirst("2"); 
	        deque.addLast("3");
	        
	        Iterator iterator = deque.iterator(); 
	        while (iterator.hasNext()) 
	            System.out.println(iterator.next()+"\n"); 
	        
	        System.out.println("Peek " + deque.peek());
	        System.out.println("Peek First " + deque.peekFirst());
	        System.out.println("Peek Last " + deque.peekLast());

 
	  
	      
	  
	    } 

}
