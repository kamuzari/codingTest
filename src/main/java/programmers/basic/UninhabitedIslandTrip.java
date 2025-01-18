package programmers.basic;

import java.util.ArrayList;
import java.util.List;

public class UninhabitedIslandTrip {

	int n, m;
	char[][] board;
	boolean[][] v;

	public int[] solution(String[] maps) {
		n = maps.length;
		m = maps[0].length();
		board = new char[n][m];
		v = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			board[i] = maps[i].toCharArray();
		}

		List<Integer> answers = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {

				if (Character.isDigit(board[i][j]) && !v[i][j]) {
					summary = 0;
					write(i, j);
					answers.add(summary);
				}
			}
		}

		if (answers.isEmpty()) {
			return new int[] {-1};
		}

		return answers.stream().sorted().mapToInt(v -> v).toArray();
	}

	int dy[] = {-1, 1, 0, 0};
	int dx[] = {0, 0, -1, 1};
	int summary;

	void write(int y, int x) {
		summary += board[y][x] - '0';
		v[y][x] = true;

		for (int i = 0; i < 4; i++) {
			int ny = dy[i] + y;
			int nx = dx[i] + x;

			if (isOutOf(ny, nx))
				continue;
			if (v[ny][nx])
				continue;
			if (!Character.isDigit(board[ny][nx]))
				continue;

			write(ny, nx);
		}
	}

	boolean isOutOf(int y, int x) {
		return y < 0 || x < 0 || y >= n || x >= m;
	}
}
