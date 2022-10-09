package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class PredicationSeqencial {
	private static int[] candidates;
	private static int n;
	private static boolean[] v;
	private static int endPoints;
	private static boolean isFindAnswer = false;

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());
		n = Integer.parseInt(st.nextToken());
		candidates = new int[n];
		v = new boolean[n];
		endPoints = Integer.parseInt(st.nextToken());

		pick(0);

		System.out.println(
			Arrays.stream(candidates)
				.mapToObj(String::valueOf)
				.collect(Collectors.joining(" "))
		);
	}

	private static boolean isValid(int[] candidate) {
		for (int i = candidate.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				candidate[j] = candidate[j] + candidate[j + 1];
			}
		}

		return candidate[0] == endPoints;
	}

	/**
	 * hint: early return 안하면 시간 초과 남.
	 * @param cnt
	 */
	private static void pick(int cnt) {
		if (cnt == n) {
			// note : candidates.add(results.clone()); -> TLE
			if (isValid(candidates.clone())) {
				isFindAnswer = true;
			}
			return;
		}


		for (int i = 0; i < n; i++) {
			if (v[i])
				continue;

			if(isFindAnswer)
				return;

			v[i] = true;
			candidates[cnt] = i + 1;
			pick(cnt + 1);
			v[i] = false;

		}
	}
}
