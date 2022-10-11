package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class PizzaDeliveryDistance {

	private static final int PIZZA = 2;
	private static final int PERSON = 1;
	private static int n;
	private static int m;
	private static int answer = 101;
	private static int[][] board;
	private static List<Node> pizzas;
	private static List<Node> persons;

	/**
	 * how : 피자집 중 M개를 선택하는 기준은 최소가 되는 기준은 ?
	 *  1, 피자집중 m개를 뽑는다
	 *  2. m개를 뽑은 다음 사람이 사는 거리를 측정한다.'
	 *  3. 측정한 거리를 기준으로 m개의 피자집의 최소 배달 거리를 구한다. (가장 큰 거리)
	 */

	static class Node {
		private int y;
		private int x;

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}

		public int getDistance(Node other) {
			return Math.abs(this.y - other.y) + Math.abs(this.x - other.x);
		}
	}

	static Stack<Node> candidates = new Stack<>();

	public static void main(String[] args) throws IOException {
		pizzas = new ArrayList<>();
		persons = new ArrayList<>();

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		board = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(reader.readLine());

			for (int j = 0; j < n; j++) {
				int val = board[i][j] = Integer.parseInt(st.nextToken());

				if (val == PIZZA) {
					pizzas.add(new Node(i, j));
				} else if (val == PERSON) {
					persons.add(new Node(i, j));
				}
			}
		}

		combinate(0, 0);

		System.out.println(answer);

	}

	public static void combinate(int cnt, int idx) {
		if (cnt == m) {
			int totalDistance = 0;

			for (Node person : persons) {
				int minDistance = 101;
				for (Node candidate : candidates) {
					minDistance = Math.min(minDistance, person.getDistance(candidate));
				}

				totalDistance += minDistance;
			}

			answer = Math.min(answer, totalDistance);
			return;
		}

		for (int i = idx; i < pizzas.size(); i++) {
			candidates.push(pizzas.get(i));
			combinate(cnt + 1, i + 1);
			candidates.pop();
		}
	}
}
