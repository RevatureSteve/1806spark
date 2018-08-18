package com.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/*
 * Map is an interface
 * 
 * Def: Map is a group of key/value pairs, does NOT remember insertion order
 * 		Keys are unique
 * 
 * Know the important methods in this interface
 * Know the important implementing classes, and their methods
 * 
 * Documentation is your best friend
 * 
 * https://docs.oracle.com/javase/8/docs/api/java/util/Map.html
 * 
 * 
 * Some Map Methods:
 * 		NOTE: Map does not have iterator() because Map doesn't implement Collection, which implements Iterable
 * 		NOTE: Map doesn't implement Collection because some methods in the Collection interface are incompatible i.e. remove
 * 	clear
 * 	containsKey
 * 	containsValue
 * 	entrySet
 * 	equals
 * 	get
 * 	isEmpty
 * 	keySet
 * 	put
 * 	putAll
 * 	putIfAbsent
 * 	remove
 * 	replace
 * 	size
 * 	values
 * 
 * TreeMap specific methods
 * 		NOTE: TreeMap has all above methods (because TreeMap implements Map)
 * 		NOTE: TreeMap also implements NavigableMap, which implements SortedMap (that's where most of these methods come from)
 * 	ceilingEntry
 * 	ceilingKey
 * 	comparator
 * 	descendingKeySet
 * 	descendingMap
 * 	firstEntry
 * 	firstKey
 * 	floorEntry
 * 	floorKey
 * 	headMap
 * 	higherEntry
 * 	higherKey
 * 	lastEntry
 * 	lastKey
 * 	lowerEntry
 * 	lowerKey
 * 	navigableKeySet
 * 	subMap
 * 	tailMap
 */
public class MapExample {
	public static void main(String[] args) {
		/*
		 * HashMap
		 */
		Map<Integer, String> hashMap = new HashMap<>();
		hashMap.put(4,  "John Smith");
		hashMap.put(2,  "Amy Smith");
		hashMap.put(17, "Austin Smith");
		hashMap.put(5,  "Katie Smith");
		hashMap.put(10, "Courtney Smith");
		hashMap.put(10, "Scout Smith");		//replaces Courtney Smith
		
		System.out.println("HashMap: " + hashMap);
		System.out.println("HashMap size: " + hashMap.size());
		System.out.println("HashMap single value: " + hashMap.get(5));	//key value
		System.out.println("HashMap single value: " + hashMap.get(99));
		
		System.out.println("\nHashMap Loop:");
		for(Entry<Integer, String> entry : hashMap.entrySet()){
			System.out.println(entry.getKey() + "\t" + entry.getValue());
		}
		
		/*
		 * TreeMap
		 */
		Map<Integer, String> treeMap = new TreeMap<>(); //sorted
		treeMap.putAll(hashMap);
		
		System.out.println("\nTreeMap Loop:");
		for(Entry<Integer, String> entry : treeMap.entrySet()){
			System.out.println(entry.getKey() + "\t" + entry.getValue());
		}
		
		
	}
}
