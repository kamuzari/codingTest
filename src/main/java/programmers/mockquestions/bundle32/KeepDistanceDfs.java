package programmers.mockquestions.bundle32;

import java.util.Arrays;

public class KeepDistanceDfs {
	public static void main(String[] args) {
		String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
			{"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
			{"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};

		String[][] places2 = {{"OP"}, {"PO", "XP"}, {"O"}, {"PX"}, {"X"}, {"OOOO", "OOOO"},
			{"OOPOO", "OPOOO", "OOOOO", "OOOOO", "OOOOO"}};

		String[][] places3 = {{"PO", "XP"}};

		KeepDistanceDfs keepDistanceDfs = new KeepDistanceDfs();
		int[] solution = keepDistanceDfs.solution(places2);
		System.out.println(Arrays.toString(solution));
	}

	int[] answer;
	boolean[][] v;
	private int n;
	private int m;

	public int[] solution(String[][] places) {
		answer = new int[places.length];

		Arrays.fill(answer, 1);

		for (int totalCnt = 0; totalCnt < places.length; totalCnt++) {
			n = places[totalCnt].length;
			m = places[totalCnt][0].length();

			v = new boolean[n][m];
			char map[][] = new char[n][m];

			for (int i = 0; i < n; i++) {
				map[i] = places[totalCnt][i].toCharArray();
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (map[i][j] == 'P') {
						v[i][j] = true;
						dfs(totalCnt, map, i, j, 0);
						v[i][j] = false;
					}
				}
			}
		}

		return answer;
	}

	int dy[] = {-1, 1, 0, 0};
	int dx[] = {0, 0, -1, 1};

	private void dfs(int cnt, char[][] map, int y, int x, int dist) {
		if (dist > 2)
			return;

		if (dist == 1 || dist == 2) {
			if (map[y][x] == 'P') {
				answer[cnt] = 0;

				return;
			}
		}

		for (int i = 0; i < 4; i++) {
			int ny = dy[i] + y;
			int nx = dx[i] + x;

			if (isOutOf(ny, nx))
				continue;

			if(map[ny][nx]=='X') continue;

			if(v[ny][nx]) continue;

			v[ny][nx] = true;
			dfs(cnt, map, ny, nx, dist + 1);
			v[ny][nx] = false;
		}
	}

	public boolean isOutOf(int ny, int nx) {
		return ny < 0 || nx < 0 || ny > n - 1 || nx > m - 1;
	}

}
