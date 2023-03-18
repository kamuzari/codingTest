package BaekJoon.tony.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class RainWaterOnTheTree {
	static List<Integer>[] adj;
	static final int ROOT = 1;

	/**
	 * 리프의 갯수대로 나노 먹을 것이다.
	 * 하지만 root의 물의 양이 1이라면 pi가 0보다 큰 정점은 leaf 개수가 아닌 1개 인데...?
	 * 음.. 평균은 하나의 리프에만 기댓값이 0보다 큰 1이 한개인데...?
	 * 그런데 pi가 0보다 큰 정점들에 대해서 수치적으로 0보다 큰 값이 무조건적으로 리프의 개수라고 말할 수 없지 않나
	 * 리프에 물이 고일 것이라고 기대하는 것이지 실제 리프마다 물이 있을거라는 그것이 없자나..
	 *
	 * 기댓값이 나올 수 있는 pi가 0이 아닐 거라는 것이 := 리프노드 인갑네..
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(st.nextToken());
		int water = Integer.parseInt(st.nextToken());

		adj = new List[n + 1];
		for (int i = 1; i < n + 1; i++) {
			adj[i] = new ArrayList<>();
		}

		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(reader.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			adj[a].add(b);
			adj[b].add(a);
		}

		int leaf = 0;
		for (int i = 2; i < n + 1; i++) {
			if (adj[i].size() == 1)
				leaf++;
		}

		System.out.println(String.format("%.10f", (double)water / leaf));
	}

}
