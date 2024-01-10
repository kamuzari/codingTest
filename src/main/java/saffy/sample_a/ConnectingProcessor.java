package saffy.sample_a;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ConnectingProcessor {
	private static class Processor {
		private int y;
		private int x;

		public Processor(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	private static int cellSize;
	private static int[][] cells;
	private static List<Processor> processors;
	private static int[] pickedDirections;
	private static int dy[] = {-1, 1, 0, 0};
	private static int dx[] = {0, 0, -1, 1};
	private static int minimumElectronicLine = Integer.MAX_VALUE;

	private static final int TRACE = 2;
	private static final int EDGE_PROCESSOR_POSITION = -1;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int repeatCount = Integer.parseInt(sc.nextLine());
		StringBuilder answers = new StringBuilder();
		for (int testCase = 1; testCase <= repeatCount; testCase++) {
			cellSize = toInt(sc.nextLine());
			cells = new int[cellSize][cellSize];
			minimumElectronicLine=Integer.MAX_VALUE;
			processors = new ArrayList<>();
			pickedDirections = new int[processors.size()];
			for (int row = 0; row < cellSize; row++) {
				StringTokenizer st = new StringTokenizer(sc.nextLine());
				for (int col = 0; col < cellSize; col++) {
					cells[row][col] = toInt(st.nextToken());
					boolean isEdge = row == 0 || row == cellSize - 1 || col == 0 || col == cellSize - 1;
					if (cells[row][col] == 1 && isEdge) {
						cells[row][col] = EDGE_PROCESSOR_POSITION;
					}

					if (cells[row][col] == 1) {
						processors.add(new Processor(row, col));
					}
				}
			}

			pickedDirections = new int[processors.size()];
			solve();
			answers.append("#")
					.append(testCase)
					.append(" ")
					.append(minimumElectronicLine)
					.append(System.lineSeparator());
		}
		System.out.println(answers);
	}

	private static void solve() {
		pick(0);
	}

	private static void pick(int cnt) {
		if (cnt == processors.size()) {
			// 해당 방향 겹치는 지 판단 그리고 길이 제기
			List<Processor> rollbacks = new ArrayList<>();
			List<Processor> starts = new ArrayList<>();
			for (int i = 0; i < processors.size(); i++) {
				Processor copyProcessor = new Processor(processors.get(i).y, processors.get(i).x);
				Queue<Processor> q = new LinkedList<>();
				q.offer(copyProcessor);
				cells[copyProcessor.y][copyProcessor.x] = TRACE;
				starts.add(copyProcessor);
				int directionIndex = pickedDirections[i];
				while (!q.isEmpty()) {
					Processor cur = q.poll();

					int ny = dy[directionIndex] + cur.y;
					int nx = dx[directionIndex] + cur.x;

					if (isOutOfIndex(ny, nx)) {
						break;
					}

					boolean isOverLap = cells[ny][nx] == TRACE;
					if (cells[ny][nx] == 1 || cells[ny][nx] == EDGE_PROCESSOR_POSITION || isOverLap) {
						// 못간다. 다른 방향을 강구해야함;
						restoreCells(rollbacks, starts);
						return;
					}

					cells[ny][nx] = TRACE;
					q.offer(new Processor(ny, nx));
					rollbacks.add(new Processor(ny, nx));
				}
			}

			int totalLength = rollbacks.size();
			minimumElectronicLine = Math.min(minimumElectronicLine, totalLength);
			restoreCells(rollbacks,starts);
			return;
		}

		for (int i = 0; i < dy.length; i++) {
			pickedDirections[cnt] = i;
			pick(cnt + 1);
		}
	}

	private static void restoreCells(List<Processor> rollbacks, List<Processor> starts) {
		rollbacks.forEach(processor -> cells[processor.y][processor.x] = 0);
		starts.forEach(processor -> cells[processor.y][processor.x] = 1);
	}

	private static boolean isOutOfIndex(int ny, int nx) {
		return ny < 0 || nx < 0 || ny >= cellSize || nx >= cellSize;
	}

	private static int toInt(String s) {
		return Integer.parseInt(s);
	}
}
