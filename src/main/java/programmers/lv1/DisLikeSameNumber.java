package programmers.lv1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class DisLikeSameNumber {

	public int[] solution(int[] arr) {
		// resolve : get(i)시 링크드 리스트는 순회하는 문제로 효율성을 통과하지 못함.
		ArrayList<Integer> answer = new ArrayList<>();

		for (int val : arr) {
			int size = answer.size();

			if (size == 0) {
				answer.add(val);
				continue;
			}

			if (answer.get(size - 1) == val) {
				continue;
			}

			answer.add(val);
		}
		int[] results = new int[answer.size()];

		for (int i = 0; i < results.length; i++) {
			results[i] = answer.get(i);
		}

		return results;
	}

	/**
	 *  note : 정확성 100, 효율성 0
	 *  logic : 스택 넣고 -> StringBuilder로 뒤집기 -> Stream 처리
	 *  why : 왜 효율성을 통과하지 못할까..?
	 *  resolve : 스택 구현체 코드에서 배열의 사이즈 length 를 계속 구하는 이슈 때문에 효율성을 통과하지 못하는 것 같음
	 * @param arr
	 * @return
	 */
	private int[] getLogic(int[] arr) {
		Stack<Integer> s = new Stack<>();
		for (int val : arr) {
			if (s.isEmpty()) {
				s.push(val);
				continue;
			}

			if (s.peek() == val) {
				continue;
			}

			s.push(val);
		}

		StringBuilder results = new StringBuilder();

		while (!s.isEmpty()) {
			results.append(s.pop());
		}

		return Arrays.stream(results.reverse().toString().split(""))
			.mapToInt(Integer::parseInt)
			.toArray();
	}
}
