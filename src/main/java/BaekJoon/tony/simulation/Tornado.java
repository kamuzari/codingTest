package BaekJoon.tony.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;

public class Tornado {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[][] map = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(reader.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(solution(n, map));
	}

	static int ty[] = {0, 1, 0, -1};
	static int tx[] = {-1, 0, 1, 0};

	// 태풍 방향이랑 확산 맞쳐줌.
	static Map<Integer, int[][]> spreads = Map.of(
		0, new int[][] {
			{-1, 1, 1},
			{1, 1, 1},
			{-2, 0, 2},
			{2, 0, 2},
			{0, -2, 5},
			{-1, 0, 7},
			{1, 0, 7},
			{-1, -1, 10},
			{1, -1, 10}
		},

		1, new int[][] {
			{-1, -1, 1},
			{-1, 1, 1},
			{0, -2, 2},
			{0, 2, 2},
			{2, 0, 5},
			{0, 1, 7},
			{0, -1, 7},
			{1, -1, 10},
			{1, 1, 10}
		},

		2, new int[][] {
			{1, -1, 1},
			{-1, -1, 1},
			{2, 0, 2},
			{-2, 0, 2},
			{0, 2, 5},
			{1, 0, 7},
			{-1, 0, 7},
			{-1, 1, 10},
			{1, 1, 10}
		},
		3, new int[][] {
			{1, -1, 1},
			{1, 1, 1},
			{0, -2, 2},
			{0, 2, 2},
			{-2, 0, 5},
			{0, -1, 7},
			{0, 1, 7},
			{-1, -1, 10},
			{-1, 1, 10}
		}
	);

	static int N;

	static int solution(int n, int[][] map) {
		int answer = 0;
		N = n;
		int sy = n / 2;
		int sx = n / 2;
		int size = 1;
		while (true) {

			// 토에이도 방향
			// 이동하고난 y의 모래의 양은 어ㄸ
			for (int dir = 0; dir < 4; dir++) {
				int repeat = size;
				while (repeat-- > 0) {
					sy += ty[dir];
					sx += tx[dir];

					if (isOutOfRange(sy, sx)) {
						return answer;
					}

					int sand = map[sy][sx];
					map[sy][sx] = 0;
					int totalSpread = 0;
					// 확산
					for (int[] spread : spreads.get(dir)) {
						int ny = sy + spread[0];
						int nx = sx + spread[1];
						int spreadAmount = (sand * spread[2]) / 100;

						if (isOutOfRange(ny, nx)) {
							answer += spreadAmount;
						} else {
							map[ny][nx] += spreadAmount;
						}

						totalSpread += spreadAmount;
					}

					int alphaY = sy + ty[dir];
					int alphaX = sx + tx[dir];
					int alphaAmount = sand - totalSpread;
					if (isOutOfRange(alphaY, alphaX)) {
						answer += alphaAmount;
					} else {
						map[alphaY][alphaX] += alphaAmount;
					}
				}

				if (dir == 1 || dir == 3) {
					size++;
				}
			}

		}
	}

	static boolean isOutOfRange(int ny, int nx) {
		return ny < 0 || nx < 0 || ny >= N || nx >= N;
	}
}
