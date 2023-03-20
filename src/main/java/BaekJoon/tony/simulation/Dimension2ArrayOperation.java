package BaekJoon.tony.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Dimension2ArrayOperation {
	static class Node implements Comparable<Node> {
		private int val;
		private int cnt;

		public Node(int val, int cnt) {
			this.val = val;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Node o) {
			if (this.cnt == o.cnt) {
				return this.val - o.val;
			}

			return this.cnt - o.cnt;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(reader.readLine());

		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int arr[][] = new int[3][3];

		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(reader.readLine());
			for (int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int tryCnt = 0;
		while (tryCnt <= 100) {

			if (r-1 < arr.length && c-1 < arr[0].length) {
				if (arr[r-1][c-1] == k) {
					break;
				}
			}
			int row = arr.length;
			int col = arr[0].length;
			int temp[][] = new int[101][101];
			if (row >= col) { // 행 재배열
				int maxCol = 0; // 최대 나올 수 있는 열의 수
				for (int i = 0; i < row; i++) {
					Map<Integer, Integer> counts = new HashMap<>();

					for (int j = 0; j < col; j++) {
						int val = arr[i][j];
						if (val == 0)
							continue;

						counts.put(val, counts.getOrDefault(val, 0) + 1);
					}

					List<Node> nodes = toSortedList(counts);

					int idx = 0;
					// 최대 100개 넘어가면 버려야 함.
					for (int j = 0; j < Math.min(nodes.size(), 50); j++) {
						temp[i][idx] = nodes.get(j).val;
						temp[i][idx + 1] = nodes.get(j).cnt;

						idx += 2;
					}

					maxCol = Math.max(maxCol, nodes.size() * 2);
				}

				// 나머지 버린다.
				maxCol = Math.min(maxCol, 100);
				// 새로운 배열 탄생
				arr = new int[row][maxCol];
				toCopy(arr, temp);
			} else {
				// 열 재배열
				int maxRow = 0; // 최대 나올 수 있는 행의 수
				for (int i = 0; i < col; i++) {
					Map<Integer, Integer> counts = new HashMap<>();

					for (int j = 0; j < row; j++) {
						int val = arr[j][i];
						if (val == 0)
							continue;

						counts.put(val, counts.getOrDefault(val, 0) + 1);
					}

					List<Node> nodes = toSortedList(counts);

					int idx = 0;
					// 최대 100개 넘어가면 버려야 함.
					for (int j = 0; j < Math.min(nodes.size(), 50); j++) {
						temp[idx][i] = nodes.get(j).val;
						temp[idx + 1][i] = nodes.get(j).cnt;

						idx += 2;
					}

					maxRow = Math.max(maxRow, nodes.size() * 2);
				}
				// 100넘어가는 rowSize 버리기
				maxRow = Math.min(maxRow, 100);
				// 새로운 배열의 탄생
				arr=new int[maxRow][col];
				toCopy(arr,temp);
			}

			tryCnt++;
		}

		System.out.println(tryCnt > 100 ? -1 : tryCnt);
	}

	private static List<Node> toSortedList(Map<Integer, Integer> counts) {
		return counts.entrySet().stream()
			.map(entry -> new Node(entry.getKey(), entry.getValue()))
			.sorted()
			.collect(Collectors.toList());
	}

	private static void toCopy(int[][] arr, int[][] temp) {
		// 배열의 크기가 temp는 무조건 행열이 101이라 clone 하면 안댐.
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				arr[i][j]=temp[i][j];
			}
		}
	}
}
