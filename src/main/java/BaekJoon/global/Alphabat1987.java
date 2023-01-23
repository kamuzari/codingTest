package BaekJoon.global;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Alphabat1987 {
	private static int answer = 0;
	private static int[] dy = {-1, 1, 0, 0};
	private static int[] dx = {0, 0, -1, 1};
	private static char[][] b;
	private static int r;
	private static int c;

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

		r = Integer.parseInt(tokenizer.nextToken());
		c = Integer.parseInt(tokenizer.nextToken());

		b = new char[r][c];

		for (int i = 0; i < r; i++) {
			b[i] = reader.readLine().toCharArray();
		}

		Set<Character> pasts = new HashSet<>();

		go(0, 0, pasts, 0);

		System.out.println(answer);
	}

	private static void go(int y, int x, Set<Character> pasts, int count) {
		answer = Math.max(answer, count);
		for (int i = 0; i < 4; i++) {
			int ny = dy[i] + y;
			int nx = dx[i] + x;

			if (isOutOfIndex(y, x)) {
				return;
			}

			if (pasts.contains(b[y][x])) {
				return;
			}

			pasts.add(b[y][x]);
			go(ny, nx, pasts, count + 1);
			pasts.remove(b[y][x]);
		}

	}

	private static boolean isOutOfIndex(int y, int x) {
		return y < 0 || x < 0 || y >= r || x >= c;
	}
}
