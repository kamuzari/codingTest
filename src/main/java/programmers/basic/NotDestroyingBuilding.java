package programmers.basic;

public class NotDestroyingBuilding {
	public int solution(int[][] board, int[][] skill) {
		int answer = 0;
		int n = board.length;
		int m = board[0].length;

		int[][] range = new int[n + 1][m + 1];

		for (int[] effect : skill) {
			int type = effect[0];
			int r1 = effect[1];
			int c1 = effect[2];
			int r2 = effect[3];
			int c2 = effect[4];
			int degree = effect[5];
			if (type == 1) {
				degree *= -1;
			}

			range[r1][c1] += degree;
			range[r1][c2 + 1] += (degree * -1);
			range[r2 + 1][c1] += (degree * -1);
			range[r2 + 1][c2 + 1] += degree;
		}

		for (int i = 0; i < n; i++) {
			for (int j = 1; j < m; j++) {
				range[i][j] += range[i][j - 1];
			}
		}

		for (int j = 0; j < m; j++) {
			for (int i = 1; i < n; i++) {
				range[i][j] += range[i - 1][j];
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (board[i][j] + range[i][j] > 0) {
					answer++;
				}
			}
		}

		return answer;
	}
}
