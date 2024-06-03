package BaekJoon.solvedac5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SubSequenceSummary2 {

	private static int[] arr;
	private static List<Integer> leftContainers;
	private static List<Integer> rightContainers;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		leftContainers = new ArrayList<>();
		rightContainers = new ArrayList<>();
		arr = new int[n];
		st = new StringTokenizer(sc.nextLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		resolveSubSet(0, n / 2, 0, leftContainers);
		resolveSubSet(n / 2, n, 0, rightContainers);
		Collections.sort(leftContainers);
		Collections.sort(rightContainers);
		long answer = count(s);

		if (s == 0) {
			answer--;
		}

		System.out.println(answer);
	}

	static void resolveSubSet(int cnt, int end, int sum, List<Integer> containers) {
		if (cnt == end) {
			containers.add(sum);
			return;
		}

		resolveSubSet(cnt + 1, end, sum, containers);
		resolveSubSet(cnt + 1, end, sum + arr[cnt], containers);
	}

	static long count(int condition) {
		long verifiedCount = 0;
		int l = 0;
		int r = rightContainers.size() - 1;

		while (true) {
			if (l >= leftContainers.size() || r < 0) {
				break;
			}

			long sum = leftContainers.get(l) + rightContainers.get(r);
			if (sum == condition) {
				int leftValue = leftContainers.get(l);
				long count1 = 0L;

				while (l < leftContainers.size() && leftContainers.get(l) == leftValue) {
					l++;
					count1++;
				}

				int rightValue = rightContainers.get(r);
				long count2 = 0L;
				while (r >= 0 && rightContainers.get(r) == rightValue) {
					r--;
					count2++;
				}

				verifiedCount += count1 * count2;
			} else if (sum < condition) {
				l++;
			} else {
				r--;
			}
		}

		return verifiedCount;
	}
}
