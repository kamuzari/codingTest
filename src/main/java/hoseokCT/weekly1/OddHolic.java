package hoseokCT.weekly1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class OddHolic {
	private static int maxValue = Integer.MIN_VALUE;
	private static int minValue = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());

		dfs(n,0);

		System.out.println(minValue+" "+maxValue);
	}

	/**
	 * note:
	 *  - 홀수를 개수에 적는다.
	 *  - 종료조건 : 한자리이면
	 *  - 수가 두자이리면 2개로 나눠서 합을 구하여 새로운 수로 생각한다.
	 *  - 수가 세자리 이상이면 임이의 위치에서 끊어서 3개의 수로 분할하고, 3개를 더한값으로 새로운 수를 구한다.
	 */
	public static void dfs(int x, int cnt) {
		cnt += countOdd(x);

		if (x < 10) {
			maxValue = Math.max(maxValue, cnt);
			minValue = Math.min(minValue, cnt);
			return;
		} else if (x < 100) {
			dfs(x / 10 + x % 10, cnt);
		} else {
			String str = String.valueOf(x);

			for (int i = 1; i < str.length() - 1; i++) {
				String left = str.substring(0, i);
				for (int j = i + 1; j < str.length(); j++) {
					String mid = str.substring(i, j);
					String right = str.substring(j);

					dfs(Integer.parseInt(left) + Integer.parseInt(mid) + Integer.parseInt(right), cnt);
				}
			}
		}

	}

	private static int countOdd(int x) {
		String[] numbers = String.valueOf(x).split("");

		return (int)Arrays.stream(numbers)
			.map(Integer::parseInt)
			.filter(value -> value % 2 == 1)
			.count();
	}

}
