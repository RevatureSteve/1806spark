package com.collections;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Queue;
import java.util.Stack;

/*
 * List is an interface
 * 
 * Def: List is a group of objects that retain their insertion order
 * 
 * Know the important methods in this interface
 * Know the important implementing classes, and their methods
 * 
 * Documentation is your best friend
 * 
 * https://docs.oracle.com/javase/8/docs/api/java/util/List.html
 * 
 * Some List Methods:
 * 	add
 * 	addAll
 * 	clear
 * 	contains
 * 	containsAll
 * 	equals
 * 	get
 * 	indexOf
 * 	isEmpty
 * 	iterator
 * 	listIterator  //Much more functional than iterator
 * 	remove
 * 	removeAll
 * 	retainAll
 * 	set
 * 	size
 * 	sort
 * 	subList
 * 	toArray
 * 
 * LinkedList specific methods: 
 * 		NOTE: LinkedList has all above methods (because LinkedList implements List)
 * 		NOTE: LinkedList also implements Deque (that's where most of these methods come from)
 * 	addFirst
 * 	addLast
 * 	descendingIterator
 * 	element
 * 	getFirst
 * 	getLast	
 * 	offer
 * 	offerFirst
 * 	offerLast
 * 	peek
 * 	peekFirst
 * 	peekLast
 * 	poll
 * 	pollFirst
 * 	pollLast
 * 	pop
 * 	push
 * 	removeFirst
 * 	removeLast
 * 
 * If you want to see the difference between, for example, addFirst and offerFirst
 * 		https://docs.oracle.com/javase/8/docs/api/java/util/Deque.html
 */
public class ListExample {
	public static void main(String[] args) {
		
		/*
		 * ArrayList
		 */
		List<Integer> arrayList = new ArrayList<Integer>();
		arrayList.add(5);
		arrayList.add(5);
		arrayList.add(18);
		arrayList.add(2);
		arrayList.add(3);
		
		System.out.println("ArrayList: " + arrayList);
		System.out.println("ArrayList single value: " + arrayList.get(2)); //index
//		System.out.println("ArrayList single value: " + arrayList.get(5)); //IndexOutOfBoundsException
		
		/*
		 * ListIterator example of traversing backwards
		 * 
		 * With ListIterator you can:
		 * 		traverse forwards/backwards
		 * 		get next/previous index
		 * 		add elements
		 * 		set elements
		 * 		remove elements (also can do using Iterator)		
		 */
		ListIterator<Integer> listIterator = arrayList.listIterator(arrayList.size());
		while(listIterator.hasPrevious()){
			System.out.print(listIterator.previous() + " ");
		}
		System.out.println();
		
		
		
		/*
		 * LinkedList
		 */
		List<Integer> listLinkedList = new LinkedList<>();		//only has access to List methods
		Deque<Integer> dequeLinkedList = new LinkedList<>();	//only has access to Deque methods
		Queue<Integer> queueLinkedList = new LinkedList<>();	//only has access to Queue methods
		LinkedList<Integer> normalLinkedList = new LinkedList<>(); //has access to all methods
		/*
		 * I prefer to not use LinkedList as the reference type
		 * 		You should choose the appropriate reference type for each situation.
		 * 		That logic applies everywhere in Java, not just in collections.
		 */
		
		System.out.println("\nQueue Example (FIFO):"); //Think of a line at the bank
		System.out.println("Queue: " + queueLinkedList);
		queueLinkedList.add(7);
		System.out.println("Queue: " + queueLinkedList);
		queueLinkedList.add(8);
		System.out.println("Queue: " + queueLinkedList);
		queueLinkedList.add(9);
		System.out.println("Queue: " + queueLinkedList);
		System.out.println("element: " + queueLinkedList.element());
		System.out.println("Queue: " + queueLinkedList);
		System.out.println("remove: " + queueLinkedList.remove());
		System.out.println("Queue: " + queueLinkedList);
		System.out.println("remove: " + queueLinkedList.remove());
		System.out.println("Queue: " + queueLinkedList);
		System.out.println("remove: " + queueLinkedList.remove());
		System.out.println("Queue: " + queueLinkedList);
//		System.out.println("remove: " + queueLinkedList.remove()); //NoSuchElementException
		
		/*
		 * Stack Methods:
		 * 	empty
		 * 	peek
		 * 	pop
		 * 	push
		 * 	search (1 based)
		 * 
		 */
		System.out.println("\nStack Example (LIFO):"); //Think of a stack of plates
		Stack<Integer> stack = new Stack<>();
		System.out.println("Stack: " + stack);
		stack.push(7);
		System.out.println("Stack: " + stack);
		stack.push(8);
		System.out.println("Stack: " + stack);
		stack.push(9);
		System.out.println("Stack: " + stack);
		System.out.println(stack.peek());
		System.out.println("Stack: " + stack);
		System.out.println(stack.pop());
		System.out.println("Stack: " + stack);
		System.out.println(stack.pop());
		System.out.println("Stack: " + stack);
		System.out.println(stack.pop());
		System.out.println("Stack: " + stack);
//		System.out.println(stack.pop());		//EmptyStackException
		
	}
}


