package programmers.mockquestions.bundle42;

import java.util.HashSet;
import java.util.Set;

public class Phoketmon {
	public int solution(int[] nums) {
		int answer=nums.length / 2;

		Set<Integer> kinds=new HashSet<>();

		for(int val:nums){
			kinds.add(val);
		}

		if(kinds.size() >= answer){
			return answer;
		}

		return kinds.size();
	}
}
