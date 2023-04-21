package BaekJoon.tony.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Anagram {

	private static char[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		StringBuilder answer = new StringBuilder();

		while (n-- > 0) {
			arr = reader.readLine().toCharArray();

			Arrays.sort(arr);
			answer.append(arr).append("\n");

			while (isNextWords(arr.length)) {
				answer.append(arr).append("\n");
			}
		}

		System.out.println(answer);
	}

	/**
	 * next-permutation 알고리즘
	 * @param n - 단어의 길이
	 */
	static boolean isNextWords(int n) {
		int idx = n - 1;

		// 증가하는 구간 찾아내기
		while (idx > 0 && arr[idx] <= arr[idx - 1]) {
			idx--;
		}

		// 사전순으로 마지막이다 ex) 4321
		if (idx == 0) {
			return false;
		}

		// 오른쪽 구간에서 큰 값 찾고 스왑하기
		for (int i = n-1; i >= idx; i--) {
			if (arr[idx - 1] < arr[i]) {
				char temp = arr[i];
				arr[i] = arr[idx - 1];
				arr[idx - 1] = temp;
				break;
			}
		}

		// 오른쪽구간에서 큰값과 스왑했으니 다시 재정렬하기
		Arrays.sort(arr, idx, n);
		return true;
	}
}
