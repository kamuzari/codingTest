package programmers.basic;

public class SearchBigSquare {
	public int solution(int[][] board) {
		int answer = 0;
		int n = board.length;
		int m = board[0].length;

		int[][] squareSizes = new int[n + 1][m + 1];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				squareSizes[i + 1][j + 1] = board[i][j];
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++)
				if (squareSizes[i][j] == 1) {
					int left = squareSizes[i][j - 1];
					int up = squareSizes[i - 1][j];
					int cross = squareSizes[i - 1][j - 1];

					squareSizes[i][j] += Math.min(Math.min(left, up), Math.min(up, cross));
					answer = Math.max(answer, squareSizes[i][j]);
				}
		}

		return answer * answer;
	}
}
