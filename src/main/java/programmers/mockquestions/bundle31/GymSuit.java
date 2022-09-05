package programmers.mockquestions.bundle31;

public class GymSuit {
	private static final int HAVE_NOT_SUIT = -1;

	public int solution(int n, int[] lost, int[] reserve) {
		int answer = n;
		int persons[] = new int[n];
		for (int l : lost) {
			persons[l - 1]--;
		}

		for (int r : reserve) {
			persons[r]++;
		}

		for (int i = 0; i < n; i++) {
			if (persons[i] == HAVE_NOT_SUIT) {
				if (i - 1 >= 0 && persons[i - 1] == 1) {
					persons[i]++;
					persons[i - 1]--;
				} else if (i + 1 < persons.length && persons[i + 1] == 1) {
					persons[i]++;
					persons[i + 1]--;
				} else
					answer--;
			}
		}

		return answer;
	}
}
