package programmers.lv3;

import java.util.HashSet;
import java.util.Set;

public class PresentN {
	public int solution(int N, int number) {
		int answer = 0;
		Set<Integer> dp[] = new Set[9];

		if (N == number) {
			return 1;
		}

		dp[1] = Set.of(N);

		for (int i = 1; i <= 8; i++) {
			dp[i] = new HashSet<>();
			String val = String.valueOf(N).repeat(i);
			dp[i].add(Integer.parseInt(val));
		}

		for (int cnt = 2; cnt <= 8; cnt++) {
			// 이전 마이그레이션
			for (int i = 1; i < cnt; i++) {
				for (int a : dp[i]) {
					for (int b : dp[cnt - i]) {
						dp[cnt].add(a + b);
						dp[cnt].add(a - b);
						dp[cnt].add(a * b);
						if (a != 0 && b != 0) {
							dp[cnt].add(a / b);
						}
					}
				}
			}

			if (dp[cnt].contains(number)) {
				return cnt;
			}

		}

		return -1;
	}

	public int solutionFail(int N, int number) {
		int answer = 0;
		Set<Integer> dp[] = new Set[9];

		if (N == number) {
			return 1;
		}

		dp[1] = Set.of(N);
		// 사칙연산의 우선순위를 생각해야 한다.
		// (4*4) + (4/4) == 17이 나올수 있다. 내가 한 로직은 괄호가 없는 알고리즘 이다!!!
		for (int i = 2; i <= 4; i++) {
			// 이전 마이그레이션
			Set<Integer> newVals = new HashSet<>();
			String repeat = "";
			int cnt = i;
			while (cnt-- > 0) {
				repeat += N;
			}

			newVals.add(Integer.parseInt(repeat));
			for (int prev : dp[i - 1]) {
				int next1 = prev + N;
				int next2 = prev - N;
				int next3 = prev * N;
				int next4 = prev / N;

				newVals.add(next1);
				newVals.add(next2);
				newVals.add(next3);
				newVals.add(next4);

				if (newVals.contains(number)) {
					return i;
				}

			}

			System.out.println(newVals);
			dp[i] = newVals;
		}

		return -1;
	}
}
