package programmers.random;

import java.util.Arrays;

public class BestSet {
	private final int[] NOT_FOUND_ANSWER = {-1};
	public int[] solution(int n, int s) {


		// 문제 n개의 자연수를 뽑고 그 합이 s이며 곱이 가장 최대가 되어야 한다.
		/**
		 n  / 2 -> 중앙값 기준으로
		 오른쪽 왼쪽을 뽑는다.-> 그런데 그 합이 s인지는 판단할 수 없다..
		 곱을 가장 최대로 할 수는 있지만 그 합이 s인지는 보장할 수 없다.
		 어떻게 하면 합이 s인지를 1+2 +... + n = s

		 중복이 안된다는 말을 한적이 없음.
		 표준편차가 가장 작아야 곱이 가장 커진다.
		 인접한 수의 합으로 s를 n개 만들고
		 나머지를 각 인덱스에 +1 을 해준다.
		 그러면 s/n으로 나눈 값이 n개 들어가며 나머지 값을 각 인덱스에 추가해주면서 준편차가 가장 작아진다.
		 결국 곱이 값이 가장 커짐과 동시에 n개의 값이 s가 된다.
		 */

		if(s <n){
			return NOT_FOUND_ANSWER;
		}

		int[] answer=new int[n];
		int midiumValue = s/n;
		Arrays.fill(answer, midiumValue);
		int index=answer.length-1;
		int rest = s%n;

		while(rest-->0){
			answer[index]++;
			index--;
		}

		return answer;
	}
}
