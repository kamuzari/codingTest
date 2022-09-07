package programmers.mockquestions.bundle32;

public class KeepDistanceBfs {

	/**
	 * note : bfs 풀이
	 * @param places
	 * @return
	 */
	public int[] solution(String[][] places) {
		int[] answer = new int[places.length];
		for (int i = 0; i < places.length; i++) {
			char map[][] = new char[places[i].length][places[i][0].length()];
			for (int j = 0; j < places[i].length; j++) {
				map[j] = places[i][j].toCharArray();
			}

			if (check(map)) {
				answer[i] = 1;
			} else {
				answer[i] = 0;
			}
		}
		return answer;
	}

	public boolean check(char map[][]) {
		int n = map.length;
		int m = map[0].length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 'P') {
					boolean disCheck = bfs(i, j, map, n, m);
					if (!disCheck)
						return false;
				}
			}
		}
		return true;
	}

	// 5 11 13 16 : false ->  o p 예외 -> (0,1), (1,0) 서로 거리두기 안지켜져있는데 검사 못한 그러므모  -1,1 dy,dx 추가
 	//                        p x
	int dy[] = {1, 0, 2, 0, 1, -1};
	int dx[] = {0, 1, 0, 2, 1, 1};

	public boolean bfs(int y, int x, char map[][], int n, int m) {
		for (int i = 0; i < 6; i++) {
			int ny = dy[i] + y;
			int nx = dx[i] + x;
			if (indexOutOf(ny, nx, n, m))
				continue;
			if (i < 2) {
				if (map[ny][nx] == 'P')
					return false;
			} else {
				if (map[ny][nx] != 'P')
					continue;
				if (i == 2) {
					if (map[ny - 1][nx] != 'X')
						return false;
				} else if (i == 3) {
					if (map[ny][nx - 1] != 'X')
						return false;
				} else {
					if (map[ny][x] != 'X' || map[y][nx] != 'X')
						return false;
				}
			}
		}
		return true;
	}

	static boolean indexOutOf(int ny, int nx, int n, int m) {
		return ny < 0 || nx < 0 || ny > n - 1 || nx > m - 1;
	}
}
