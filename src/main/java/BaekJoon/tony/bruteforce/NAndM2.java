package BaekJoon.tony.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class NAndM2 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(reader.readLine());

		int n = Integer.parseInt(token.nextToken());
		int m = Integer.parseInt(token.nextToken());

		System.out.println(solution(n, m));
	}

	static int N, M;
	static StringBuilder answer=new StringBuilder();

	static String solution(int n, int m) {
		N = n;
		M = m;

		pick(0, 1);
		return answer.toString();
	}

	static Stack<Integer> results = new Stack<>();

	static void pick(int cnt, int idx) {
		if (cnt == M) {
			String result = results.stream().map(String::valueOf)
				.collect(Collectors.joining(" "));
			answer.append(result)
				.append("\n");
			return;
		}

		for (int i = idx; i <= N; i++) {
			results.push(i);
			pick(cnt + 1, i + 1);
			results.pop();
		}
	}
}
