package programmers.lv2;

import java.util.Stack;

public class SearchTailBigNumber {
	/** 어떻게 구현하지? [오큰수랑 유사한듯.]
	 stack인건 같은데 어떻게 했더라..
	 n ^ 2 bye
	 stack에 인덱스를 넣어보자
	 */
	public int[] solution(int[] numbers) {
		int n=numbers.length;
		int[] answer = new int[n];
		Stack<Integer> s=new Stack();
		s.push(0);

		for(int i=1; i<n; i++){
			int next=numbers[i];

			while(!s.isEmpty()&& numbers[s.peek()]<next){
				answer[s.pop()]=next;
			}

			s.push(i);
		}

		while(!s.isEmpty()){
			answer[s.pop()]=-1;
		}

		return answer;
	}
}
