package programmers.mockquestions.bundle1;

import java.util.Arrays;

public class PermutationCheck {
	/**
	 * note : https://www.notion.so/bylog/1-470cca0bab414a5c93875b9e67408733
	 */
	public boolean solution(int[] arr) {
		Arrays.sort(arr);

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != i + 1) {
				return false;
			}
		}

		return true;
	}
}
