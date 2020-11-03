package it.unibo.oop.lab.collections1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Example class using {@link java.util.List} and {@link java.util.Map}.
 * 
 */
public final class UseCollection {

    private UseCollection() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
    	/*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        
    	final ArrayList<Integer> al = new ArrayList<>();
    	//((ArrayList<Integer>)al).ensureCapacity(999);
    	
    	for(int i = 1000; i < 2000; i++) {
    		al.add(i);
    	}
    	System.out.println(al);
    	
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
    	
    	final LinkedList<Integer> ll = new LinkedList<>(al);
    	System.out.println(ll);
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
    	
    	int temp = al.get(999);
    	al.set(999, al.get(0));
    	al.set(0, temp);
    	System.out.println(al);
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
    	
    	for(int elem : al) {
    		System.out.println(elem);
    	}
    	
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
    	
    	long timeAddArrayList = System.nanoTime();
    	for(int i = 0; i < 100_000; i++) {
    		al.add(0, i);
    	}
    	timeAddArrayList = System.nanoTime() - timeAddArrayList;
    	System.out.println("Tempo di aggiunta array: " + timeAddArrayList);
    	
    	long timeAddLinkedList = System.nanoTime();
    	for(int i = 0; i < 100_000; i++) {
    		ll.add(0, i);
    	}
    	timeAddLinkedList = System.nanoTime() - timeAddLinkedList;
    	System.out.println("Tempo di aggiunta array: " + timeAddLinkedList);
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
    	
    	long timeGetArrayList = System.nanoTime();
    	for(int i = 0; i < 1_000; i++) {
    		al.get(al.size()/2);
    	}
    	timeGetArrayList = System.nanoTime() - timeGetArrayList;
    	System.out.println("Tempo di get array: " + timeGetArrayList);
    	
    	long timeGetLinkedList = System.nanoTime();
    	for(int i = 0; i < 1_000; i++) {
    		ll.get(ll.size()/2);
    	}
    	timeGetLinkedList = System.nanoTime() - timeGetLinkedList;
    	System.out.println("Tempo di get list: " + timeGetLinkedList);
    	
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         * 
         * Africa -> 1,110,635,000
         * 
         * Americas -> 972,005,000
         * 
         * Antarctica -> 0
         * 
         * Asia -> 4,298,723,000
         * 
         * Europe -> 742,452,000
         * 
         * Oceania -> 38,304,000
         */
    	
    	final Map<String, Long> hm = new HashMap<>();
    	hm.put("Africa", 1_110_635_000L);
    	hm.put("Americas", 972_005_000L);
    	hm.put("Antarctica", 0L);
    	hm.put("Asia", 4_298_723_000L);
    	hm.put("Europe", 742_452_000L);
    	hm.put("Oceania", 38_304_000L);
    	
        /*
         * 8) Compute the population of the world
         */
    	
    	long population = 0;
    	for(long singlePopulation: hm.values()) {
    		population += singlePopulation;
    	}
    	System.out.println("Popolazione totale: " + population);
    }
}
