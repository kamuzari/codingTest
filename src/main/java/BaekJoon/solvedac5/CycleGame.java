package BaekJoon.solvedac5;

import java.util.Scanner;
import java.util.StringTokenizer;

public class CycleGame {
	static int[] parents;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		parents = new int[n];
		for (int i = 0; i < n; i++) {
			parents[i] = i;
		}

		int answer = 0;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(sc.nextLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			int parentA = find(a);
			int parentB = find(b);

			boolean isCycle = parentA == parentB;
			if (isCycle) {
				int step = i + 1;
				answer = step;
				break;
			} else {
				union(a, b);
			}
		}

		System.out.println(answer);
	}

	static int find(int node) {
		if (parents[node] == node) {
			return node;
		}

		return parents[node] = find(parents[node]);
	}

	static void union(int a, int b) {
		a = find(a);
		b = find(b);

		if (parents[a] > parents[b]) {
			parents[b] = a;
		} else {
			parents[a] = b;
		}
	}
}
