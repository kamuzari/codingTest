package BaekJoon.단기간성장;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BuyAndSell {
	private static void input(Scanner sc) {
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		List<Integer> prices = new ArrayList<>();
		while (st.hasMoreTokens()) {
			prices.add(Integer.parseInt(st.nextToken()));
		}
		int k = Integer.parseInt(sc.nextLine());
		System.out.println(solve(prices, k));
	}

	static class Node implements Comparable<Node> {

		int id;
		int price;

		public Node(int idx, int price) {
			this.id = idx;
			this.price = price;
		}

		@Override
		public int compareTo(Node o) {
			return price - o.price;
		}

	}

	static int solve(List<Integer> prices, int k) {
		int maxProfit = -1;
		PriorityQueue<Integer>[] list = new PriorityQueue[prices.size()];
		for (int i = 0; i < prices.size(); i++) {
			list[i] = new PriorityQueue(Collections.reverseOrder());
		}

		for (int i = 0; i < list.length; i++) {
			for (int j = i + 1; j < prices.size(); j++) {
				list[i].offer(prices.get(j));
			}
		}

		for (int i = 0; i < list.length; i++) {
			PriorityQueue<Integer> nexts = list[i];
			int kCount = 0;
			int profit = 0;
			int buyPrice = prices.get(i);
			while (kCount < k) {
				if (nexts.isEmpty()) {
					break;
				}

				profit += (nexts.poll() - buyPrice);
				kCount++;
			}

			if (kCount == k) {
				maxProfit = Math.max(maxProfit, profit);
			}
		}

		if (maxProfit <= 0) {
			maxProfit = -1;
		}

		return maxProfit;
	}

	static boolean isOutOf(int k, int curId, int limit) {
		return curId + k >= limit;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		input(sc);
	}
}

	/*
10 7 8 5 8 7 6 2 9
3
ans: 9

10 7 8 5 6 4 3 2 3
3
ans: -1

15 7 8 5 6 4 3 9
4
ans: 2
	 */

