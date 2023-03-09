package BaekJoon.tony.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Top {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int tops[] = new int[n];

		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		for (int i = 0; i < n; i++) {
			tops[i] = Integer.parseInt(tokenizer.nextToken());
		}

		int[] answers = new int[n];
		Stack<Integer> s = new Stack<>();
		for (int i = n - 1; i >= 0; i--) {
			while (!s.isEmpty() && tops[s.peek()] <tops[i]) {
				answers[s.pop()] = i + 1;
			}

			s.push(i);
		}

		String answer = Arrays.stream(answers).mapToObj(String::valueOf).collect(Collectors.joining(" "));
		System.out.println(answer);
	}
}
