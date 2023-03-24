package BaekJoon.tony.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class CastleDefence {
	/**
	 * 궁수는 동시에 공격한다.
	 * 가까운 적이 여럿일 경우 가장 왼쪽에 있는 적을 공격한다.
	 * 같은 적이 여러 궁수에게 공격당할 수 있다.
	 *
	 * 궁수의 공격으로 제거할 수 있는 적의 최대 수를 계산하자
	 *
	 * 궁수의 칸이 주어지지 않는다. 내가 배치해야 된다. = 격자판의 N번행의 바로 아래(ㄱN+1번 행)의 모든 칸에는 성이 있다.거기에 궁수가 있음.
	 * 궁수를 어디에다가 배치해야 하는지, 궁수가 있다면 적이 0에서 더이상 갈곳이 없다면 어떻게 되는거지? = 적은 아래로 한 칸 이동하며, 성이 있는 칸으로 이동한 경우에는 게임에서 제외된다.
	 * 적이 궁수자리를 침범하는 그런경우는 라면 게임을 종료해야 하는지? - 적은 그냥 게임에서 제외 된다.
	 */

	static class Node {
		int y, x;

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}

		public int getDist(int y, int x) {
			return Math.abs(this.y - y) + Math.abs(this.x - x);
		}
	}

	static int n, m, d, answer;

	static int map[][];

	static List<Node> attackers = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(reader.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());

		map = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(reader.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		selectAttackerPosition(0, 0);
		System.out.println(answer);
	}

	public static void selectAttackerPosition(int cnt, int idx) {
		if (cnt == 3) {
			answer = Math.max(answer, startGame());
			return;
		}

		for (int i = idx; i < m; i++) {
			attackers.add(new Node(n, i));
			selectAttackerPosition(cnt + 1, i + 1);
			attackers.remove(attackers.size() - 1);
		}
	}

	public static int startGame() {
		int completeCnt = 0;
		int[][] copy = copy();

		for (int turn = 0; turn < n; turn++) {
			List<Node> enemies = new ArrayList<>();

			// 궁수가 공격할 적 찾아내기
			for (Node attacker : attackers) {
				Node enemy = searchEnemy(copy, attacker);

				if (enemy != null) {
					// 적이 존재하면 적 위치 바로제거하면 안됨 : 궁수가 똑같은 적을 공격할 수 있음.
					enemies.add(enemy);
				}
			}

			// 적 제거
			for (Node enemy : enemies) {
				if (copy[enemy.y][enemy.x] == 0) {
					continue;
				}

				copy[enemy.y][enemy.x] = 0;
				completeCnt++;
			}

			// 적 아래로 이동
			for (int i = n - 1; i > 0; i--) {
				for (int j = 0; j < m; j++) {
					copy[i][j] = copy[i - 1][j];
				}
			}

			// 맨 윗칸은 0으로 만들어 줘야함.
			for (int j = 0; j < m; j++) {
				copy[0][j] = 0;
			}

		}

		return completeCnt;
	}

	private static Node searchEnemy(int[][] copy, Node attacker) {
		Node enemy = null;

		int minDist = Integer.MAX_VALUE;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (copy[i][j] == 1) {// 적의 위치면
					int dist = attacker.getDist(i, j);

					if (isOutOfRange(dist)) { // 사정거리 밖이면 pass
						continue;
					}

					if (minDist > dist) {
						enemy = new Node(i, j);
						minDist = dist;
					} else if (minDist == dist) {
						if (enemy != null && enemy.x > j) {
							enemy = new Node(i, j);
						}
					}
				}
			}
		}

		return enemy;
	}

	private static boolean isOutOfRange(int dist) {
		return dist > d;
	}

	private static int[][] copy() {
		int cp[][] = new int[n][m];

		for (int i = 0; i < n; i++) {
			cp[i] = map[i].clone();
		}

		return cp;
	}
}
