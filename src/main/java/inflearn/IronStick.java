package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class IronStick {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		/**
		 * how : 접근을 어떻게 해야하는가?
		 *   - 레이저는 여는 괄호와 닫는 괄호가 바로 다음에 올 떄 잘린다.
		 *   - 막대기 범위는 닫힌 괄호가 끝이다. (단, 레이저가 아닐때)
		 *     - 막대기 범위가 마지막인 순간 1개가 추가된다.
		 *   - 레이저를 쏘고 왼쪽 단면을 보면서 막대기 잘린 수를 파악한다 ( 스택의 열린 괄호의 개수 )
		 */
		int answer = 0;
		Stack<Character> s = new Stack<>();
		char[] brackets = reader.readLine().toCharArray();

		for (int i = 0; i < brackets.length; i++) {
			char ch = brackets[i];

			if (ch == '(') {
				s.push(ch);
			} else {
				if (brackets[i - 1] == ')') {
					answer++;
				} else {
					answer += s.size() - 1;
				}
				s.pop();
			}
		}

		System.out.println(answer);
	}
}
