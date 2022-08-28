package programmers.mockquestions.bundle22;

import java.util.Stack;

public class ReversingTernaryNumeral {

	// note: 3,7번 실패 ..
	public int solution(int n) {
		int answer = 0;
		String three=translate3(n);

		return translate10(three);
	}

	public String translate3(int n){
		Stack<Integer> s=new Stack<>();

		while(n>=3){ // 엣지케이스 n > 3 작을 때 조건으로 해서 n=3 일때에는  1 이나와야 하는데 3 이나왔음...
			s.push(n%3);
			n=n/3;
		}

		s.push(n);

		StringBuilder three=new StringBuilder();

		while(!s.isEmpty()){
			three.append(s.pop());
		}

		return three.reverse().toString();
	}

	public int translate10(String n){
		int size=n.length();
		int answer=0;

		for(int i=size-1; i>=0; i--){
			int val=n.charAt(i)-'0';
			answer+=(Math.pow(3,size-(i+1))*val);
		}

		return answer;
	}
}
