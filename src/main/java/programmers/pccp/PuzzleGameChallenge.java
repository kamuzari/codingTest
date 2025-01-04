package programmers.pccp;

public class PuzzleGameChallenge {
	/**
	 * 입출력 14번 edge case
	 *   - 최소 레벨은 0이 될 수 없음
	 *
	 * @param diffs : 각 문제별 레벨
	 * @param times : 각 문제를 푸는데 걸린 시간
	 * @param limit : 총 소요시간의 제한시간
	 * @return 제한시간(limit) 내 해결하는데 필요한 최소 숙련도의 최솟값
	 */
	public int solution(int[] diffs, int[] times, long limit) {
		int answer = Integer.MAX_VALUE;

		int start = 1;
		int end = 100_000;
		while (start <= end) {
			int mid = (start + end) >> 1;

			if (isPossible(mid, diffs, times, limit)) {
				answer = Math.min(answer, mid);
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}

		return answer;
	}

	private boolean isPossible(int promiseLevel, int[] diffs, int[] times, long limit) {
		long totalTime = 0;
		int previousProblemSolvingTime = 0;

		for (int i = 0; i < diffs.length; i++) {
			if (promiseLevel >= diffs[i]) {
				totalTime += (long)times[i];
			} else {
				int failCount = diffs[i] - promiseLevel;
				int timePerCount = times[i] + previousProblemSolvingTime;
				totalTime += (long)timePerCount * (long)failCount + (long)times[i];
			}

			previousProblemSolvingTime = times[i];
		}

		return totalTime <= limit;
	}
}
