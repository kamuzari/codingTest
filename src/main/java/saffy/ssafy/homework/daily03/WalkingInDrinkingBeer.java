package saffy.ssafy.homework.daily03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class WalkingInDrinkingBeer {
	static Scanner sc = new Scanner(System.in);

	static class Node {
		int y, x;

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}

		public int getDistance(Node o) {
			return Math.abs(y - o.y) + Math.abs(x - o.x);
		}
	}

	public static void main(String[] args) {
		int tc = Integer.parseInt(sc.nextLine());
		StringBuilder answer = new StringBuilder();

		for (int testCase = 0; testCase < tc; testCase++) {
			String result = "";
			int n = Integer.parseInt(sc.nextLine());
			List<Node> nodes = new ArrayList<>();
			for (int i = 0; i < n + 2; i++) {
				StringTokenizer st = new StringTokenizer(sc.nextLine());
				nodes.add(new Node(
					Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken())
				));
			}

			boolean[][] isGo = new boolean[n + 2][n + 2];
			for (int i = 0; i < n + 2; i++) {
				Node node = nodes.get(i);
				for (int j = 0; j < n + 2; j++) {
					int distance = node.getDistance(nodes.get(j));
					if (distance <= 1000) {
						isGo[i][j] = true;
					}
				}
			}

			for (int k = 0; k < n + 2; k++) {
				for (int i = 0; i < n + 2; i++) {
					for (int j = 0; j < n + 2; j++) {
						if (isGo[i][k] && isGo[k][j]) {
							isGo[i][j] = true;
						}
					}
				}
			}
			if (isGo[0][n + 2 - 1]) {
				result = "happy";
			} else {
				result = "sad";
			}

			answer.append(result).append(System.lineSeparator());
		}

		System.out.println(answer);
	}
}
