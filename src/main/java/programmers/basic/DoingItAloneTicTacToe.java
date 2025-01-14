package programmers.basic;

import java.util.HashSet;
import java.util.Set;

public class DoingItAloneTicTacToe {
	public int solution(String[] board) {
		int answer = -1;
		int n = board.length;
		int m = board[0].length();

		char[][] b = new char[n][m];
		for (int i = 0; i < n; i++) {
			b[i] = board[i].toCharArray();
		}

		int oCnt = 0;
		int xCnt = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (b[i][j] == 'O') {
					oCnt++;
				} else if (b[i][j] == 'X') {
					xCnt++;
				}
			}
		}

		if (oCnt == xCnt || oCnt == xCnt + 1) {
			int oBingo = 0;
			int xBingo = 0;

			// 가로 빙고 점검
			for (int i = 0; i < n; i++) {
				Set<Character> sets = new HashSet<>();
				for (int j = 0; j < m; j++) {
					sets.add(b[i][j]);
				}
				if (!sets.contains('.')) {
					if (sets.contains('O') && !sets.contains('X')) {
						oBingo++;
					} else if (sets.contains('X') && !sets.contains('O')) {
						xBingo++;
					}
				}
			}

			// 세로 빙고 점검
			for (int i = 0; i < m; i++) {
				Set<Character> sets = new HashSet<>();
				for (int j = 0; j < n; j++) {
					sets.add(b[j][i]);
				}
				if (!sets.contains('.')) {
					if (sets.contains('O') && !sets.contains('X')) {
						oBingo++;
					} else if (sets.contains('X') && !sets.contains('O')) {
						xBingo++;
					}
				}
			}

			//  x 대각선 점검
			Set<Character> container = new HashSet<>();
			container.add(b[0][0]);
			container.add(b[1][1]);
			container.add(b[2][2]);
			if (!container.contains('.')) {
				if (container.contains('O') && !container.contains('X')) {
					oBingo++;
				} else if (container.contains('X') && !container.contains('O')) {
					xBingo++;
				}
			}
			container.clear();

			container.add(b[0][2]);
			container.add(b[1][1]);
			container.add(b[2][0]);
			if (!container.contains('.')) {
				if (container.contains('O') && !container.contains('X')) {
					oBingo++;
				} else if (container.contains('X') && !container.contains('O')) {
					xBingo++;
				}
			}

			if (oBingo == 0 && xBingo == 0) {
				return 1;
			}

			if (oBingo == 1 && xBingo == 0 && (oCnt == xCnt + 1)) {
				return 1;
			}

			if (oBingo == 0 && xBingo == 1 && (oCnt == xCnt)) {
				return 1;
			}

			/**
			 o x o
			 x . x -> . 있는데 o 들어가면 빙고 2개 , x는 2개의 빙고가 나올수 없음, 선공이 'O' 이기 때문에
			 o x o
			 */
			if (oBingo == 2 && xBingo == 0 && (oCnt == xCnt + 1)) {
				return 1;
			}

		}

		return 0;
	}
}
