package programmers.basic;

public class InstallingBaseStation {
	public int solution(int n, int[] stations, int w) {
		int answer = 0;
		int idx = 0;
		int location = 1;

		while (location <= n) {
			if (idx < stations.length && location >= stations[idx] - w) {
				while (idx < stations.length && location >= stations[idx] - w) {
					location = stations[idx++] + w + 1;
				}
			} else {
				location += (2 * w) + 1;
				answer++;
			}
		}

		return answer;
	}
}
