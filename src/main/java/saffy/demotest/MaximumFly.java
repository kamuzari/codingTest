package saffy.demotest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MaximumFly {
	static class DistanceVector {
		String name;
		private int y;
		private int x;

		public DistanceVector(String name, int y, int x) {
			this.name = name;
			this.y = y;
			this.x = x;
		}
	}

	static Scanner sc = new Scanner(System.in);
	static List<DistanceVector> plusDirections = new ArrayList<>();
	static List<DistanceVector> xDirections = new ArrayList<>();

	static {
		plusDirections.add(new DistanceVector("북쪽", -1, 0));
		plusDirections.add(new DistanceVector("남쪽", 1, 0));
		plusDirections.add(new DistanceVector("서쪽", 0, -1));
		plusDirections.add(new DistanceVector("동쪽", 0, 1));

		xDirections.add(new DistanceVector("북서쪽", -1, -1));
		xDirections.add(new DistanceVector("북동쪽", -1, 1));
		xDirections.add(new DistanceVector("남서쪽", 1, -1));
		xDirections.add(new DistanceVector("남동쪽", 1, 1));
	}

	public static void main(String[] args) {
		StringBuilder answers = new StringBuilder();
		int repeatCount = toInt(sc.nextLine());

		for (int testCase = 1; testCase <= repeatCount; testCase++) {
			StringTokenizer st = new StringTokenizer(sc.nextLine());
			int gridSize = toInt(st.nextToken());
			int power = toInt(st.nextToken());

			int[][] grid = new int[gridSize][gridSize];
			for (int i = 0; i < gridSize; i++) {
				st = new StringTokenizer(sc.nextLine());

				for (int j = 0; j < gridSize; j++) {
					grid[i][j] = toInt(st.nextToken());
				}
			}

			int result = 0;
			for (int i = 0; i < gridSize; i++) {
				for (int j = 0; j < gridSize; j++) {
					int deadFly = spray(i, j, grid, power);
					result = Math.max(deadFly, result);
				}
			}

			String answer = String.format("#%d %d", testCase, result);
			answers.append(answer).append(System.lineSeparator());
		}

		System.out.println(answers);
	}

	private static int spray(int y, int x, int[][] grid, int power) {
		int deadCount = countDeadFly(y, x, grid, power, plusDirections);

		return Math.max(deadCount, countDeadFly(y, x, grid, power, xDirections));
	}

	private static int countDeadFly(int y, int x, int[][] grid, int power, List<DistanceVector> directionPattern) {
		int flyDeadCount = grid[y][x];

		for (DistanceVector direction : directionPattern) {
			int curY = y;
			int curX = x;
			for (int i = 1; i < power; i++) {
				int ny = curY + direction.y;
				int nx = curX + direction.x;

				if (isOutOfIndex(ny, nx, grid.length, grid[0].length))
					break;

				flyDeadCount += grid[ny][nx];
				curY = ny;
				curX = nx;
			}
		}

		return flyDeadCount;
	}

	private static boolean isOutOfIndex(int ny, int nx, int limitY, int limitX) {
		return ny < 0 || nx < 0 || ny >= limitY || nx >= limitX;
	}

	private static int toInt(String s) {
		return Integer.parseInt(s);
	}
}
