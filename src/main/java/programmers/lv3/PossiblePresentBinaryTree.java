package programmers.lv3;

import java.util.ArrayList;
import java.util.List;

public class PossiblePresentBinaryTree {
	public static void main(String[] args) {
		PossiblePresentBinaryTree possiblePresentBinaryTree = new PossiblePresentBinaryTree();
		possiblePresentBinaryTree.solution(new long[]{42});
	}
	/**
	 요구사항: 숫자를 이진트리로 표현할 수 있다면 1을, 없으면 0을 출력하는 문제이다.

	 필요한 전처리 과정
	 1.숫자를 이진트리 자료구조로 표현하라.
	 - 10진수 숫자 2진수로 표현
	 - 이진수 0을 더미 1을 노드로 표현한다.
	 - 7 -> 0000 0111
	 - 42 -> 0010 1010
	 - 더미를 추가함에 따라 42
	 0을 몇개 추가해야 한가 그리고 포화이진트리인지 확인해야 한다.
	 0을 앞에다가 추가하지 않으면 값이 바껴서 안됨
	 */
	public int[] solution(long[] numbers) {
		List<Integer> answer = new ArrayList<>();

		for (long val : numbers) {
			String binary = Long.toBinaryString(val);
			int i = 0;
			while ((int)Math.pow(2, i) - 1 < binary.length()) {
				i++;
			}

			while((int)Math.pow(2, i)-1 != binary.length()) {
				binary = "0"+ binary;
			}

			if (isValid(binary)) {
				answer.add(1);
			} else {
				answer.add(0);
			}
		}

		return answer.stream()
			.mapToInt(v -> v)
			.toArray();
	}

	boolean isPossible = true;

	public boolean isValid(String binary) {
		isPossible=true;
		dfs(binary);

		return isPossible;
	}

	public void dfs(String str) {
		if (!isPossible) {
			return;
		}

		int midIdx = str.length() / 2;
		int root = str.charAt(midIdx);
		String left = str.substring(0, midIdx);
		String right = str.substring(midIdx + 1, str.length());
		// 모두 더미일수도 있음.
		// if (root == '0' && left.length() > 0 && right.length() > 0) {
		// 	isPossible = false;
		// 	return;
		// }

		if(root == '0' && (left.charAt(left.length()/2) =='1' || right.charAt(right.length()/2) =='1')){
			isPossible=false;
			return;
		}

		if (left.length() >=3) {
			dfs(left);
		}

		if (right.length() >=3) {
			dfs(right);
		}
	}
}
