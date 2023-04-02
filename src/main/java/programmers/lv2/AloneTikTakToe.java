package programmers.lv2;

public class AloneTikTakToe {
	public static void main(String[] args) {
		AloneTikTakToe aloneTikTakToe = new AloneTikTakToe();
		System.out.println(aloneTikTakToe.solution(new String[] {"O.X", ".O.", "..X"}));
		System.out.println(aloneTikTakToe.solution(new String[] {"OOO", "...", "XXX"}));
		System.out.println(aloneTikTakToe.solution(new String[] {"...", ".X.", "..."}));
		System.out.println(aloneTikTakToe.solution(new String[] {"...", "...", "..."}));
	}

	/**
	 * 선공 'O' 후공 'X'
	 * 가로, 세로, 대각선 3개가 같은 표시가 만들어지면 해당 사람이 승리.
	 * 9칸이 다차서 더이상 표기 할 수 없는 경우 무승부로 게임 종료
	 *
	 * 규칙을 어기는 실수를 했으면 0 실수를 안했으면 1을 반환하는 함수를 작성하시오
	 *
	 * note: 실수하는 경우
	 *  - 후공('x')가 더 많이 표현되어 있는 경우
	 *  - 선공도 3칸, 후공도 연속된 3칸을 가진경우
	 *
	 *
	 * 위반한경우,
	 *   1. x가 더 많음 (위반)
	 *   2. o가 2개이상 많은 경우
	 *   3. 둘 다 이긴 경우
	 *   4. o가 이겼지만 x보다 1개 더 많지 않을 경우
	 *   5. x가 이겼지만 o,x의 개수가 같지 않을 경우
	 */
	static final int VIOLATION = 0;
	static final int FOLLOW_RULES = 1;
	int n, m;
	char map[][];

	public int solution(String[] board) {
		n = board.length;
		m = board[0].length();

		map = new char[n][m];
		for (int i = 0; i < n; i++) {
			map[i] = board[i].toCharArray();
		}

		if (isValidCount(map) & isLastValid(map)) {
			return FOLLOW_RULES;
		}

		return VIOLATION;
	}

	static int dy[] = {-1, 1, 0, 0, -1, 1, 1, -1};
	static int dx[] = {0, 0, -1, 1, -1, -1, 1, 1};

	public boolean isValidCount(char[][] map) {
		int cnt = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 'O') {
					cnt++;
				} else if (map[i][j] == 'X') {
					cnt--;
				}
			}
		}
		// x개수 <= o의개수 만족해야함 그리고 그 둘의 차이는 무조건 0또는 1이여 한다.
		return cnt == 0 || cnt == 1;
	}

	public boolean isLastValid(char[][] map) {
		int ticTakToe1 = 0;
		int ticTakToe2 = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {

				if (map[i][j] == 'O' || map[i][j] == 'X') {
					char pivot = map[i][j];
					for (int k = 0; k < 8; k++) {
						int ny = i + dy[k];
						int nx = j + dx[k];

						int nny = ny + dy[k];
						int nnx = nx + dx[k];

						if (isOutOfRange(ny, nx) || isOutOfRange(nny, nnx))
							continue;

						if (pivot == map[ny][nx] && pivot == map[nny][nnx]) {
							if (pivot == 'O') {
								ticTakToe1++;
							} else {
								ticTakToe2++;
							}
						}

						if (ticTakToe1 > 0 && ticTakToe2 > 0) { // 둘다 이긴경우 있을 수 없다. 누군가는 반드시 먼저 승리하고 끝나야 한다.
							return false;
						} else if (ticTakToe1 > ticTakToe2) { // 선공이 이긴경우는 무조건 1개 더 많아야한다.
							if (!isDiffOne()) {
								return false;
							}
						} else if (ticTakToe2 > ticTakToe1) { // x가 이길 때는 반드시 o와 개수가 같아야 한다 [o가 선공이기 때문에]
							if (!isDiffZero()) {
								return false;
							}

						}
					}
				}
			}
		}

		return true;
	}

	public boolean isDiffOne() {
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 'O')
					cnt++;
				else if (map[i][j] == 'X')
					cnt--;
			}
		}

		return cnt == 1;
	}

	public boolean isDiffZero() {
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 'O')
					cnt++;
				else if (map[i][j] == 'X')
					cnt--;
			}
		}

		return cnt == 0;
	}

	public boolean isOutOfRange(int ny, int nx) {
		return ny < 0 || nx < 0 || ny >= n || nx >= m;
	}
}
