package com.collections;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/*
 * Set is an interface
 * 
 * Def: Set is a group of distinct objects that don't retain their insertion order
 *  
 * Know the important methods in this interface
 * Know the important implementing classes, and their methods
 * 
 * Documentation is your best friend
 * 
 * https://docs.oracle.com/javase/8/docs/api/java/util/Set.html
 * 
 * Some Set Methods:
 * 		NOTE: somewhat similar to List (doesn't have get)
 * 	add
 * 	addAll
 * 	clear
 * 	contains
 * 	containsAll
 * 	equals
 * 	isEmpty
 * 	iterator
 * 	remove
 * 	removeAll
 * 	retainAll
 * 	size
 * 	toArray
 * 
 * TreeSet specific methods
 * 		NOTE: TreeSet has all above methods (because TreeSet implements Set)
 * 		NOTE: TreeSet also implements NavigableSet, which implements SortedSet (that's where most of these methods come from)
 * 	ceiling
 * 	comparator
 * 	descendingIterator
 * 	descendingSet
 * 	first
 * 	floor
 * 	headSet
 * 	higher
 * 	last
 * 	lower
 * 	subSet
 * 	tailSet
 */
public class SetExample {
	public static void main(String[] args) {
		/*
		 * HashSet
		 */
		Set<Integer> hashSet = new HashSet<>();
		hashSet.add(5);
		hashSet.add(5);
		hashSet.add(2);
		hashSet.add(17);
		hashSet.add(6);
		
		System.out.println("HashSet: " + hashSet);
		System.out.println("HashSet size: " + hashSet.size());
		
		
		/*
		 * TreeSet
		 */
		Set<Integer> treeSet = new TreeSet<>(); //sorted
		treeSet.addAll(hashSet);
		System.out.println("TreeSet: " + treeSet);
		
		
	}

}
