package com.java.spec.tiennv.java.lang;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


public class UsingIterator {
	public static void main(String args[]) {
		
	      List<String> al = new ArrayList<>();
	      
	      al.add("C");
	      al.add("A");
	      al.add("E");
	      al.add("B");
	      al.add("D");
	      al.add("F");
	      
	      Iterator<String> iterator = al.iterator();
	      while (iterator.hasNext()) {
	    	  System.out.print(iterator.next() + " ");
	      }
	      
	      System.out.println();
	      
	      ListIterator<String> listIterator = al.listIterator();
	      
	      //modify objects being iterated
	      
	      while (listIterator.hasNext()) {
	    	  Object s = listIterator.next();
	    	  listIterator.set(s + "(updated)");
	      }
	      
	      iterator = al.iterator();
	      while (iterator.hasNext()) {
	    	  System.out.print(iterator.next() + " ");
	      }
	      
	      //display list backward
	      
	      while (listIterator.hasPrevious()) {
	    	  Object element = listIterator.previous();
	    	  System.out.println(element + " ");
	      }
	      
	      System.out.println();
	      

	}
}
