package BaekJoon.SolvedAC4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class Lie {

	static int[] parents;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		int peopleCount = Integer.parseInt(st.nextToken());
		int partyCount = Integer.parseInt(st.nextToken());

		parents = new int[peopleCount + 1];
		for (int i = 1; i <= peopleCount; i++) {
			parents[i] = i;
		}

		st = new StringTokenizer(sc.nextLine());
		int knowingCount = Integer.parseInt(st.nextToken());
		Set<Integer> trueThings = new HashSet<>();
		if (knowingCount != 0) {
			while (st.hasMoreTokens()) {
				int truth = Integer.parseInt(st.nextToken());
				trueThings.add(truth);
			}
		}

		Map<Integer, List<Integer>> parties = new HashMap<>();
		for (int party = 1; party <= partyCount; party++) {
			st = new StringTokenizer(sc.nextLine());
			int count = Integer.parseInt(st.nextToken());
			List<Integer> participants = new ArrayList<>();

			for (int i = 0; i < count; i++) {
				int participant = Integer.parseInt(st.nextToken());
				participants.add(participant);
			}

			parties.put(party, participants);
		}

		establishRelation(parties);
		propagateTruth(peopleCount, trueThings);
		int answer = count(parties, trueThings);

		System.out.println(answer);
	}

	private static void propagateTruth(int peopleCount, Set<Integer> trueThings) {
		for (int i = 1; i <= peopleCount; i++) {
			int rootId = find(i);
			if (trueThings.contains(i)) {
				trueThings.add(rootId);
			}
		}
	}

	private static int count(Map<Integer, List<Integer>> parties, Set<Integer> trueThings) {
		int answer = 0;
		for (Integer key : parties.keySet()) {
			List<Integer> participants = parties.get(key);
			boolean shouldTrueTalk = participants.stream()
				.anyMatch(participant -> trueThings.contains(parents[participant]));

			if (!shouldTrueTalk) {
				answer++;
			}
		}

		return answer;
	}

	private static void establishRelation(Map<Integer, List<Integer>> parties) {
		for (Integer key : parties.keySet()) {
			List<Integer> participants = parties.get(key);

			if (participants.isEmpty()) {
				continue;
			}

			Integer prev = participants.get(0);
			for (int i = 1; i < participants.size(); i++) {
				Integer next = participants.get(i);
				union(prev, next);
				prev = next;
			}
		}
	}

	static int find(int a) {
		if (parents[a] == a) {
			return a;
		}

		return parents[a] = find(parents[a]);
	}

	static void union(int a, int b) {
		a = find(a);
		b = find(b);

		if (a < b) {
			parents[b] = a;
		} else {
			parents[a] = b;
		}
	}
}
