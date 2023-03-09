package BaekJoon.tony.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class RemoveBracket {

	/**
	 * 수식이 주어졌을 때, 괄호를 제거해서 나올 수 있는 서로 다른 식의 개수를 출력하라.
	 * 단, 괄호의 쌍이 알맞아야 한다.
	 *  솰호의 쌍이 n개일 때 =: n개 각각한가지 뺏을 때 + (n-1)! + 모두 뱄을 경우 1가지
	 * @param args
	 */

	static Set<List<Integer>> noPicks = new HashSet<>();
	static List<int[]> results;
	static String[] inputs;
	static TreeSet<String> answers;

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		inputs = reader.readLine().split("");
		// 괄호 쌍 위치들(괄호 여는 위치, 괄호 닫는 위치)
		results = new ArrayList<>();
		Stack<Integer> s = new Stack<>();
		for (int i = 0; i < inputs.length; i++) {
			String input = inputs[i];
			if (input.equals("(")) {
				s.push(i);
			} else if (input.equals(")")) {
				if (!s.isEmpty()) {
					results.add(new int[] {s.pop(), i});
				}
			}
		}
		comb(0, 0, new ArrayList<>());

		answers = new TreeSet<>();
		for (List<Integer> noPick : noPicks) { // nopicks는 안뽑아야 하는 results 위치
			Set<Integer> set = noPick.stream().map(idx -> results.get(idx))
				.map(ints -> new Integer[] {ints[0], ints[1]})
				.flatMap(Arrays::stream)
				.collect(Collectors.toSet());

			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < inputs.length; i++) {
				if (set.contains(i)) {
					continue;
				}
				sb.append(inputs[i]);
			}

			if (sb.length() == inputs.length)
				continue;

			answers.add(sb.toString());
		}

		answers.forEach(System.out::println);
	}

	static boolean v[];

	public static void comb(int idx) {
		if (idx == results.size()) {
			StringBuilder sb = new StringBuilder();
			boolean check[] = new boolean[inputs.length];

			for (int i = 0; i < v.length; i++) {
				if (v[i]) {
					check[results.get(i)[0]] = true;
					check[results.get(i)[1]] = true;
				}
			}

			for (int i = 0; i < inputs.length; i++) {
				if (!check[i]) {
					sb.append(inputs[i]);
				}
			}

			if (sb.length() != inputs.length) {
				answers.add(sb.toString());
			}
			return;
		}

		v[idx] = true;
		comb(idx + 1);
		v[idx] = false;
		comb(idx + 1);
	}

	public static void comb(int cnt, int idx, List<Integer> sets) {
		if (cnt == results.size()) {
			noPicks.add(new ArrayList<Integer>(sets));
			return;
		}

		for (int i = idx; i < results.size(); i++) {
			sets.add((Integer)i);
			comb(cnt + 1, i + 1, sets);
			sets.remove((Integer)i);
			comb(cnt + 1, i + 1, sets);
		}

	}
}
