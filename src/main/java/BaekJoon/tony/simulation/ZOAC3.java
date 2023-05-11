package BaekJoon.tony.simulation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class ZOAC3 {
	static Scanner sc = new Scanner(System.in);
	static Map<Character, int[]> map;
	static Set<Character> lefts;

	static {
		lefts = new HashSet<>();
		lefts.add('q');
		lefts.add('w');
		lefts.add('e');
		lefts.add('r');
		lefts.add('t');

		lefts.add('a');
		lefts.add('s');
		lefts.add('d');
		lefts.add('f');
		lefts.add('g');

		lefts.add('z');
		lefts.add('x');
		lefts.add('c');
		lefts.add('v');

		map = new HashMap<>();
		// 자음
		map.put('q', new int[] {0, 0});
		map.put('w', new int[] {0, 1});
		map.put('e', new int[] {0, 2});
		map.put('r', new int[] {0, 3});
		map.put('t', new int[] {0, 4});
		map.put('a', new int[] {1, 0});
		map.put('s', new int[] {1, 1});
		map.put('d', new int[] {1, 2});
		map.put('f', new int[] {1, 3});
		map.put('g', new int[] {1, 4});
		map.put('z', new int[] {2, 0});
		map.put('x', new int[] {2, 1});
		map.put('c', new int[] {2, 2});
		map.put('v', new int[] {2, 3});

		// 모음
		map.put('y', new int[] {0, 5});
		map.put('u', new int[] {0, 6});
		map.put('i', new int[] {0, 7});
		map.put('o', new int[] {0, 8});
		map.put('p', new int[] {0, 9});
		map.put('h', new int[] {1, 5});
		map.put('j', new int[] {1, 6});
		map.put('k', new int[] {1, 7});
		map.put('l', new int[] {1, 8});
		map.put('b', new int[] {2, 4});
		map.put('n', new int[] {2, 5});
		map.put('m', new int[] {2, 6});

	}

	public static void main(String[] args) {
		int answer = 0;
		String str[] = sc.nextLine().split(" ");
		char leftstart = str[0].charAt(0);
		char rightstart = str[1].charAt(0);

		String s = sc.nextLine();
		int left[] = map.get(leftstart);
		int right[] = map.get(rightstart);

		for (int i = 0; i < s.length(); i++) {
			char cur = s.charAt(i);
			if (lefts.contains(cur)) {
				int[] next = map.get(cur);
				answer += getDiff(left, next);
				left = next;
			} else {
				int[] next = map.get(cur);
				answer += getDiff(right, next);
				right = next;
			}

			answer++;// 키 누르는 시간
		}

		System.out.println(answer);
	}

	static int getDiff(int[] source, int[] dest) {
		return Math.abs(source[0] - dest[0]) + Math.abs(source[1] - dest[1]);
	}
}
