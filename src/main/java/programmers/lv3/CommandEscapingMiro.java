package programmers.lv3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CommandEscapingMiro {

	// 사전 순에 영향을 받으로 d,l,r,u 로 방향 백터를 정해야함.
	int dy[] = {1, 0, 0, -1};
	int dx[] = {0, -1, 1, 0};
	Map<Integer, String> dirs = Map.of(0, "d", 1, "l", 2, "r", 3, "u");
	int N, M;

	class Node {
		int y, x, cnt;

		String path;

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
			this.path = "";
			this.cnt = 0;
		}

		public Node(int y, int x, int cnt, String path) {
			this.y = y;
			this.x = x;
			this.path = path;
			this.cnt = cnt;
		}
	}

	public String solution(int n, int m, int x, int y, int r, int c, int k) {
		String answer = "";
		N = n;
		M = m;

		Node start = new Node(x - 1, y - 1);
		LinkedList<Node> q = new LinkedList<>();
		List<String> results = new ArrayList<>();
		q.offer(start);

		boolean v[][][] = new boolean[k + 1][n][m];
		v[0][x - 1][y - 1] = true;
		// 핵심은 큐안에 담기는 노드를 최적화해야함. 안그러면 TLE
		while (!q.isEmpty()) {
			Node cur = q.poll();

			if (cur.y == r - 1 && cur.x == c - 1 && cur.cnt == k) {
				results.add(cur.path);
				continue;
			}

			for (int i = 0; i < 4; i++) {
				int ny = dy[i] + cur.y;
				int nx = dx[i] + cur.x;

				if (isOutOfRange(ny, nx))
					continue;
				// 일반적인 최단 거리 같은 거로 하면.. 큐가 터질텐데....? 그러면 k까지는 허용하자!
				// if(cur.cnt + 1 > k) continue;  // 1트 실패 (4개 맞음)
				// 현재 온 거리와 맨헤튼을 더했을 때 갈 수 있는 정도라면 <=k 안으로 해서 큐 최적화
				// int menhaton=Math.abs(ny - (r-1))+ Math.abs(nx-(c-1));
				// if(cur.cnt + menhaton>k) continue;  // 멘하튼 2트 실패 (6개 맞음)
				// 어디를 최적화 해야하지?

				if (cur.cnt + 1 > k || v[cur.cnt + 1][ny][nx])
					continue;
				Node next = new Node(ny, nx, cur.cnt + 1, cur.path + dirs.get(i));
				q.offer(next);
				v[next.path.length()][ny][nx] = true;
			}
		}

		Collections.sort(results);

		if (results.isEmpty()) {
			return "impossible";
		}

		return results.get(0);
	}

	boolean isOutOfRange(int ny, int nx) {
		return ny < 0 || nx < 0 || ny >= N || nx >= M;
	}
}
