package FAST_CAMPUS.CompleteSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class NAndM9 {
	private static int m;
	private static int n;
	private static int[] numbers;
	private static boolean[] v;
	static Set<List<Integer>> results = new LinkedHashSet<>();
	static Stack<Integer> result = new Stack<>();

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(reader.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		v = new boolean[n];
		numbers = new int[n];

		st = new StringTokenizer(reader.readLine());

		for (int i = 0; i < n; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(numbers);

		permutate(0);

		String answer = results.stream().map(
			lists -> lists.stream().map(String::valueOf).collect(Collectors.joining(" "))
		).collect(Collectors.joining("\n"));

		System.out.println(answer);

	}

	public static void permutate(int cnt) {
		if (cnt == m) {
			results.add(
				result.stream().collect(Collectors.toList())
			);

			return;
		}

		for (int i = 0; i < n; i++) {
			if (v[i])
				continue;

			v[i] = true;
			result.push(numbers[i]);
			permutate(cnt + 1);
			v[i] = false;
			result.pop();
		}
	}
}
