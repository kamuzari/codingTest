package BaekJoon.tony.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PaperPiece {
	static int n, m, answer;
	static int[][] paper;
	static boolean[][] v;

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(reader.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		paper = new int[n][m];
		v = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			String str[] = reader.readLine().split("");
			for (int j = 0; j < m; j++) {
				paper[i][j] = Integer.parseInt(str[j]);
			}
		}

		dfs(0,0);

		System.out.println(answer);
	}

	private static void dfs(int y, int x) {
		if (y >= n) { // 배열 탐색 완료
			answer = Math.max(answer, sum());
			return;
		}

		if (x >= m) { // 열의 끝에 도달했을 때 다음 행으로
			dfs(y + 1, 0);
			return;
		}

		v[y][x] = true;
		dfs(y, x + 1);
		v[y][x] = false;

		dfs(y, x + 1);
	}

	private static int sum() {
		int answer = 0;
		int temp = 0;

		for (int i = 0; i < n; i++) {
			temp = 0;
			for (int j = 0; j < m; j++) {
				if (v[i][j]) {
					temp *= 10;
					temp += paper[i][j];
				} else {
					answer += temp;
					temp = 0;
				}
			}

			answer += temp;
		}

		for (int i = 0; i < m; i++) {
			temp = 0;
			for (int j = 0; j < n; j++) {
				if (!v[j][i]) {
					temp *= 10;
					temp += paper[j][i];
				} else {
					answer += temp;
					temp = 0;
				}
			}

			answer+=temp;
		}

		return answer;
	}
}
