package programmers.mockquestions.bundle42;

import java.util.LinkedList;
import java.util.Stack;
import java.util.stream.Collectors;

public class BracketRotate {
	public int solution(String s) {
		int answer = 0;

		LinkedList<Character> q=new LinkedList<>();

		for(int i=0; i<s.length(); i++){
			q.offer(s.charAt(i));
		}

		if(isProperString(s)){
			answer++;
		}

		for(int i=1; i<s.length(); i++){
			q.offer(q.pop());
			String str=q.stream().map(String::valueOf).collect(Collectors.joining());
			if(isProperString(str)){
				answer++;
			}
		}

		return answer;
	}


	public boolean isProperString(String str){
		Stack<Character> s=new Stack();

		for(int i=0; i<str.length(); i++){
			char ch=str.charAt(i);
			if(ch == '[' || ch == '(' || ch == '{'){
				s.push(ch);
			}else{
				// 닫는 괄호만 여기

				if(s.isEmpty()){
					return false;
				}else{
					// 같은 모양 인가.
					char peek=s.peek();
					if(peek == '[' && ch == ']'){
						s.pop();
					}else if(peek == '(' && ch == ')'){
						s.pop();
					}else if(peek == '{' && ch == '}'){
						s.pop();
					}else{
						return false;
					}

				}
			}
		}

		return s.isEmpty();
	}
}
