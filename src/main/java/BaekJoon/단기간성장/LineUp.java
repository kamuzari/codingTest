package BaekJoon.단기간성장;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class LineUp {
	static Set<String> winners = new HashSet<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder answer = new StringBuilder();
		int repeatCount = Integer.parseInt(sc.nextLine());
		for (int tc = 1; tc <= repeatCount; tc++) {
			int cur = 0;
			int[] arr = new int[20];
			StringTokenizer st = new StringTokenizer(sc.nextLine());
			int switchCount = 0;
			st.nextToken();
			while (st.hasMoreTokens()) {
				if (cur == 0) {
					arr[cur] = Integer.parseInt(st.nextToken());
				} else {
					arr[cur] = Integer.parseInt(st.nextToken());
					int idx = cur;
					for (int i = idx - 1; i >= 0; i--) {
						if (arr[i] <= arr[idx]) {
							break;
						}

						swap(i, idx, arr);
						idx = i;
						switchCount++;
					}
				}

				cur++;
			}
			answer.append(tc).append(" ").append(switchCount).append(System.lineSeparator());
		}
		System.out.println(answer);
	}

	static void swap(int a, int b, int[] arr) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
}
