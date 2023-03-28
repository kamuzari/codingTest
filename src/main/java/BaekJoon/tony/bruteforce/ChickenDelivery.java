package BaekJoon.tony.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ChickenDelivery {
	static class Node {

		int y, x;

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}

		public int getDist(Node o) {
			return Math.abs(this.y - o.y) + Math.abs(this.x - o.x);
		}
	}

	static final int HOUSE = 1;
	static final int CHICKEN_HOUSE = 2;
	static int n, m, answer = (int)1e9;
	static int map[][];
	static List<Node> houses = new ArrayList<>();
	static List<Node> chickens = new ArrayList<>();
	static Node[] picks;

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		// 입력 구간
		StringTokenizer st = new StringTokenizer(reader.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		picks = new Node[m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(reader.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				if (map[i][j] == HOUSE) {
					houses.add(new Node(i, j));
				} else if (map[i][j] == CHICKEN_HOUSE) {
					chickens.add(new Node(i, j));
				}
			}
		}

		pickLiveChickens(0, 0);

		System.out.println(answer);
	}

	public static void pickLiveChickens(int cnt, int startIdx) {
		if (cnt == m) {
			// 거리 측정하기
			answer = Math.min(answer, getDist());
			return;
		}

		for (int i = startIdx; i < chickens.size(); i++) {
			picks[cnt] = chickens.get(i);
			pickLiveChickens(cnt + 1, i + 1);
		}
	}

	private static int getDist() {
		int sum = 0;
		for (Node house : houses) {
			int minDist = (int)1e9;
			for (Node chicken : picks) {
				int newDist = chicken.getDist(house);
				minDist = Math.min(minDist, newDist);
			}

			sum += minDist;
		}

		return sum;
	}
}
