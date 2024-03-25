package BaekJoon.honeytip.mootube;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MooTube {
	static class Node {
		private int v, cost;

		public Node(int v, int cost) {
			this.v = v;
			this.cost = cost;
		}
	}

	// 5천 * 5천..
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		int n = Integer.parseInt(st.nextToken());
		int queryCount = Integer.parseInt(st.nextToken());
		List<Node> adjacency[] = new List[n + 1];
		for (int i = 0; i < n + 1; i++) {
			adjacency[i] = new ArrayList<>();
		}

		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(sc.nextLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			adjacency[a].add(new Node(b, cost));
			adjacency[b].add(new Node(a, cost));
		}
		StringBuilder answers = new StringBuilder();
		for (int i = 0; i < queryCount; i++) {
			st = new StringTokenizer(sc.nextLine());
			int graterThanValue = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			int videoCount = 0;
			LinkedList<Integer> q = new LinkedList<>();
			boolean[] v = new boolean[n + 1];
			q.offer(start);
			v[start] = true;
			while (!q.isEmpty()) {
				int cur = q.poll();

				for (Node next : adjacency[cur]) {
					/**
					 * review: 한 시박점으로 부터 퍼져나가는 BFS 성질을 이해하면 됨
					 *   - 다음 정점으로 가기 까지 K미만의 유사도를 가진 경로를 거치게 되면 다음 노드에서
					 *     다음 노드 에 K보다 크다고 해도 이전 K미만의 유사도 경로 값으로 대치될 것이기 때문에
					 *     애초에 다음 노드로 가는것이 k보다 작으면 가지 않는다.
					 *     문제 조건을 보면 임의의 두 쌍 사이의 동영상이라고 언급한 바 있다. 그리고 힌트를 보면 이전 노드로 부터
					 *     온 경로값의 값과 비교하여 최솟값으로 갱신한다.
					 */
					if (v[next.v])
						continue;
					if (next.cost < graterThanValue)
						continue;
					videoCount++;
					v[next.v] = true;
					q.offer(next.v);
				}
			}

			answers.append(videoCount).append("\n");
		}

		System.out.println(answers);

	}
}
