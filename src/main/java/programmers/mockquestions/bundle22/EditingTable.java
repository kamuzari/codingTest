package programmers.mockquestions.bundle22;

import java.util.Stack;

public class EditingTable {
	/** note:
	 *   삽입삭제가 빈번할 수 있으니 링크드리스트. 하지만 찾을 때.. n이라..
	 *   되돌리기는 stack
	 *   why? 이거는 왜틀리는 걸까..?
	 * 		 for (int i = 0; i < n; i++) {
	 * 			results.append('O');
	 *                }
	 *    while (!trash.isEmpty()) {
	 * 			results.setCharAt(trash.pop(), 'X');
	 *    }
	 *     -> CCCCC라는 명령어가 있다고 해보면 똑같은 인덱스가 계속 들어가니 .. 나중에 2번쨰 인덱스만 계속 변경이 일어나야 한다.
	 *      원래 대로 라면 2,3,4,5,6 번쨰에서 'X' 가들어가야 하는데 2번째에 대한 변경만 일어나니 XOOOOOO가 되믄다.
	 *
	*/
	public String solution(int n, int k, String[] cmd) {
		int tableSize = n;
		Stack<Integer> trash = new Stack<>();

		for (int i = 0; i < cmd.length; i++) {
			char ch = cmd[i].charAt(0);

			if (ch == 'U') {
				k -= Integer.parseInt(cmd[i].substring(2));
			} else if (ch == 'D') {
				k += Integer.parseInt(cmd[i].substring(2));
			} else if (ch == 'C') {
				trash.push(k);
				tableSize--;
				if (k == tableSize) {
					k--;
				}
			} else if (ch == 'Z') {
				int unDo = trash.pop();
				if (k >= unDo) {
					k++;
				}

				tableSize++;
			}
		}

		StringBuilder results = new StringBuilder();
		for (int i = 0; i < tableSize; i++) {
			results.append('O');
		}
		// 왜 setChar는 안되는 걸까..?
		while (!trash.isEmpty()) {
			results.insert(trash.pop().intValue(), 'X');
		}

		// why? 이거는 왜틀리는 걸까..?
		for (int i = 0; i < n; i++) {
			results.append('O');
		}

		while (!trash.isEmpty()) {
			results.setCharAt(trash.pop(), 'X');
		}

		return results.toString();
	}
}
