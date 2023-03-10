package BaekJoon.tony.datastructure2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class ProblemReferenceSystem1 {
	static final int HARD = 1;
	static final int EASY = -1;

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(reader.readLine());

		TreeMap<Integer, TreeMap<Integer, Integer>> problems = new TreeMap<>(); // rank, id
		Map<Integer, Integer> histories = new HashMap<>(); // 문제번호의 랭크 경로
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(reader.readLine());
			int id = Integer.parseInt(st.nextToken());
			int rank = Integer.parseInt(st.nextToken());
			add(problems, id, rank);
			histories.put(id, rank);
		}

		n = Integer.parseInt(reader.readLine());
		StringBuilder answer = new StringBuilder();

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(reader.readLine());
			String cmd = st.nextToken();

			switch (cmd) {
				case "add":
					int id = Integer.parseInt(st.nextToken());
					int rank = Integer.parseInt(st.nextToken());
					add(problems, id, rank);
					histories.put(id, rank);
					break;
				case "recommend":
					if (problems.isEmpty()) {
						continue;
					}

					int requestRank = Integer.parseInt(st.nextToken());

					if (requestRank == HARD) {
						Integer hardRank = problems.lastKey();
						Integer refered = problems.get(hardRank).lastKey();
						answer.append(refered);
					} else if (requestRank == EASY) {
						Integer easyRank = problems.firstKey();
						Integer refered = problems.get(easyRank).firstKey();
						answer.append(refered);
					}
					answer.append("\n");
					break;
				case "solved":
					int solvedId = Integer.parseInt(st.nextToken());
					Integer searchRank = histories.get(solvedId);
					problems.get(searchRank).remove(solvedId);

					if (problems.get(searchRank).isEmpty()) {
						problems.remove(searchRank);
					}

					break;

			}
		}
		System.out.println(answer);
	}

	private static void add(TreeMap<Integer, TreeMap<Integer, Integer>> problems, int id, int rank) {
		if (problems.containsKey(rank)) {
			problems.get(rank).put(id, rank);
		} else {
			problems.put(rank, new TreeMap<>(Map.of(id, rank)));
		}
	}

}
