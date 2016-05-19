package org.fun.util;

import java.util.*;
import java.util.stream.Stream;

public class PrettyPrint {
	private static void printLine() {
		System.out.println("--------------------------------------------------");
	}

	public static <K, V> void collection(Collection<V> collection) {
		printLine();
		System.out.println("Total Elements: " + collection.size());
		printLine();
		collection.forEach(a -> System.out.println("\t" + a));

	}

	public static <K, V> void list(List<V> list) {
		collection(list);
	}

	public static <K, V> void map(Map<K, V> map) {
		printLine();
		System.out.println("Map has: Keys: " + map.keySet().size());

		printLine();
		map.forEach((k, v) -> System.out.printf("\t%s = %s\n", k, v));
	}

	public static <K, V> void multiMap(Map<K, ? extends Collection<V>> multiMap) {
		printLine();
		System.out.printf("MultiMap has: Keys: %d, Values: %d \n",
				multiMap.keySet().size(),
				multiMap.values().stream().mapToInt(Collection::size).sum());
		printLine();

		multiMap.keySet().forEach(k -> {
			System.out.println(k);
			multiMap.get(k).stream()
					.forEach(a -> System.out.println("\t" + a));
		});
	}

	public static <T> void nestedCollection(Collection<? extends Collection<T>> nestedList) {
		printLine();
		System.out.println("{ Total Elements: " + nestedList.size());
		printLine();
		nestedList.forEach(list -> {
			System.out.println("\t{ \t\tTotal Elements: " + list.size());
			list.forEach(x -> System.out.println("\t\t" + x));
			System.out.println("\t}");
		});
		System.out.println("}");
	}

	public static <K, K2, V2> void nestedMultiMap(Map<K, ? extends Map<K2, ? extends Collection<V2>>> nestedMultiMap) {
		printLine();
		System.out.printf("Nested MultiMap has: Keys: %d, Values: %d \n",
				nestedMultiMap.keySet().size(),
				nestedMultiMap.values().stream()
						.flatMap(m -> Stream.of(m.values()))
						.mapToInt(Collection::size).sum());

		nestedMultiMap.keySet().forEach(k -> {
			System.out.println(k);

			nestedMultiMap.get(k).entrySet().forEach(j -> {
				System.out.println("\t" + j.getKey());
				j.getValue()
						.stream()
						.forEach(a -> System.out.println("\t\t" + a));
			});
		});
	}


	public static <K, K2, V2> void nestedMap(Map<K, ? extends Map<K2, V2>> nestedMap) {
		printLine();
		System.out.printf("Nested Map has: Keys: %d, Values: %d \n",
				nestedMap.keySet().size(),
				nestedMap.values().stream()
						.flatMap(m -> Stream.of(m.values()))
						.mapToInt(Collection::size).sum());

		nestedMap.keySet().forEach(k -> {
			System.out.println(k);

			nestedMap.get(k).entrySet().forEach(j -> {
				System.out.println("\t" + j.getKey() + " : " + j.getValue());
			});
		});
	}

}