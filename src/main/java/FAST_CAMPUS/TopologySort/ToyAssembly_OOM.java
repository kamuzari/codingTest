package FAST_CAMPUS.TopologySort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class ToyAssembly_OOM {

	private static Map<Integer, Integer> basicParts;
	private static List<Condition>[] adjList;

	/* note: 완제품을 만드는데 필요한 리소스를 구하라.
	    - 그런데, 위상정렬에 있어 다른점이 있다면, 만들기 위해 필요한 개수가 1개가 아닌 여러개라는 것이다.
	    - 결과는, 메모리 초과
	*/
	static class Condition {
		private int id;
		private int stock;

		public Condition(int id, int stock) {
			this.id = id;
			this.stock = stock;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int target = Integer.parseInt(reader.readLine()); // 완제품

		adjList = new List[target + 1];

		for (int i = 1; i <= target; i++) {
			adjList[i] = new ArrayList<>();
		}

		int relation = Integer.parseInt(reader.readLine());

		for (int i = 0; i < relation; i++) {
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
			int completion = Integer.parseInt(tokenizer.nextToken());
			int source = Integer.parseInt(tokenizer.nextToken());
			int stock = Integer.parseInt(tokenizer.nextToken());

			adjList[completion].add(new Condition(source, stock));
		}

		basicParts = new HashMap<>();

		for (int i = 1; i < adjList.length; i++) {
			if (adjList[i].isEmpty()) {
				basicParts.put(i, 0);
			}
		}

		recursiveForTopDown(target, 1);

		for (Integer key : basicParts.keySet()) {
			System.out.println(key+" "+basicParts.get(key));
		}
	}

	public static void recursiveForTopDown(int target, int multiple) {

		for (Condition next : adjList[target]) {
			if (basicParts.containsKey(next.id)) {
				basicParts.put(next.id, basicParts.getOrDefault(next.id, 0) + next.stock * multiple);
				continue;
			}

			recursiveForTopDown(next.id, multiple * next.stock);
		}
	}
}
