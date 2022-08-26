package programmers.mockquestions.bundle1;

import java.util.Stack;

public class BIgNumber {
	public static String solution(String number, int k) {
		Stack<Integer> s = new Stack<>();
		int n=number.length();

		for (int i = 0; i < n; i++) {
			int ch = number.charAt(i)-'0';
			while (!s.isEmpty() && s.peek() < ch && k > 0) {
				s.pop();
				k--;
			}
			s.push(ch);
		}
		StringBuilder answer=new StringBuilder();

		while(!s.isEmpty()){
			if(k>0) {
				k--;
				s.pop(); continue;
			}
			answer.append(s.pop());
		}

		return answer.reverse().toString();
	}
}
