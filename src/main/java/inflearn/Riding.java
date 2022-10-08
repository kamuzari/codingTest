package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Riding {

	private static int limit;
	private static int n;
	private static int[] dogs;
	private static int answer = 0;
	private List<Integer> picks = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());

		limit = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());

		dogs = new int[n];

		for (int i = 0; i < n; i++) {
			dogs[i] = Integer.parseInt(reader.readLine());
		}

		// combination(0, 0, 0);
		pick(0, 0);
		System.out.println(answer);
	}

	private static void combination(int cnt, int idx, int sum) {
		if (limit < sum) {
			return;
		}

		/**
		 * note : 원래 if(cnt>=n) 다음 구문에 있었음.
		 *  - dogs[n-1] 끝값을 더한 결과를 반영하지 못했음.
		 */
		answer = Math.max(answer, sum);

		if (cnt >= n) {
			return;
		}


		for (int i = idx; i < n; i++) {
			combination(cnt + 1, i + 1, sum + dogs[i]);
		}
	}

	private static void pick(int cnt, int sum) {

		if (sum > limit) {
			return;
		}

		if (cnt >= n) {
			answer = Math.max(answer, sum);
			return;
		}

		pick(cnt + 1, sum + dogs[cnt]);
		pick(cnt + 1, sum);
	}
}
