package BaekJoon._자료구조구현.try2.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class IronBar {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		char[] brackets = reader.readLine().toCharArray();
		// 이전에 바로 여는 괄호였고 바로 닫는 경우 였다면 자르기만 하면되고
		// 그 전에 여는 괄호가 아니였다면 그냥 막대기 하나 ++1
		// 길이가 끝난 막대기는 그냥 하나 잘리는데 이것을 어떻게 처리하면 좋을까? (detail)
		// - 레이저는 이전 문자가 열고 닫음이 연속적일때이다. 그러니 이전 괄호여부 현재 여부가 레이저이면
		// - 스택에 쌓인 여는 괄호로 정답 데이터에 더하고
		// - 레이저가 아닌 경우는 := 길이가 다한 막대기이니 하나만 추가한다.(마지막에 자동 잘려나간 막대)
		Stack<Character> s = new Stack<>();
		int answer = 0;
		char previous = '-';
		boolean isPreviousOpen = false;
		for (char bracket : brackets) {

			if (bracket == '(') {
				s.push(bracket);
			} else {
				boolean isLaser = previous == '(' && bracket == ')';
				s.pop();

				if (isLaser) {
					answer += s.size();
				} else {
					answer++;
				}
			}
			previous = bracket;
		}

		System.out.println(answer);
	}
}
