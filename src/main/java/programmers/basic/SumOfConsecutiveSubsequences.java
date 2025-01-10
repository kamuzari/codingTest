package programmers.basic;

public class SumOfConsecutiveSubsequences {
	public int[] solution(int[] sequence, int k) {
		int[] answer = new int[2];
		int s = 0;
		int e = 0;
		int minLength = Integer.MAX_VALUE;
		int sum = 0;

		while (true) {
			if (sum < k) {
				boolean isOutOfRange = e >= sequence.length;
				if (isOutOfRange) {
					break;
				}

				sum += sequence[e];
				e++;
			} else if (sum > k) {
				sum -= sequence[s];
				s++;
			} else {
				int length = e - s;
				if (minLength > length) {
					minLength = length;
					answer[0] = s;
					answer[1] = e - 1;
				}

				sum -= sequence[s];
				s++;
			}
		}

		return answer;
	}
}
