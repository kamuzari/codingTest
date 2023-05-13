package BaekJoon.tony.simulation;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class StartTaxi {
	//M명 태우기 목표
	static Scanner sc = new Scanner(System.in);
	static StringTokenizer st;
	static int n, m, fuel;
	static int map[][];
	static int sy, sx; // 백준이의 위치
	static Map<Integer, Passenger> passengers;

	static class Passenger {
		int idx, sy, sx, dy, dx;

		public Passenger(int idx, int a, int b, int c, int d) {
			this.idx = idx;
			this.sy = a;
			this.sx = b;
			this.dy = c;
			this.dx = d;
		}

		public String toString() {
			return String.format("<sy: %d sx: %d || dy: %d dx: %d>", sy, sx, dy, dx);
		}
	}

	static class Node {
		int idx, y, x, cnt;

		public Node(int y, int x, int cnt) {
			this.y = y;
			this.x = x;
			this.cnt = cnt;
		}

		public void setIdx(int id) {
			this.idx = id;
		}
	}

	public static void main(String[] args) {
		st = line();
		n = parse(next());
		m = parse(next());
		fuel = parse(next());

		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = line();
			for (int j = 0; j < n; j++) {
				map[i][j] = parse(next());
			}
		}

		st = line();
		sy = parse(next()) - 1;
		sx = parse(next()) - 1;

		passengers = new HashMap<>();
		int idx = 1;
		for (int i = 0; i < m; i++) {
			st = line();
			int sy = parse(next()) - 1;
			int sx = parse(next()) - 1;
			int dy = parse(next()) - 1;
			int dx = parse(next()) - 1;

			passengers.put(idx, new Passenger(idx, sy, sx, dy, dx));
			idx++;
		}

		//현재 위치에서가장 짧은 거리에 위치한 승객을 고른다.
		while (passengers.size() > 0) {
			Passenger picked = getPassenger();
			// 승객 까지의 거리를 가져오고

			Node info = resolve(picked.sy, picked.sx);
			int dist = info.cnt;
			// 연료가 충분한지 확인
			if (dist <= fuel) {
				fuel -= dist;
			} else {
				notArrive();
				return;
			}
			// 현재 위치 손님위치로 갱신
			sy = info.y;
			sx = info.x;

			// 목적지까지 거리 가져오고
			info = resolve(picked.dy, picked.dx);
			dist = info.cnt;
			if (dist <= fuel) {
				fuel -= dist;
			} else {
				notArrive();
				return;
			}
			// 현재 위치 손님 목적지로갱신
			sy = info.y;
			sx = info.x;
			// 손님 잘 태웠으니연료 보상
			fuel += (info.cnt * 2);
			// 처리한 승객 지우기
			passengers.remove(picked.idx);
		}

		print(String.valueOf(fuel));
		// 승객 까지의 거리를 가져오고
		// 연료가 충분한지 확인
		// 현재 위치 손님위치로 갱신
		// 목적지까지 가장 짧은 거리 가져오고
		// 연료가 충분한지 확인
		// 다시 맨위로 반복
	}

	static Passenger getPassenger() {
		PriorityQueue<Node> promisings = new PriorityQueue<>((a, b) -> {
			if (a.cnt == b.cnt) {
				if (a.y == b.y) {
					return a.x - b.x;
				}
				return a.y - b.y;
			}
			return a.cnt - b.cnt;
		});

		for (int idx : passengers.keySet()) {
			Passenger pass = passengers.get(idx);
			Node result = resolve(pass.sy, pass.sx);
			result.setIdx(idx);
			promisings.offer(result);
		}
		Node picked = promisings.poll();

		return passengers.get(picked.idx);
	}

	static int vectors[][] = {
		{-1, 0},
		{1, 0},
		{0, -1},
		{0, 1},
	};

	static Node resolve(int dy, int dx) { // 백준이의 위치에서 승객 거리 구하기
		boolean v[][] = new boolean[n][n];
		LinkedList<Node> q = new LinkedList<>();

		q.offer(new Node(sy, sx, 0));
		v[sy][sx] = true;
		while (!q.isEmpty()) {
			Node cur = q.poll();

			if (cur.y == dy && cur.x == dx) {
				return new Node(cur.y, cur.x, cur.cnt);
			}

			for (int i = 0; i < 4; i++) {
				int ny = vectors[i][0] + cur.y;
				int nx = vectors[i][1] + cur.x;

				if (isOutOfRange(ny, nx))
					continue;
				if (v[ny][nx])
					continue;
				if (map[ny][nx] == 1)
					continue;

				v[ny][nx] = true;
				q.offer(new Node(ny, nx, cur.cnt + 1));
			}

		}

		notArrive();
		System.exit(1);
		return null;
	}

	static void notArrive() {
		print("-1");
	}

	static boolean isOutOfRange(int ny, int nx) {
		return ny < 0 || nx < 0 || ny >= n || nx >= n;
	}

	static void print(String s) {
		System.out.println(s);
	}

	static String next() {
		return st.nextToken();
	}

	static StringTokenizer line() {
		return new StringTokenizer(sc.nextLine());
	}

	static int parse(String s) {
		return Integer.parseInt(s);
	}
}
