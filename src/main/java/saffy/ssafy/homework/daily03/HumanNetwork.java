package saffy.ssafy.homework.daily03;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class HumanNetwork {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int tc = Integer.parseInt(sc.nextLine());
		StringBuilder answer = new StringBuilder();

		for (int testCase = 1; testCase <= tc; testCase++) {
			StringTokenizer st = new StringTokenizer(sc.nextLine());
			int n = Integer.parseInt(st.nextToken());
			int[][] graph = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					graph[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int k = 0; k < n; k++) {
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						if (i == j)
							continue;
						if (graph[i][k] > 0 && graph[k][j] > 0) {
							if (graph[i][j] == 0) {
								graph[i][j] = graph[i][k] + graph[k][j];
							} else {
								graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
							}
						}
					}
				}
			}

			int minAnswer = Integer.MAX_VALUE;
			for (int i = 0; i < n; i++) {
				int distance = Arrays.stream(graph[i]).filter(v -> v != 0).sum();
				minAnswer = Math.min(minAnswer, distance);
			}
			
			answer
				.append("#")
				.append(testCase)
				.append(" ")
				.append(minAnswer)
				.append(System.lineSeparator());
		}

		System.out.println(answer);

	}
}
