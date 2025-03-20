package programmers.basic;

public class NQueen {
	int N;
	int[] pick;
	int answer = 0;

	public int solution(int n) {
		N = n;
		pick = new int[n];
		backTracking(0);

		return answer;
	}

	void backTracking(int cnt) {
		if (cnt == N) {
			answer++;
			return;
		}

		for (int i = 0; i < N; i++) {
			if (isPut(cnt, i)) {
				pick[cnt] = i;
				backTracking(cnt + 1);
			}
			;

		}
	}

	boolean isPut(int id, int c) {
		for (int i = 0; i < id; i++) {
			if (pick[i] == c) {
				return false;
			}
			int rowInterval = id - i;
			boolean isCross = rowInterval == Math.abs(pick[i] - c);
			if (isCross) {
				return false;
			}
		}

		return true;
	}
}
