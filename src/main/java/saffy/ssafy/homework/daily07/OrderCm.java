package saffy.ssafy.homework.daily07;

import java.util.Scanner;
import java.util.StringTokenizer;

public class OrderCm {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int tc = Integer.parseInt(sc.nextLine());
		StringBuilder answer = new StringBuilder();
		for (int testCase = 1; testCase <= tc; testCase++) {
			int n = Integer.parseInt(sc.nextLine());
			int m = Integer.parseInt(sc.nextLine());
			boolean[][] isConnect = new boolean[n + 1][n + 1];
			boolean[][] isReverseConnect = new boolean[n + 1][n + 1];
			for (int i = 0; i < m; i++) {
				StringTokenizer st = new StringTokenizer(sc.nextLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				isConnect[from][to] = true;
				isReverseConnect[to][from] = true;
			}

			for (int k = 1; k <= n; k++) {
				for (int i = 0; i <= n; i++) {
					for (int j = 0; j <= n; j++) {
						if (i == j || j == k || i == k)
							continue;
						if (isConnect[i][k] && isConnect[k][j]) {
							isConnect[i][j] = true;
						}

						if (isReverseConnect[i][k] && isReverseConnect[k][j]) {
							isReverseConnect[i][j] = true;
						}
					}
				}
			}

			int decidedVertex = 0;
			for (int i = 1; i <= n; i++) {
				boolean isDecide = true;
				for (int j = 1; j <= n; j++) {
					if (i == j)
						continue;
					if (!isReverseConnect[i][j] && !isConnect[i][j]) {
						isDecide = false;
						break;
					}
				}

				if (isDecide) {
					decidedVertex++;
				}
			}
			answer.append("#")
				.append(testCase)
				.append(" ")
				.append(decidedVertex)
				.append(System.lineSeparator());
		}
		System.out.println(answer);
	}
}
