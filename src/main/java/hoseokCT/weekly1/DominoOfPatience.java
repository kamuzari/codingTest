package hoseokCT.weekly1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class DominoOfPatience {

	/**
	 * note : 모지? 3번째 명령어에서 5,2를 북쪽으로 밀었는데 ..?
	 *  - 쓰러진 도미노가 중간에 있는데 뚫고가는 경우는 모지?
	 * resolve : 시물레이션은 문제를 잘읽고 해야한다..
	 */
	private static int n;
	private static int[][] map;
	private static boolean[][] isFallen;
	private static int m;

	enum Command {
		N(-1, 0),
		S(1, 0),
		W(0, -1),
		E(0, 1);

		private int y, x;

		Command(int y, int x) {
			this.y = y;
			this.x = x;
		}

		public static Command of(String cmd) {
			return Arrays.stream(Command.values())
				.filter(command -> command.name().equals(cmd))
				.findFirst()
				.orElseThrow(() -> new RuntimeException("command error"));
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

		n = Integer.parseInt(tokenizer.nextToken());
		m = Integer.parseInt(tokenizer.nextToken());
		int r = Integer.parseInt(tokenizer.nextToken());

		map = new int[n][m];
		isFallen = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			tokenizer = new StringTokenizer(reader.readLine());

			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(tokenizer.nextToken());
			}
		}

		int fallingCount = 0;

		for (int round = 1; round <= 2 * r; round++) {
			tokenizer = new StringTokenizer(reader.readLine());
			int y = Integer.parseInt(tokenizer.nextToken()) - 1;
			int x = Integer.parseInt(tokenizer.nextToken()) - 1;

			if (round % 2 == 1) {
				Command command = Command.of(tokenizer.nextToken());
				fallingCount += go(y, x, command);
			} else {
				isFallen[y][x] = false;
			}
		}

		System.out.println(fallingCount);

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (isFallen[i][j]) {
					System.out.print("F ");
				} else {
					System.out.print("S ");
				}
			}
			System.out.println();
		}
	}

	static class Node {
		private int y, x;

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	private static int go(int y, int x, Command command) {
		if (isFallen[y][x]) {
			return 0;
		}

		isFallen[y][x] = true;
		int count = 1;
		LinkedList<Node> q = new LinkedList<>();

		q.offer(new Node(y, x));

		while (!q.isEmpty()) {
			Node cur = q.poll();

			int height = map[cur.y][cur.x];
			int ny = cur.y;
			int nx = cur.x;

			for (int i = 1; i < height; i++) {
				ny += command.y;
				nx += command.x;

				if (isOutOfIndex(ny, nx)) {
					break;
				}

				if (isFallen[ny][nx]) {
					continue;
				}
				count++;
				isFallen[ny][nx] = true;
				q.offer(new Node(ny, nx));
			}
		}

		return count;
	}

	private static boolean isOutOfIndex(int ny, int nx) {
		return ny < 0 || nx < 0 || ny >= n || nx >= m;
	}

}
