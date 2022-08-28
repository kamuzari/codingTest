package programmers.mockquestions.bundle22;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TakingTwoAndAdd {
	public int[] solution(int[] numbers) {

		Set<Integer> results=new HashSet<>();

		for(int i=0; i<numbers.length; i++){
			for(int j=i+1; j<numbers.length; j++){
				results.add(numbers[i]+numbers[j]);
			}
		}
		int[] answer=new int[results.size()];
		int idx=0;

		for(int val:results){
			answer[idx++]=val;
		}

		Arrays.sort(answer);

		return answer;
	}
}
