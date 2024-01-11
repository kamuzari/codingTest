package saffy.sample_a;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ConnectingProcessor {
	private static class Node {
		private int y;
		private int x;

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	private static int[][] map;
	private static int n;
	private static List<Node> processors;
	private static int answerCore;
	private static int answerLine;
	private static int dy[] = {-1, 1, 0, 0};
	private static int dx[] = {0, 0, -1, 1};

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int totalInputCount = toInt(sc.nextLine());
		StringBuilder answers = new StringBuilder();

		for (int testCase = 1; testCase <= totalInputCount; testCase++) {
			n = toInt(sc.nextLine());
			map = new int[n][n];
			processors = new ArrayList<>();
			for (int row = 0; row < n; row++) {
				StringTokenizer st = new StringTokenizer(sc.nextLine());
				for (int col = 0; col < n; col++) {
					map[row][col] = toInt(st.nextToken());

					boolean isEdgePosition = row == 0 || row == n - 1 || col == 0 || col == n - 1;
					if (isEdgePosition)
						continue;

					if (map[row][col] == 1) {
						processors.add(new Node(row, col));
					}
				}
			}

			answerCore = 0;
			answerLine = Integer.MAX_VALUE;

			pick(0, 0, 0);
			String answer = String.format("#%d %d", testCase, answerLine);
			answers.append(answer).append(System.lineSeparator());
		}

		System.out.println(answers);
	}

	private static void pick(int depth, int coreCount, int installedLineCount) {
		if (depth == processors.size()) {
			if (answerCore < coreCount) {
				answerCore = coreCount;
				answerLine = installedLineCount;
			} else if (answerCore == coreCount) {
				answerLine = Math.min(answerLine, installedLineCount);
			}

			return;
		}

		for (int direction = 0; direction < 4; direction++) {
			Node processor = processors.get(depth);

			if (canInstall(processor, direction)) {
				int fillCount = fill(processor, direction, 2);
				pick(depth + 1, coreCount + 1, installedLineCount + fillCount);
				fill(processor, direction, 0);
			}

		}

		pick(depth + 1, coreCount, installedLineCount);
	}

	private static boolean canInstall(Node start, int direction) {
		int ny = start.y;
		int nx = start.x;

		while (true) {
			ny += dy[direction];
			nx += dx[direction];

			if (isOutOfIndex(ny, nx))
				break;

			boolean isOverLap = map[ny][nx] != 0;
			if (isOverLap) {
				return false;
			}
		}

		return true;

	}

	private static int fill(Node start, int direction, int value) {
		int fillCount = 0;

		int ny = start.y;
		int nx = start.x;

		while (true) {
			ny += dy[direction];
			nx += dx[direction];

			if (isOutOfIndex(ny, nx))
				break;

			map[ny][nx] = value;
			fillCount++;
		}

		return fillCount;
	}

	private static void restorer(Node start, int direction) {

		int ny = start.y;
		int nx = start.x;

		while (true) {
			ny += dy[direction];
			nx += dx[direction];

			if (isOutOfIndex(ny, nx))
				break;

			map[ny][nx] = 0;
		}
	}

	private static boolean isOutOfIndex(int ny, int nx) {
		return ny < 0 || nx < 0 || ny >= n || nx >= n;
	}

	private static int toInt(String s) {
		return Integer.parseInt(s);
	}
}
