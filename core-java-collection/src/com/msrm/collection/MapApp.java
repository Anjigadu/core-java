package com.msrm.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapApp {

	public static void main(String[] args) {

		int[] keys = { 1, 2, 4, 3, 7, 8, 5 };
		String[] values = { "one", "two", "four", "three", "seven", "eight", "five" };

		MapApp app = new MapApp();
		Map<Integer, String> map = app.createMap(keys, values);
		System.out.println(map);

		Set<Integer> keySet = map.keySet();
		Iterator<Integer> itr = keySet.iterator();
		while (itr.hasNext()) {
			Integer key = itr.next();
			System.out.println(key + " : " + map.get(key));
		}

		System.out.println(map.values());

		System.out.println(map.keySet());

		System.out.println("\n Foreach loop");
		for (Integer key : keySet) {
			System.out.println(key + " : " + map.get(key));
		}
	}

	public Map<Integer, String> createMap(int[] keys, String[] values) {
		Map<Integer, String> map = new HashMap<>();

		for (int i = 0; i < keys.length; i++) {
			map.put(keys[i], values[i]);
		}

		return map;
	}

}
