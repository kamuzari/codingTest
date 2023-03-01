package programmers.lv2;

import java.util.Collections;
import java.util.PriorityQueue;

public class DefenseGame {
	/**
	 Q. 무적권을 언제 사용해야 적절한 시기라고 할 수있지?
	 - ?
	 1. round ^2 >=1억 (fail)

	 결론: 어떻게 해서든 2의 제곱은 안된다.
	 n을 제외하고 k, enemy길이로 선형으로 승부를 봐야함.
	 */
	public int solution(int n, int k, int[] enemy) {
		int answer = enemy.length;
		PriorityQueue<Integer> rollbacks=new PriorityQueue<>(Collections.reverseOrder());

		for(int round=0; round<enemy.length; round++){
			n-=enemy[round];
			rollbacks.offer(enemy[round]);

			if(n<0){
				if(!rollbacks.isEmpty() && k>0){
					n+=rollbacks.poll();
					k--;
				}else{
					answer=round;
					break;
				}
			}
		}

		return answer;
	}
}
