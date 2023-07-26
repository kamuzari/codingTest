package BaekJoon._자료구조구현.try2.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class PostFixNotation {
	public static void main(String[] args) throws IOException {
		// stack 에 연산자를 모두 넣는다.

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		String formula = reader.readLine();
		StringBuilder answer = new StringBuilder();
		Stack<Character> operations = new Stack<>();

		for (int i = 0; i < formula.length(); i++) {
			char current = formula.charAt(i);

			switch (current) {
				case '+':
				case '-':
				case '*':
				case '/':
					while (!operations.isEmpty() && getPriority(operations.peek()) >= getPriority(current)) {
						answer.append(operations.pop());
					}

					operations.push(current);
					break;
				case '(':
					operations.push(current);
					break;
				case ')':
					while (!operations.isEmpty() && operations.peek() != '(') {
						answer.append(operations.pop());
					}

					if (!operations.isEmpty() && operations.peek() == '(') {
						operations.pop();
					}

					break;
				default:
					answer.append(current);
			}
		}

		while (!operations.isEmpty()) {
			answer.append(operations.pop());
		}

		System.out.println(answer);
	}

	static int getPriority(char operator) {
		if (operator == '(' || operator == ')') {
			return 0;
		} else if (operator == '+' || operator == '-') {
			return 1;
		} else if (operator == '*' || operator == '/') {
			return 2;
		}

		return -1;
	}
}
