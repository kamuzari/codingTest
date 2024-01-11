package saffy.a형기출문제집;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PlusBracket {
	// 왼쪽 연산을 하는 특징.. 을 더불어

	/**
	 * 왼쪽 연산을 하는 특징.. 을 더불어
	 * dfs를 돌린다..
	 * 그래서 depth가 기업지는 만큼 연산자를 가져온다.
	 *
	 * @param args
	 */
	private static int answer = Integer.MIN_VALUE;
	private static List<Character> operators;
	private static List<Integer> numbers;

	public static void main(String[] args) {
		// 괄호 추가가 아닌 .. 그냥 연산 작업을 진행하면 될 것 같다.
		Scanner sc = new Scanner(System.in);

		int n = toInt(sc.nextLine());
		String expression = sc.nextLine();
		numbers = Arrays.stream(expression.split("\\*|\\+|-"))
				.map(Integer::parseInt)
				.collect(Collectors.toList());
		operators = new ArrayList<>();
		for (char operator : expression.toCharArray()) {
			if (operator == '+' || operator == '*' || operator == '-') {
				operators.add(operator);
			}
		}

		dfs(0, numbers.get(0));
		System.out.println(answer);
	}

	private static void dfs(int depth, int sum) {
		if (depth == operators.size()) {
			answer = Math.max(answer, sum);
			return;
		}

		// 연산자 우선순위 상관없이 왼쪽 부터 계산 하는 특징
		int summaryForLeft = calculate(depth, sum, numbers.get(depth + 1));
		dfs(depth + 1, summaryForLeft);

		if (depth + 1 < operators.size()) {
			int summaryInBracket = calculate(depth + 1, numbers.get(depth + 1), numbers.get(depth + 2));
			int totalSummary = calculate(depth, sum, summaryInBracket);
			dfs(depth + 2, totalSummary);
		}
	}

	private static int calculate(int operatorIndex, int a, int b) {
		Character operator = operators.get(operatorIndex);
		switch (operator) {
			case '+':
				return a + b;
			case '*':
				return a * b;
			case '-':
				return a - b;
		}

		throw new RuntimeException("fatal logic error");
	}

	private static int toInt(String s) {
		return Integer.parseInt(s);
	}
}
