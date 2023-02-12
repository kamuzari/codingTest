package BaekJoon.related;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class cheese {

	static final int CHEESE = 1;
	static int n;
	static int m;
	static int[][] map;
	static int dy[] = {-1, 1, 0, 0};
	static int dx[] = {0, 0, -1, 1};

	/**
	 * n,m: 격자의 행열
	 * map: 격자 상태
	 *
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

		n = Integer.parseInt(tokenizer.nextToken());
		m = Integer.parseInt(tokenizer.nextToken());
		map = new int[n][m];

		for (int i = 0; i < n; i++) {
			tokenizer = new StringTokenizer(reader.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(tokenizer.nextToken());
			}
		}

		int[] answer = solution();

		System.out.println(answer[0]);
		System.out.println(answer[1]);
	}

	static class Node {
		int y;
		int x;

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	/**
	 * map
	 *  - 1: 치즈
	 *  - 0: 공기
	 * note: 공기랑 접촉된 치즈는 시간 단위로 녹는다.
	 *   - 치즈가 공기면이랑 닿았있음을 어떻게 코드로 표현하는지 모르겠음.
	 * hint: 판의 가장가지에는 치즈가 놓여있지 않으며 -> 가장자리는 무조건 치즈가 존재할 수 없음을 의미
	 *  - 그래서 0,0애서 출발하여 1이 보이는 곳은 모두 녹아 없어지는 공간이라는 것을 파악 할 수 있다.
	 * 유의사항 :
	 *  - 한번에 다 녹는 경우를 처리해줘야 한다.
	 * @return [모든 치즈가 녹아서 없어지는 시간, 모두 녹기 한시간 전 치즈의 개수]
	 */
	public static int[] solution() {
		int[] answer = new int[2];
		int cheeseCnt = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == CHEESE) {
					cheeseCnt++;
				}
			}
		}
		int hour = 0;
		int leftCheese = 0;

		while (cheeseCnt != 0) {
			hour++;
			leftCheese = cheeseCnt;
			cheeseCnt = melt(cheeseCnt);
		}

		answer[0] = hour;
		answer[1] = leftCheese;
		return answer;
	}

	static Node edge = new Node(0, 0);

	static int melt(int cheese) {
		LinkedList<Node> q = new LinkedList<>();
		q.offer(edge);

		boolean v[][] = new boolean[n][m];
		v[edge.y][edge.x] = true;

		while (!q.isEmpty()) {
			Node cur = q.poll();

			for (int i = 0; i < 4; i++) {
				int ny = dy[i] + cur.y;
				int nx = dx[i] + cur.x;

				if (isOutOfRange(ny, nx) || v[ny][nx]) {
					continue;
				}

				v[ny][nx] = true;

				if (map[ny][nx] == 0) {
					q.offer(new Node(ny, nx));
				} else if (map[ny][nx] == CHEESE) {
					cheese--;
					map[ny][nx] = 0;
				}
			}
		}

		return cheese;
	}

	static boolean isOutOfRange(int ny, int nx) {
		return ny < 0 || nx < 0 || ny >= n || nx >= m;
	}
}
