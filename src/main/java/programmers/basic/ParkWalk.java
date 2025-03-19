package programmers.basic;

import java.util.HashMap;
import java.util.Map;

public class ParkWalk {
	static Map<String, int[]> dirs;

	static {
		dirs = new HashMap<>();
		dirs.put("N", new int[] {-1, 0});
		dirs.put("S", new int[] {1, 0});
		dirs.put("W", new int[] {0, -1});
		dirs.put("E", new int[] {0, 1});
	}

	public int[] solution(String[] park, String[] routes) {
		int n = park.length;
		int m = park[0].length();
		char[][] board = new char[n][m];
		for (int i = 0; i < n; i++) {
			board[i] = park[i].toCharArray();
		}

		int[] starts = getStart(board);
		for (String r : routes) {
			String[] s = r.split(" ");
			String d = s[0];
			int dist = Integer.parseInt(s[1]);

			boolean isGo = true;
			int ny = starts[0];
			int nx = starts[1];
			int[] dir = dirs.get(d);
			while (dist-- > 0) {
				ny += dir[0];
				nx += dir[1];

				boolean isOutOfRange = ny < 0 || nx < 0 || ny >= n || nx >= m;
				if (isOutOfRange || board[ny][nx] == 'X') {
					isGo = false;
					break;
				}
			}

			if (isGo) {
				starts = new int[] {ny, nx};
			}
		}

		return starts;
	}

	int[] getStart(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == 'S') {
					return new int[] {i, j};
				}
			}
		}

		throw new IllegalArgumentException("문제 입력 오류입니다.");
	}
}
