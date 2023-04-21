package BaekJoon.tony.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class NQueen {
	static int n, answer;
	static int[] positions;

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(reader.readLine());
		//각 열의 위치
		positions = new int[n];
		pick(0);

		System.out.println(answer);
	}

	public static void pick(int cur) {
		if (cur == n) {
			answer++;
			return;
		}

		for (int position = 0; position < n; position++) {
			if (isPossible(cur, position)) {
				positions[cur] = position;
				pick(cur + 1);
				positions[cur] = 0;
			}
		}
	}

	static boolean isPossible(int idx, int position) {
		for (int i = 0; i < idx; i++) {
			int prevPosition = positions[i];
			if (prevPosition == position)
				return false;
			if (Math.abs(idx - i) == Math.abs(position - prevPosition))
				return false;
		}

		return true;
	}
}
