package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SetEqualInSumRefactoring2 {

	private static int[] positives;
	private static int n;
	private static boolean isTerminate = false;
	private static String answer = "NO";
	private static int totalSummary;

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(reader.readLine());

		positives = new int[n];
		StringTokenizer st = new StringTokenizer(reader.readLine());

		for (int i = 0; i < n; i++) {
			positives[i] = Integer.parseInt(st.nextToken());
		}

		totalSummary = Arrays.stream(positives).sum();

		dfs(0, 0);

		System.out.println(answer);
	}

	/**
	 * @param level: 재귀 깊이 밑 해당 배열의 인덱스
	 * @param partialSummary: 재귀 깊이까지의 현재 총합
	 */
	private static void dfs(int level, int partialSummary) {
		if (isTerminate) {
			// note: early return 용
			return;
		}

		if (level == n) {
			if (totalSummary - partialSummary == partialSummary) {
				answer = "YES";
				isTerminate = true;
			}

			return;
		} else {
			// 트리 형식의 재귀
			dfs(level + 1, partialSummary + positives[level]); // 해당 level index 선택 O
			dfs(level + 1, partialSummary); // 해당 level index 선택 x
		}
	}
}
