package codeTree;

import java.util.StringTokenizer;
import java.util.*;
import java.util.stream.Collectors;

public class 왕실의기사대결 {
	static final int dirs[][] = {
		{-1, 0},
		{0, 1},
		{1, 0},
		{0, -1},
	};

	static class Kisa {
		int id;
		int hp;
		int w, h;
		List<Node> ranges = new ArrayList<>();
		int damage = 0;

		public Kisa(int id, int y, int x, int w, int h, int hp) {
			this.id = id;
			this.w = w;
			this.h = h;
			for (int i = 0; i <= w; i++) {
				for (int j = 0; j <= h; j++) {
					ranges.add(new Node(y + i, x + j));
				}
			}
			this.hp = hp;
		}

		public void write() {
			ranges.forEach(v -> kisaMap[v.y][v.x] = this.id);
		}

		public void move(int dir) {
			this.ranges = ranges.stream()
				.map(node -> new Node(node.y + dirs[dir][0], node.x + dirs[dir][1]))
				.collect(Collectors.toList());
		}

		// check: 트랩이 체력보다 많은 경우는 데미지를 고대로 적용해야 하는지 아니면 0을 만드는 피해량으로 해야하는지... 모르겠음.
		public void minusHp() {
			long trapCount = ranges.stream().filter(node -> map[node.y][node.x] == TRAP).count();
			this.hp -= trapCount;
			this.damage += trapCount;
		}

	}

	static class Node {
		int y, x;

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}

		public boolean isOutOfRange() {
			return y < 0 || x < 0 || y >= L || x >= L;
		}
	}

	static final int EMPTY = 0;
	static final int TRAP = 1;
	static final int WALL = 2;
	static final Scanner sc = new Scanner(System.in);
	static int[][] map;
	static int[][] kisaMap;
	static Map<Integer, Kisa> livings;
	static int totalDemage = 0;

	static int L, N, Q;

	public static void main(String[] args) {
		StringTokenizer st = createToken();

		L = toInt(st.nextToken());
		N = toInt(st.nextToken());
		Q = toInt(st.nextToken());
		map = new int[L][L];
		kisaMap = new int[L][L];
		for (int i = 0; i < L; i++) {
			st = createToken();
			for (int j = 0; j < L; j++) {
				map[i][j] = toInt(st.nextToken());
			}
		}

		int id = 1;
		livings = new HashMap<>();
		for (int i = 0; i < N; i++) {
			st = createToken();
			Kisa kisa = new Kisa(
				id,
				toInt(st.nextToken()) - 1,
				toInt(st.nextToken()) - 1,
				toInt(st.nextToken()) - 1,
				toInt(st.nextToken()) - 1,
				toInt(st.nextToken())
			);
			livings.put(id, kisa);
			kisa.write();
			id++;
		}

		while (Q-- > 0) {
			st = createToken();
			int idx = toInt(st.nextToken());
			int dir = toInt(st.nextToken());

			boolean isExist = livings.containsKey(idx);
			if (!isExist) {
				continue;
			}

			LinkedList<Integer> chains = new LinkedList<>();
			chains.offer(idx);
			Set<Integer> efficients = new HashSet<>();
			boolean canMove = true;

			while (!chains.isEmpty()) {
				int curKisaId = chains.poll();
				Kisa kisa = livings.get(curKisaId);

				for (Node node : kisa.ranges) {
					int ny = node.y + dirs[dir][0];
					int nx = node.x + dirs[dir][1];
					if (isOutOfRange(ny, nx) || map[ny][nx] == WALL) {
						canMove = false;
						break;
					}

					if (kisaMap[ny][nx] == EMPTY || kisaMap[ny][nx] == curKisaId) {
						continue;
					}

					int kisaId = kisaMap[ny][nx];
					boolean isNotContain = efficients.add(kisaId);

					if (!isNotContain) {
						continue;
					}

					chains.offer(kisaId);
				}

				if (!canMove) {
					break;
				}

			}

			if (!canMove) {
				continue;
			}

			Kisa fisrt = livings.get(idx);
			fisrt.move(dir);
			efficients.forEach(kisaId -> {
				Kisa kisa = livings.get(kisaId);
				kisa.move(dir);
				kisa.minusHp();
				if (kisa.hp <= 0) {
					livings.remove(kisaId);
				}
			});
			kisaMap = new int[L][L];
			fisrt.write();
			efficients.forEach(kisaId -> {
				if (livings.containsKey(kisaId)) {
					Kisa kisa = livings.get(kisaId);
					kisa.write();
				}
			});

			// 안움직인 아이들도 넣어줘야지
			livings.keySet().stream().filter(kisaId -> !efficients.contains(kisaId)).forEach(unMoveKisaId -> {
				Kisa unMoveKisa = livings.get(unMoveKisaId);
				unMoveKisa.write();
			});
		}
		for (Integer kisaId : livings.keySet()) {
			Kisa kisa = livings.get(kisaId);
			totalDemage += kisa.damage;
		}

		System.out.println(totalDemage);
	}

	static boolean isOutOfRange(int y, int x) {
		return y < 0 || x < 0 || y >= L || x >= L;
	}

	static StringTokenizer createToken() {
		return new StringTokenizer(sc.nextLine());
	}

	static int toInt(String s) {
		return Integer.parseInt(s);
	}
}
