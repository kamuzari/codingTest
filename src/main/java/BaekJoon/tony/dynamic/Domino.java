package BaekJoon.tony.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Domino {
	static class Block {
		private long position;
		private long height;

		public Block(int position, int height) {
			this.position = position;
			this.height = height;
		}

		public long getLeftEnd() {
			return position - height;
		}

		public long getRightEnd() {
			return position + height;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(reader.readLine());
		Block[] dominos = new Block[n];
		StringTokenizer st;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(reader.readLine());
			dominos[i] = new Block(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		Arrays.sort(dominos, Comparator.comparingLong(a -> a.position));
		int[] left = new int[n];
		int[] right = new int[n];

		for (int i = 0; i < n; i++) {
			right[i] = left[i] = i;
		}

		for (int i = 0; i < n; i++) {
			long leftEnd = dominos[i].getLeftEnd();
			long rightEnd = dominos[i].getRightEnd();

			for (int j = i; j >= 0; j--) {
				if (leftEnd <= dominos[j].position) {
					leftEnd = Math.min(leftEnd, dominos[j].getLeftEnd());
					left[i] = Math.min(left[i], j);
				}
			}

			for (int j = i + 1; j < n; j++) {
				if (rightEnd >= dominos[j].position) {
					rightEnd = Math.max(rightEnd, dominos[j].getRightEnd());
					right[i] = Math.max(right[i], j);
				}
			}
		}

		int dp[] = new int[n];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 1;

		for (int i = 0; i < n; i++) {
			if (left[i] - 1 < 0) {
				dp[i] = Math.min(dp[i], 1);
			} else {
				dp[i] = Math.min(dp[i], dp[left[i] - 1] + 1);
			}

			for (int j = 0; j < i; j++) {
				if (right[j] >= i) {
					if (j == 0) {
						dp[i] = Math.min(dp[i], 1);
					} else {
						dp[i] = Math.min(dp[i], dp[j - 1] + 1);
					}
				}
			}
		}

		System.out.println(dp[n - 1]);
	}
}
