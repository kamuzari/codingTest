package BaekJoon._자료구조구현.try2.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class CorrectBracket {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		int testCase = parese(reader.readLine());

		while (testCase-- > 0) {
			Stack<Character> s = new Stack<>();
			for (char bracket : reader.readLine().toCharArray()) {
				if (bracket == '(') {
					s.push(bracket);
				} else {
					if (!s.isEmpty() && s.peek() == '(') {
						s.pop();
					}else{
						s.push('-');
						break;
					}
				}
			}

			if (s.isEmpty()) {
				answer.append("YES");
			} else {
				answer.append("NO");
			}

			answer.append("\n");
		}

		System.out.println(answer);
	}

	static int parese(String s) {
		return Integer.parseInt(s);
	}
}
