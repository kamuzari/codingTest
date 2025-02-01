package programmers.basic;

public class ForecastVsTable {
	public int solution(int n, int a, int b) {
		int answer = 0;
		while (a != b) {
			if (!isEven(a)) {
				a += 1;
			}

			if (!isEven(b)) {
				b += 1;
			}

			a /= 2;
			b /= 2;
			answer++;
		}

		return answer;
	}

	public boolean isEven(int val) {
		return val % 2 == 0;
	}
}
