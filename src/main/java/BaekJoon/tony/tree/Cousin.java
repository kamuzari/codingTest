package BaekJoon.tony.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Cousin {
	public static void main(String[] args) throws IOException {
		StringBuilder answers = new StringBuilder();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			StringTokenizer st = new StringTokenizer(reader.readLine());

			int n = Integer.parseInt(st.nextToken());
			int target = Integer.parseInt(st.nextToken());

			if (n == 0 && target == 0) {
				break;
			}

			int arr[] = new int[n];
			int targetIdx = 0;
			st = new StringTokenizer(reader.readLine());
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());

				if (arr[i] == target) {
					targetIdx = i;
				}
			}

			int parent[] = new int[n];
			parent[0] = -1;
			int parentIdx = -1;
			// 간선의 정보를 바탕으로 트리 만들기 (core) -> 답을 도출해내야 한다.
			for (int i = 1; i < n; i++) {
				if (arr[i - 1] + 1 != arr[i]) { // 연속 적이지 않다면
					parentIdx++;
				}

				parent[i] = parentIdx;
			}

			int cousin = 0;
			for (int i = 1; i < n; i++) {
				if (parent[i] == parent[targetIdx]) {
					// 같은 부모 이면 := 형제 노드이면
					continue;
				} else if (parent[parent[i]] == parent[parent[targetIdx]]) {
					// 부모의 부모가 같다면 := 사촌이 맞다면
					cousin++;
				}
			}

			answers.append(cousin).append("\n");
		}

		System.out.println(answers);
	}
}
