package saffy.ssafy.homework.daily07;

import java.util.Scanner;
import java.util.StringTokenizer;

public class RunwayConstruction {
	static Scanner sc = new Scanner(System.in);
	static int n, m;
	static int[][] map, revMap;

	public static void main(String[] args) {
		int tc = Integer.parseInt(sc.nextLine());
		StringBuilder answer = new StringBuilder();
		for (int testCase = 1; testCase <= tc; testCase++) {
			int result = 0;
			StringTokenizer st = new StringTokenizer(sc.nextLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			map = new int[n][n];
			revMap = new int[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(sc.nextLine());
				for (int j = 0; j < n; j++) {
					revMap[j][i] = map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			result = build(map);
			result += build(revMap);

			answer.append("#").append(testCase).append(" ").append(result).append(System.lineSeparator());
		}

		System.out.println(answer);
	}

	static int build(int[][] arr) {
		int runwayCount = 0;
		for (int i = 0; i < n; i++) {
			boolean isBuild = true;
			boolean v[] = new boolean[n];
			for (int j = 1; j < n; j++) {

				boolean isSlope = arr[i][j - 1] != arr[i][j];
				if (!isSlope) {
					continue;
				}

				boolean isDownSlope = arr[i][j - 1] > arr[i][j];
				boolean isUpSlope = arr[i][j - 1] < arr[i][j];
				if (Math.abs(arr[i][j - 1] - arr[i][j]) != 1) {
					isBuild = false;
					break;
				}
				// 겹치는 것 생각해야함
				if (isDownSlope) {

					boolean isPossible = verifyDownSlope(i, j, arr, v);
					if (isPossible) {
						writeDownSlope(v, i, j);
						j += m - 1;
					} else {
						isBuild = false;
						break;
					}

				} else if (isUpSlope) {
					boolean isPossible = verifyUpSlope(i, j, arr, v);
					if (!isPossible) {
						isBuild = false;
						break;
					}

					if (isVisitedUpSlope(v, j)) {
						writeUpSlope(v, j);
					} else {
						isBuild = false;
						break;
					}

				}
			}

			if (isBuild) {
				runwayCount++;
			}
		}

		return runwayCount;
	}

	private static boolean isVisitedUpSlope(boolean[] v, int j) {
		for (int k = 1; k < m; k++) {
			int nx = j - k;

			if (v[nx]) {
				return false;
			}
		}

		return true;
	}

	private static void writeUpSlope(boolean[] v, int j) {
		for (int k = 1; k < m; k++) {
			int nx = j - k;
			v[nx] = true;
		}
	}

	private static boolean verifyUpSlope(int i, int j, int[][] map, boolean[] v) {
		for (int k = 1; k < m; k++) {
			int nx = j - k;
			boolean isOutOfIndex = nx < 0 || nx >= n;
			if (isOutOfIndex) {
				return false;
			}

			if (v[nx]) {
				return false;
			}

			boolean isNotFlat = map[i][j] != map[i][nx];
			if (isNotFlat) {
				return false;
			}
		}

		return true;
	}

	private static void writeDownSlope(boolean[] v, int i, int j) {
		for (int k = 1; k < m; k++) {
			int nx = k + j;
			v[nx] = true;
		}
	}

	private static boolean verifyDownSlope(int i, int j, int[][] map, boolean[] v) {
		for (int k = 1; k < m; k++) {
			int nx = k + j;
			boolean isOutOfIndex = nx < 0 || nx >= n;
			if (isOutOfIndex) {
				return false;
			}

			boolean isNotFlat = map[i][j] != map[i][nx];
			if (isNotFlat) {
				return false;
			}
		}

		return true;
	}
}

