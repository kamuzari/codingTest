package programmers.lv2;

public class OverWriting {
	/**
	 예산을 아끼기 위해 페인트를 칠하는 횟수를 최소화하라.
	 */
	public int solution(int n, int m, int[] section) {
		int answer = 1;
		int cur=section[0];

		for(int i=1; i<section.length; i++){
			if(cur+m-1>=section[i]){
				continue;
			}else{
				cur=section[i];
				answer++;
			}
		}


		return answer;
	}
}
