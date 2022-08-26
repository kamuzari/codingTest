package programmers.mockquestions.bundle2;

public class factorNumberingAndPlus {
	/**
	 note : left <= i <= right 까지 약수의 개수를 구한다.
	  core: 약수의 개수는 어떻게 구할 것인가?
	    - 최대 1000 * 1000이니 시간 초과는 안걸리겠다.
	 */
	public int solution(int left, int right) {
		int answer = 0;
		for(int val=left; val<=right; val++){
			int count=getDivisors(val);

			if(count %2==0){
				answer+=val;
			}else{
				answer-=val;
			}

		}

		return answer;
	}

	public int getDivisors(int value){
		int count=0;

		for(int i=1; i<=value; i++){
			if(value % i !=0){
				continue;
			}

			count++;
		}

		return count;
	}
}
