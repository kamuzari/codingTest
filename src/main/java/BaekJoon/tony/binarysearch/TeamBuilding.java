package BaekJoon.tony.binarysearch;

import java.util.Scanner;
import java.util.StringTokenizer;

public class TeamBuilding {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		solve(n, arr);
	}

	static void solve(int n, int[] abilities) {
		int answer = 0;
		int s = 0;
		int e = n - 1;

		while (true) {
			if (e >= n || s >= e) {
				break;
			}

			int result = getGivenFormula(abilities, e, s);
			answer = Math.max(answer, result);
			boolean isSmallerLeft = abilities[s] <= abilities[e];
			if (isSmallerLeft) {
				s++;
			} else {
				e--;
			}
		}

		System.out.println(answer);
	}

	private static int getGivenFormula(int[] abilities, int e, int s) {
		return (e - s - 1) * Math.min(abilities[s], abilities[e]);
	}
}
