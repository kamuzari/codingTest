package FAST_CAMPUS.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class TreeEscaping {
	static final int ROOT = 1;

	static int totalDepth = 0;
	private static List<Integer>[] adjList;
	private static boolean[] v;

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(reader.readLine());

		/**
		 * note: 게임판의 모양읇고 성원이가 게임을 이길 수 있는지 어떻게 알 수 있을까?
		 *  - 깊이를 통해 알 수 있다. 루트 - 리프 깊이가 짝수면 성원가 진다.
		 */

		adjList = new List[n + 1];

		for (int i = 1; i <= n; i++) {
			adjList[i] = new ArrayList<>();
		}

		for (int i = 0; i < n - 1; i++) {
			StringTokenizer st = new StringTokenizer(reader.readLine());

			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());

			adjList[v1].add(v2);
			adjList[v2].add(v1);
		}

		v = new boolean[n + 1];

		dfs(ROOT, 0);

		Message message = totalDepth % 2 == 0 ? Message.No : Message.Yes;

		System.out.println(message);
	}

	public static void dfs(int cur, int cnt) {
		if (adjList[cur].size() == 1 && cur != ROOT) {
			totalDepth += cnt;
		}

		for (Integer next : adjList[cur]) {
			if (v[next])
				continue;

			v[next]=true;

			dfs(next, cnt + 1);
		}
	}

	enum Message {
		Yes, No
	}
}
