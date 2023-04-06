package programmers.lv3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class StudyCodingTest {
	public static void main(String[] args) {
		StudyCodingTest studyCodingTest = new StudyCodingTest();

		System.out.println(studyCodingTest.solution(0, 0, new int[][] {
			{0, 0, 2, 1, 2},
			{4, 5, 3, 1, 2},
			{4, 11, 4, 0, 2},
			{10, 4, 0, 4, 2}
		}));

		System.out.println(studyCodingTest.solution(19, 11, new int[][] {
			{0, 0, 2, 1, 2},
			{4, 5, 3, 1, 2},
			{4, 11, 4, 0, 2},
			{10, 4, 0, 4, 2}
		}));
	}

	public int solution_dp(int alp, int cop, int[][] problems) {
		int[][] dp = new int[152][152];
		int targetAlp = 0;
		int targetCop = 0;
		for (int[] problem : problems) {
			targetAlp = Math.max(targetAlp, problem[0]);
			targetCop = Math.max(targetCop, problem[1]);
		}

		// alp가 더 많거나 혹은 cop가 목표치보다 높을 때 예외처리
		if (targetAlp < alp) {
			alp = targetAlp;
		}

		if (targetCop < cop) {
			cop = targetCop;
		}

		for (int i = alp; i < 152; i++) {
			Arrays.fill(dp[i], 999_999);
		}

		dp[alp][cop] = 0;

		for (int i = alp; i <= targetAlp; i++) {
			for (int j = cop; j <= targetCop; j++) {
				dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j] + 1);
				dp[i][j + 1] = Math.min(dp[i][j + 1], dp[i][j] + 1);
				for (int k = 0; k < problems.length; k++) {
					int reqAlp = problems[k][0];
					int reqCop = problems[k][1];
					int rewAlp = problems[k][2];
					int rewClp = problems[k][3];
					int time = problems[k][4];
					/**
					 * 예외의 핵심
					 * 만약 범위를 넘어가서 알고력과 코딩력을 달성했다면
					 * 그래도 목표 알고리즘의 최솟값이 들 수 있는 경우가 있다.
					 */
					if (i >= reqAlp && j >= reqCop) {
						int ny = i + rewAlp;
						int nx = j + rewClp;

						if (ny > targetAlp) {
							ny = targetAlp;
						}

						if (nx > targetCop) {
							nx = targetCop;
						}

						dp[ny][nx] = Math.min(dp[ny][nx], dp[i][j] + time);
					}
				}
			}
		}

		return dp[targetAlp][targetCop];
	}

	/**
	 * 문제를 다 풀수 있는 알고력과 코딩력이 기존 알고력, 코딩력 보다 작을 수 있다.
	 */
	public int solution(int alp, int cop, int[][] problems) {
		List<Problem> problemList = new ArrayList<>();
		int targetAlp = 0;
		int targetCop = 0;
		for (int[] problem : problems) {
			targetAlp = Math.max(targetAlp, problem[0]);
			targetCop = Math.max(targetCop, problem[1]);
			problemList.add(new Problem(problem[0], problem[1], problem[2], problem[3], problem[4]));
		}

		// 시간 채우면 알고력 코딩력이 올라가는 것이 필요함.
		problemList.add(new Problem(0, 0, 1, 0, 1));
		problemList.add(new Problem(0, 0, 0, 1, 1));

		PriorityQueue<MyAbility> pq = new PriorityQueue<>();
		pq.offer(new MyAbility(alp, cop, 0));
		int times[][] = new int[151][151];
		for (int i = 0; i < 151; i++) {
			Arrays.fill(times[i], 9999);
		}

		Collections.sort(problemList, (a, b) -> a.time - b.time);
		times[alp][cop] = 0;

		while (!pq.isEmpty()) {
			MyAbility ability = pq.poll();

			if (times[ability.alp][ability.cop] < ability.time)
				continue;

			if (ability.alp == targetAlp && ability.cop == targetCop) {
				return ability.time;
			}

			for (Problem problem : problemList) {
				if (!problem.canSolve(ability.alp, ability.cop))
					continue;
				int nextAlg = ability.alp + problem.rewardAlg;
				int nextCop = ability.cop + problem.rewardCop;
				int nextTime = ability.time + problem.time;

				if (nextAlg > targetAlp) {
					nextAlg = targetAlp;
				}
				if (nextCop > targetCop) {
					nextCop = targetCop;
				}

				if (times[nextAlg][nextCop] < nextTime) {
					continue;
				}

				times[nextAlg][nextCop] = nextTime;
				pq.offer(new MyAbility(nextAlg, nextCop, nextTime));
			}
		}

		return 0;
	}

	class MyAbility implements Comparable<MyAbility> {
		int alp, cop, time;

		public MyAbility(int alp, int cop, int time) {
			this.alp = alp;
			this.cop = cop;
			this.time = time;
		}

		@Override
		public int compareTo(MyAbility o) {
			return time - o.time;
		}
	}

	class Problem {
		int conditionAlg, conditionCop;
		int rewardAlg, rewardCop;
		int time;

		public Problem(int conditionAlg, int conditionCop, int rewardAlg, int rewardCop, int time) {
			this.conditionAlg = conditionAlg;
			this.conditionCop = conditionCop;
			this.rewardAlg = rewardAlg;
			this.rewardCop = rewardCop;
			this.time = time;
		}

		public boolean canSolve(int myAlp, int myCop) {
			return this.conditionAlg <= myAlp && this.conditionCop <= myCop;
		}
	}
}
