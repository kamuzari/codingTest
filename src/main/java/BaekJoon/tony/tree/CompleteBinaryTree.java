package BaekJoon.tony.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CompleteBinaryTree {

	private static int[] arr;
	private static int n;

	/**
	 * 전위 순회 리버싱. - 중앙에 있는 것이 루트
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(reader.readLine());

		int total = (int)Math.pow(2.0, n) - 1;
		arr = new int[total];

		StringTokenizer st = new StringTokenizer(reader.readLine());
		for (int i = 0; i < total; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		answers = new StringBuilder[n];
		for (int i = 0; i < n; i++) {
			answers[i] = new StringBuilder();
		}

		recur(0, total - 1, 0); // 어차피 배열의 길이는 항상 홀수임을 보장한다.

		for (int i = 0; i < n; i++) {
			System.out.println(answers[i].toString());
		}
	}

	static StringBuilder[] answers;

	public static void recur(int s, int e, int depth) { // [s,e]
		if (depth == n) {
			return;
		}

		int mid = (s + e) / 2;
		answers[depth].append(arr[mid] + " "); // depth에 따른 출력
		recur(s, mid - 1, depth + 1);
		recur(mid + 1, e, depth + 1);
	}
}
