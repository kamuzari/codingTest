package FAST_CAMPUS.TopologySort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

/**

 3
 4
 5
 6

 */
public class MusicPrograme {
	/**
	 * note: 순환되는 것을 어떻게 해야 하지?
	 *  - ad : 사이클이 있으면 위상 정렬이 불가능한 경우다
	 *  - 사이클은 어쩨 해야될까?
	 *  - 중복 제거해봐야 겟다 set으로
	 *
	 *
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

		int singer = Integer.parseInt(tokenizer.nextToken());
		int pd = Integer.parseInt(tokenizer.nextToken());
		int indegrees[] = new int[singer + 1];

		List<Integer> adjList[] = new List[singer + 1];

		for (int i = 1; i <= singer; i++) {
			adjList[i] = new ArrayList<>();
		}

		for (int i = 0; i < pd; i++) {
			tokenizer = new StringTokenizer(reader.readLine());
			List<Integer> singers = new ArrayList<>();
			int role = Integer.parseInt(tokenizer.nextToken());

			for (int j = 0; j < role; j++) {
				singers.add(
					Integer.parseInt(tokenizer.nextToken())
				);
			}

			for (int j = 0; j < singers.size() - 1; j++) {
				int from = singers.get(j);
				int to = singers.get(j + 1);

				adjList[from].add(to);
				indegrees[to]++;
			}
		}

		LinkedList<Integer> q = new LinkedList<>();

		for (int i = 1; i <= singer; i++) {
			if (indegrees[i] == 0) {
				q.offer(i);
			}
		}

		List<Integer> answers = new ArrayList<>();

		while (!q.isEmpty()) {
			Integer cur = q.poll();
			answers.add(cur);
			for (Integer next : adjList[cur]) {
				indegrees[next]--;

				if (indegrees[next] == 0) {
					q.offer(next);
				}
			}
		}

		if (answers.size() != singer) {
			System.out.println(0);
			return;
		}

		System.out.println(
			answers.stream()
				.map(String::valueOf)
				.collect(Collectors.joining("\n"))
		);
	}
}


