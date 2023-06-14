package BaekJoon.tony.greedy;

import java.util.Scanner;

public class BulbAndSwitch {
	static int dx[] = {-1, 0, 1};
	static int n;
	static int INF = Integer.MAX_VALUE;
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		n = Integer.parseInt(sc.nextLine());

		int origin1[] = new int[n]; // 첫번째 그대로
		int origin2[] = new int[n]; // 첫번째 변화주기
		int expect[] = new int[n];

		String str = sc.nextLine();
		for (int i = 0; i < n; i++) {
			origin2[i] = origin1[i] = str.charAt(i) - '0';
		}

		str = sc.nextLine();
		for (int i = 0; i < n; i++) {
			expect[i] = str.charAt(i) - '0';
		}

		effect(origin2,0);

		int answer = INF;
		int answer1 = 0;
		for (int i = 1; i < n; i++) {
			if (origin1[i-1] != expect[i-1]) {
				effect(origin1, i);
				answer1++;
			}
		}

		if (origin1[n - 1] == expect[n - 1]) {
			answer = Math.min(answer1, answer);
		}

		int answer2 =1;
		for (int i = 1; i < n; i++) {
			if (origin2[i-1] != expect[i-1]) {
				effect(origin2, i);
				answer2++;
			}
		}

		if (origin2[n - 1] == expect[n - 1]) {
			answer = Math.min(answer2, answer);
		}

		answer = answer == INF ? -1 : answer;
		System.out.println(answer);
	}

	static void effect(int[] arr, int idx) {
		for (int i = 0; i < 3; i++) {
			int nextIndex = idx + dx[i];

			if (nextIndex < 0 || nextIndex >= n) {
				continue;
			}

			arr[nextIndex] = 1 - arr[nextIndex];
		}
	}

}
