package BaekJoon.tony.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class CuttingVertexAndBridge {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(reader.readLine()); // 정점의 개수
		List<Integer> adj[] = new List[n + 1];
		for (int i = 1; i <= n; i++) {
			adj[i] = new ArrayList<>();
		}

		// 간선의 정보 입력받기
		List<int[]> edges = new ArrayList<>();
		for (int i = 0; i < n - 1; i++) {
			StringTokenizer st = new StringTokenizer(reader.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			adj[a].add(b);
			adj[b].add(a);
		}

		int q = Integer.parseInt(reader.readLine()); // 질의문의 개수
		StringBuilder answers = new StringBuilder();
		// t,k입력 t=: [1,2] - 1:단절점인지 , 2:단절선인지
		for (int i = 0; i < q; i++) {
			StringTokenizer st = new StringTokenizer(reader.readLine());
			int t = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			if (t == 1) {
				// 루트 또는 말단 노드일 때는 NO
				if (isRootOrTerminateNode(adj[k])) {
					answers.append("no");
				} else {
					answers.append("yes");
				}

			} else if (t == 2) {
				// 가선은 어디를 잘라도 무조건 두개의 그래프로 나뉨.:= 간선은 두 정점을 연결하는 요소의 성질이므로
				answers.append("yes");
			}

			answers.append("\n");
		}
		System.out.println(answers);
	}

	/**
	 * 루트 또는 말단 노드는 인접리스트에 무조건 1개밖에 들어 있지 않는다.
	 * @param adj
	 * @return
	 */
	private static boolean isRootOrTerminateNode(List<Integer> adj) {
		int cnt = 0;

		for (Integer next : adj) {
			cnt++;
		}

		return cnt <= 1;
	}

}
