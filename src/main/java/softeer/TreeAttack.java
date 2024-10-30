package softeer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class TreeAttack {
	static final int ATTACK_COUNT = 2;
	static final Scanner sc = new Scanner(System.in);

	static StringTokenizer st;
	static int n;
	static int m;
	static List<Integer> L;
	static List<Integer> R;
	static LinkedList<Integer>[] grid;

	public static void main(String[] args) {
		enter();
		attack();
		int answer = count();

		System.out.println(answer);
	}

	private static int count() {
		int restCount = 0;
		for (int i = 0; i < n; i++) {
			restCount += grid[i].size();
		}

		return restCount;
	}

	private static void attack() {
		int repeat = ATTACK_COUNT;
		while (repeat-- > 0) {
			int start = L.get(repeat);
			int end = R.get(repeat);

			for (int i = start - 1; i < end; i++) {
				if (grid[i].isEmpty()) {
					continue;
				}

				grid[i].pop();
			}
		}
	}

	private static void enter() {
		st = new StringTokenizer(sc.nextLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		grid = new LinkedList[n];
		for (int i = 0; i < n; i++) {
			grid[i] = new LinkedList<>();
		}

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(sc.nextLine());
			for (int j = 0; j < m; j++) {
				int val = Integer.parseInt(st.nextToken());

				if (val == 0) {
					continue;
				}

				grid[i].add(j);
			}
		}

		int repeat = 2;
		L = new ArrayList<>();
		R = new ArrayList<>();
		while (repeat-- > 0) {
			st = new StringTokenizer(sc.nextLine());
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());

			L.add(l);
			R.add(r);
		}
	}
}
