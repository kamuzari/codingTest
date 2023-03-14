package BaekJoon.tony.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Tree {

	private static int remove;
	private static int leaf;
	private static List<Integer>[] adj;

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(reader.readLine());
		adj = new List[n];

		for (int i = 0; i < n; i++) {
			adj[i] = new ArrayList<>();
		}

		int root = -1;

		StringTokenizer st = new StringTokenizer(reader.readLine());
		for (int i = 0; i < n; i++) {
			int parent = Integer.parseInt(st.nextToken());

			if (parent == -1) {
				root = i;
				continue;
			}

			adj[parent].add(i);
		}

		remove = Integer.parseInt(reader.readLine());
		if (root == remove) {
			System.out.println(0);
		} else {
			// 인접리스트 해당 노드 초기화
			adj[remove].clear();
			// 다른 노드로 부터 연결되는 노드 번호 삭제. n=50이라 작음.
			for (int i = 0; i < n; i++) {
				adj[i].remove((Integer)remove);
			}

			dfs(root);
			System.out.println(leaf);
		}

	}

	// 78 틀림 - 진짜로 인접리스트에서 짤라줘야 리프를 제대로 셀 수 있음.
	public static void dfs(int parent) {
		if (adj[parent].isEmpty()) {
			leaf++;
			return;
		}

		for (Integer next : adj[parent]) {
			dfs(next);
		}
	}
}
