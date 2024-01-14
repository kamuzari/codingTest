package saffy.a형기출문제집;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class AttachPaper {
	private static final int PAPER_LIMIT = 5;
	private static final int MARKING = -1;
	private static final int EMPTY = 0;
	private static final int AVAILABLE = 1;
	private static final int N = 10;
	private static int[][] map;
	private static int answer = Integer.MAX_VALUE;
	private static Map<Integer, Integer> paperSizes;

	static {
		map = new int[N][N];
		paperSizes = new HashMap<>();
		for (int paperSize = 1; paperSize <= 5; paperSize++) {
			paperSizes.put(paperSize, PAPER_LIMIT);
		}
	}

	public static void main(String[] args) {
		requestInput();
		bruteforce(0, 0);
		if (answer == Integer.MAX_VALUE) {
			answer = -1;
		}
		System.out.println(answer);
	}

	public static void bruteforce(int depth, int usingCount) {
		if (depth == N * N) {
			answer = Math.min(answer, usingCount);
			return;
		}

		int ny = depth / N;
		int nx = depth % N;

		if (map[ny][nx] == EMPTY || map[ny][nx] == MARKING) {
			bruteforce(depth + 1, usingCount);
		} else if (map[ny][nx] == AVAILABLE) {
			for (Integer paperSize : paperSizes.keySet()) {
				if (isPossible(ny, nx, paperSize) && paperSizes.get(paperSize) > 0) {
					paperSizes.put(paperSize, paperSizes.get(paperSize) - 1);
					write(ny, nx, paperSize, MARKING);
					bruteforce(depth + 1, usingCount + 1);
					write(ny, nx, paperSize, AVAILABLE);
					paperSizes.put(paperSize, paperSizes.get(paperSize) + 1);
				}
			}
		}
	}

	private static void write(int y, int x, int paperSize, int writeValue) {
		for (int i = y; i < y + paperSize; i++) {
			for (int j = x; j < x + paperSize; j++) {
				map[i][j] = writeValue;
			}
		}
	}

	private static boolean isPossible(int y, int x, int paperSize) {
		for (int i = y; i < y + paperSize; i++) {
			for (int j = x; j < x + paperSize; j++) {

				if (isOutOfRang(i, j)) {
					return false;
				}
				if (map[i][j] != AVAILABLE) {
					return false;
				}
			}
		}

		return true;
	}

	private static boolean isOutOfRang(int ny, int nx) {
		return ny < 0 || nx < 0 || ny >= N || nx >= N;
	}

	private static void requestInput() {
		Scanner sc = new Scanner(System.in);
		boolean hasNotAvailableBlock = true;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(sc.nextLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				if (map[i][j] == AVAILABLE) {
					hasNotAvailableBlock = false;
				}
			}
		}

		if (hasNotAvailableBlock) {
			System.out.println(0);
			System.exit(0);
		}
	}
}
