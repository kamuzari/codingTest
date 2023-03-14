package BaekJoon.tony.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class WizardSharFireBall {
	static int dy[] = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int dx[] = {0, 1, 1, 1, 0, -1, -1, -1};
	private static int n;

	static class FireBall {
		int y, x, amount, speed, dir;

		public FireBall(int y, int x, int amount, int speed, int dir) {
			this.y = y;
			this.x = x;
			this.amount = amount;
			this.speed = speed;
			this.dir = dir;
		}

		public int getAmount() {
			return amount;
		}

		public int getSpeed() {
			return speed;
		}

		public int getDir() {
			return dir;
		}

		public FireBall getNext() {

			int ny = (this.y + dy[dir] * (speed % n) + n) % n;
			int nx = (this.x + dx[dir] * (speed % n) + n) % n;

			return new FireBall(ny, nx, amount, speed, dir);
		}

	}

	static LinkedList<FireBall> map[][];

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(reader.readLine());
		// 격자 크기
		n = Integer.parseInt(st.nextToken());
		map = new LinkedList[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = new LinkedList<>();
			}
		}

		int m = Integer.parseInt(st.nextToken()); // 파이어볼 개수
		int k = Integer.parseInt(st.nextToken()); // 명령문의 개수

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(reader.readLine());
			int y = Integer.parseInt(st.nextToken()) - 1;
			int x = Integer.parseInt(st.nextToken()) - 1;
			int amount = Integer.parseInt(st.nextToken());
			int speed = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());

			FireBall fireBall = new FireBall(y, x, amount, speed, dir);

			map[y][x].add(fireBall);
		}

		while (k-- > 0) {

			// 1. 이동
			map = move();
			// 2. 2개이상의 파이어볼 찾고 합치기
			integrate();
		}

		int answer = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				LinkedList<FireBall> fireBalls = map[i][j];
				if (fireBalls.isEmpty())
					continue;

				answer += fireBalls
					.stream()
					.map(FireBall::getAmount)
					.reduce(Integer::sum)
					.orElseGet(() -> 0);
			}
		}

		System.out.println(answer);
	}

	// 2-4 질량이 0인 파이어볼은 소멸되어 없어진다. 조건 잘 봐야함 그리고 [소멸되어 없어짐은 곧 해당 배열에 있는 기존 파이어볼도 다 없애야 함.]
	private static void integrate() {

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				LinkedList<FireBall> fireBalls = map[i][j];

				if (fireBalls.size() < 2)
					continue;

				Integer totalAmount = fireBalls.stream()
					.map(FireBall::getAmount)
					.reduce(Integer::sum)
					.orElseGet(() -> 0);

				if (totalAmount / 5 == 0) {
					map[i][j].clear();
					continue;
				}

				Integer totalSpeed = fireBalls.stream()
					.map(FireBall::getSpeed)
					.reduce(Integer::sum)
					.orElseGet(() -> 0);
				List<Integer> dirs = fireBalls.stream().map(FireBall::getDir).collect(Collectors.toList());

				boolean isEven = dirs.stream().allMatch(dir -> dir % 2 == 0);
				boolean isOdd = dirs.stream().allMatch(dir -> dir % 2 == 1);

				LinkedList<FireBall> newLists = new LinkedList<>();
				if (isEven || isOdd) {

					for (int dir = 0; dir < 8; dir += 2) {
						newLists.add(
							new FireBall(
								i,
								j,
								totalAmount / 5,
								totalSpeed / fireBalls.size(),
								dir)
						);
					}

				} else {
					for (int dir = 1; dir < 8; dir += 2) {
						newLists.add(
							new FireBall(
								i,
								j,
								totalAmount / 5,
								totalSpeed / fireBalls.size(),
								dir)
						);
					}
				}

				map[i][j] = newLists;
			}
		}
	}

	// 이미 이동을 했음에도 불구하고 배열을 순회할때 중복으로 움직이는 이슈가 있어 복사해야함.
	private static LinkedList<FireBall>[][] move() {
		LinkedList<FireBall> newMap[][] = new LinkedList[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				newMap[i][j] = new LinkedList<>();
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				LinkedList<FireBall> fireBalls = map[i][j];

				while (!fireBalls.isEmpty()) {
					FireBall cur = fireBalls.poll();
					FireBall next = cur.getNext();

					newMap[next.y][next.x].add(next);
				}
			}
		}

		return newMap;
	}
}
