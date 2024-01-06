package saffy.demotest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class OptimalPath {
	private static class Position {
		private int y;
		private int x;

		public Position(int y, int x) {
			this.y = y;
			this.x = x;
		}

		public int getDistance(Position position) {
			return Math.abs(this.y - position.y) + Math.abs(this.x - position.x);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder answers = new StringBuilder();
		int repeatCount = Integer.parseInt(sc.nextLine());

		for (int testCase = 1; testCase <= repeatCount; testCase++) {
			int customerCount = Integer.parseInt(sc.nextLine());
			StringTokenizer st = new StringTokenizer(sc.nextLine());

			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			Position enterprise = new Position(y, x);
			y = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			Position house = new Position(y, x);

			List<Position> customers = new ArrayList<>();
			for (int i = 0; i < customerCount; i++) {
				 y = Integer.parseInt(st.nextToken());
				 x = Integer.parseInt(st.nextToken());

				customers.add(new Position(y, x));
			}



			int optimalDistance = getOptimalTotalDistance(customers, house, enterprise);

			String answer = String.format("#%d %d", testCase, optimalDistance);
			answers.append(answer).append(System.lineSeparator());
		}

		System.out.println(answers);
	}

	static int minimumDistance;
	static int n;
	static boolean[] v;
	static Position[] candidates;

	private static int getOptimalTotalDistance(List<Position> customers, Position house, Position enterprise) {
		minimumDistance = Integer.MAX_VALUE;
		n = customers.size();
		v = new boolean[n];
		candidates = new Position[n];
		Position[] candidates = new Position[n];
		for (int i = 0; i < customers.size(); i++) {
			candidates[0] = customers.get(i);
			pick(0, customers, house, enterprise);
		}

		return minimumDistance;
	}

	private static void pick(int cnt, List<Position> customers, Position house, Position enterprise) {
		if (cnt == n) {
			int distance = house.getDistance(candidates[0]);
			for (int i = 0; i < candidates.length - 1; i++) {
				int diff = candidates[i].getDistance(candidates[i + 1]);
				distance += diff;
			}
			distance += candidates[cnt - 1].getDistance(enterprise);
			minimumDistance = Math.min(distance, minimumDistance);

			return;
		}

		for (int i = 0; i < n; i++) {
			if (v[i])
				continue;

			v[i] = true;
			candidates[cnt] = customers.get(i);
			pick(cnt + 1, customers, house, enterprise);
			v[i] = false;
		}
	}
}

/**
3
5
0 0 100 100 70 40 30 10 10 5 90 70 50 20
6
88 81 85 80 19 22 31 15 27 29 30 10 20 26 5 14
10
39 9 97 61 35 93 62 64 96 39 36 36 9 59 59 96 61 7 64 43 43 58 1 36
 */