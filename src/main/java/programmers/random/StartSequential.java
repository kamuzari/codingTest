package programmers.random;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class StartSequential {
	public static void main(String[] args) {

	}

	public int solution(int[] a) {
		int answer = 0;
		Map<Integer, Integer> numberCounts = new HashMap<>(); // 숫자: 출현빈도
		Arrays.stream(a)
				.forEach(number -> numberCounts.put(number, numberCounts.getOrDefault(number, 0) + 1));

		for (Integer commonNumber : numberCounts.keySet()) {
			int length = 0;
			// 현재 정답 answer 보다 더 많은 중복된 수를 가지고 있으며 그것에 *2인 길이를 2배로 했을 때 현재 정답보다
			// 작으면 가치가 없는 것으로 불필요한 부분을 조금은 덜어 낼 수 있다.
			if(answer >= numberCounts.get(commonNumber) *2) continue; // 이거 없으면 TLE
			for (int i = 0; i < a.length - 1; i++) {
				boolean isContainCommonNumber = commonNumber == a[i] || commonNumber == a[i + 1];
				if (isContainCommonNumber) {
					boolean givenCondition = a[i] != a[i + 1];
					if (givenCondition) {
						length += 2;
						i++;
					}
				}
			}

			answer = Math.max(answer, length);
		}

		return answer;
	}
}
