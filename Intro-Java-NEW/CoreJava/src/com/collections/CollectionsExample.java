package com.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * Collections is a 'Utility Class' (notice the 's')
 *		Utility classes typically have many helpful static methods
 * 
 * Collections static methods
 * 	binarySearch (must be sorted in ascending order)
 * 	copy (really good example of a generic method)
 * 	fill
 * 	frequency
 * 	reverse
 * 	rotate
 * 	shuffle
 * 	sort
 * 	swap
 */
public class CollectionsExample {
	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<>();
		list.add(5);
		list.add(2);
		list.add(4);
		list.add(1);
		list.add(3);
		list.add(3);
		
		System.out.println("List: " + list);
		Collections.sort(list);
		System.out.println("List: " + list);
		
		/*
		 * NOTE: There is an overloaded sort method that takes a list AND a comparator object
		 */
		
	}
}
