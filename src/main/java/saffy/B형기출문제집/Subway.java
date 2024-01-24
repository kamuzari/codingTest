package saffy.B형기출문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Subway {
	static boolean[] cycle;
	static int n;
	static List<Integer> list[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		list = new List[n + 1];
		cycle = new boolean[n + 1];
		for (int i = 1; i < n + 1; i++) {
			list[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			list[from].add(to);
			list[to].add(from);
		}
		for (int i = 1; i < n + 1; i++) {
			if (isCycle(i, i, i)) break;
			cycle = new boolean[n + 1];
		}
		int[] answer = new int[n + 1];
		for (int i = 1; i < n + 1; i++) {
			if (!cycle[i]) {
				answer[i] = bfs(i);
			}
		}
		for (int i = 1; i <n+1 ; i++) {
			System.out.print(answer[i]+" ");
		}
	}

	private static int bfs(int start) {
		LinkedList<int[]> q = new LinkedList<>();
		boolean v[] = new boolean[n + 1];
		q.offer(new int[]{start, 0});
		v[start] = true;
		while (!q.isEmpty()) {
			final int[] arr = q.poll();
			int cur = arr[0];
			int dist = arr[1];
			if (cycle[cur]) return dist;

			for (Integer next : list[cur]) {
				if (!v[next]) {
					v[next] = true;
					q.offer(new int[]{next, dist + 1});
				}
			}
		}
		return 0;
	}

	private static boolean isCycle(int previous, int cur, int start) {
		cycle[cur] = true;
		for (Integer next : list[cur]) {
			if (!cycle[next]) {
				if (isCycle(cur, next, start)) {
					return true;
				}
			}else if (next != previous && next == start) {
				return true;
			}
		}
		cycle[cur] = false;
		return false;
	}
}
