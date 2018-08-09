package com.ex.flowcontrol;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 * NOTES
 * 
 * Iterator is an interface with 3 methods
 * 	hasNext()
 * 	next()
 * 	remove()
 * 
 * Iterator is (sometimes) faster than a for loop
 * 		Because the next() method has a requirement of being O(1)
 * 				Think of LinkedList performance between for loop and Iterator
 * Iterator has no performance advantage over a foreach loop
 * 		Because a foreach loop is converted into using Iterator at compile time
 */
public class IteratorExample {
	public static void main(String[] args) {
		
		List<Integer> integerList = new ArrayList<>();
		integerList.add(10);
		integerList.add(11);
		integerList.add(12);
		integerList.add(13);
		integerList.add(14);
		
		Iterator<Integer> iter = integerList.iterator();
		
		while(iter.hasNext()){
			System.out.println(iter.next());
//			iter.remove();
		}
		

		
	}
}
