package coreplatform.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CollectionsApp {

	/**
	 * Examples of how use Collections (Set, List, Queue, etc) and Maps
	 * @param args
	 */
	public static void main(String[] args) {
		// Interfaces List, Set
		/*
		 * List can have duplicated values but Set just uniques
		 * Implementations for List could be ArrayList or LinkedList
		 */
		List<String> names = new ArrayList<>();
		List<String> otherNames = new ArrayList<>();
		names.addAll(Arrays.asList("Pedro", "Sandro", "El Joe", "Pedro"));
		Set<String> uniqueNames = new HashSet<>(names);
		otherNames.add("Pepe");
		otherNames.add("Sandro");
		
		// typical methods
		names.addAll(otherNames);
		uniqueNames.forEach(System.out::println);
		System.out.println("-------------------------");
		names.forEach(System.out::println);
		names.clear();
		System.out.println("---------------------");
		names.forEach(System.out::println);
	}
}
