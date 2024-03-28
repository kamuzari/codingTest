package programmers.coding99;

public class MagicElevator {
	public int solution(int storey) {
		int answer = 0;
		int v = storey;

		while (v > 0) {
			int digit = v % 10;
			v /= 10;

			if (digit == 5) {
				if (v % 10 >= 5) { // 앞자리 생각하기 (5가 연속으로 나누는 경우를 고려) 555
					answer += (10 - digit);
					v++;// 앞자리 숫자 더하기
				} else {
					answer += digit;
				}
			} else if (digit > 5) {
				answer += (10 - digit);
				v++;
			} else {
				answer += digit;
			}
		}

		return answer;
	}
}
