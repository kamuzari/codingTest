package saffy;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.TreeMap;

public class DoublePriorityQueue {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = Integer.parseInt(sc.nextLine());
		StringBuilder answer = new StringBuilder();

		while (testCase-- > 0) {
			int requestCount = Integer.parseInt(sc.nextLine());
			TreeMap<Integer, Integer> maps = new TreeMap<>();
			while (requestCount-- > 0) {
				String[] command = sc.nextLine().split(" ");
				String action = command[0];
				int value = Integer.parseInt(command[1]);
				if (action.equals("I")) {
					maps.put(value, maps.getOrDefault(value, 0) + 1);
				} else if (action.equals("D")) {
					if (maps.isEmpty())
						continue;
					if (value == 1) {
						Integer maxValue = maps.lastKey();
						if (maps.get(maxValue) == 1) {
							maps.remove(maxValue);
						} else {
							maps.put(maxValue, maps.get(maxValue) - 1);
						}
					} else if (value == -1) {
						Integer minValue = maps.firstKey();
						if (maps.get(minValue) == 1) {
							maps.remove(minValue);
						} else {
							maps.put(minValue, maps.get(minValue) - 1);
						}
						System.out.println(false);
					}
				}
			}
			if (maps.isEmpty()) {
				answer.append("EMPTY");
			} else {
				answer.append(maps.lastKey() + " " + maps.firstKey());
			}
			answer.append(System.lineSeparator());
		}
		System.out.println(answer);
	}
}
