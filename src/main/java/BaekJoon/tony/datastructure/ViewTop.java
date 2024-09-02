package BaekJoon.tony.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class ViewTop {
	private static final int INF = (int)1e9;

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());

		int[] heights = new int[n];
		int[] count = new int[n];
		int[] near = new int[n];
		Arrays.fill(near, -INF);

		StringTokenizer st = new StringTokenizer(reader.readLine());
		for (int i = 0; i < n; i++) {
			heights[i] = Integer.parseInt(st.nextToken());
		}

		toRight(n, heights, count, near); // 현재 위치 i에서 왼쪽 건물을 바라볼때,
		toLeft(n, heights, count, near); // 현재 위치 i에서 오른쪽 건물을 바라볼때,

		StringBuilder answers = new StringBuilder();
		for (int i = 0; i < n; i++) {
			answers.append(count[i]);

			if (count[i] != 0) {
				answers.append(" ").append(near[i] + 1);
			}

			answers.append(System.lineSeparator());
		}
		System.out.println(answers);
	}

	private static void toLeft(int n, int[] heights, int[] count, int[] near) {
		Stack<Integer> s = new Stack<>();
		for (int i = n - 1; i >= 0; i--) {
			while (!s.isEmpty() && heights[s.peek()] <= heights[i]) {
				s.pop();
			}

			if (s.size() > 0) {
				count[i] += s.size();
				if (isCloser(near, i, s)) {
					near[i] = s.peek();
				}
			}

			s.push(i);
		}
	}

	private static boolean isCloser(int[] near, int i, Stack<Integer> s) {
		return i - near[i] > s.peek() - i;
	}

	private static void toRight(int n, int[] heights, int[] count, int[] near) {
		Stack<Integer> s = new Stack<>();
		for (int i = 0; i < n; i++) {
			while (!s.isEmpty() && heights[s.peek()] <= heights[i]) {
				s.pop();
			}

			if (s.size() > 0) {
				count[i] += s.size();
				near[i] = s.peek();
			}

			s.push(i);
		}
	}
}
