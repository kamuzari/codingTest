package BaekJoon._자료구조구현.try2.stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class 오큰수 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		StringTokenizer st = new StringTokenizer(reader.readLine());
		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int[] answer = new int[n];
		Arrays.fill(answer, -1);
		Stack<Integer> s = new Stack<>();
		for (int i = 0; i < n; i++) {
			if (!s.isEmpty()) {
				int currentValue = arr[i];

				while (!s.isEmpty() && arr[s.peek()] < currentValue) {
					answer[s.pop()] = currentValue;
				}
			}

			s.push(i);
		}

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 0; i < n; i++) {
			bw.write(answer[i] + " ");
		}
		bw.flush();
	}
}
