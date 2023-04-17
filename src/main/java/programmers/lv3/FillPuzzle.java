package programmers.lv3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FillPuzzle {
	public static void main(String[] args) {
		int[][] g1 = {{1, 1, 0, 0, 1, 0}, {0, 0, 1, 0, 1, 0}, {0, 1, 1, 0, 0, 1},
			{1, 1, 0, 1, 1, 1}, {1, 0, 0, 0, 1, 0}, {0, 1, 1, 1, 0, 0}};
		int[][] t1 = {{1, 0, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 0}, {0, 1, 1, 0, 1, 1},
			{0, 0, 1, 0, 0, 0}, {1, 1, 0, 1, 1, 0}, {0, 1, 0, 0, 0, 0}};

		FillPuzzle fillPuzzle = new FillPuzzle();
		int solution = fillPuzzle.solution(g1, t1);
		System.out.println(solution);
	}
	/**
	 * 문제를 잘못파악해서
	 *
	 * 이렇게 퍼즐을 넣어줌..
	 *
	 *
	 */
	// puzzles.add(new Puzzle(new int[][]{
	// 	{0,1},
	// 	{1,1},
	// 	{0,1}
	// }));
	//     puzzles.add(new Puzzle(new int[][]{
	// 	{1,1,0},
	// 	{0,1,0},
	// 	{0,1,1}
	// }));
	//     puzzles.add(new Puzzle(new int[][]{
	// 	{1,1},
	// 	{0,1}
	// }));
	//     puzzles.add(new Puzzle(new int[][]{
	// 	{1,0}
	// }));
	//     puzzles.add(new Puzzle(new int[][]{
	// 	{1},
	// 	{1}
	// }));

	/**
	 * 1. 게임판에 빈공간의 섹터를 분류한다 BFS, DFS
	 *  1-1. 주어진 테이블에서 퍼즐들을 추출한다.
	 * 2. 게임판에서 분류한 빈 블록 구역과 퍼즐들을 하나씩 끼어본다 그리고 각 퍼즐들을 회전해본다 3번!
	 *
	 *
	 */
	/**
	 * 핵심은 퍼즐조각의 도형을 뽑아내는 것이다.
	 */
	class Puzzle {
		int cnt; // 1의 개수
		int map[][];

		public Puzzle(int map[][], int cnt) {
			this.map = map;
			this.cnt = cnt;
		}

		public void rotate() {
			int n = map.length;
			int m = map[0].length;

			int newMap[][] = new int[m][n];

			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					newMap[i][j] = map[n - j-1][i];
				}
			}

			this.map = newMap;
		}

		public boolean isEqualSize(Puzzle otehr) {
			int n = this.map.length;
			int m = this.map[0].length;
			int on = otehr.map.length;
			int om = otehr.map[0].length;

			return n == on && m == om;
		}

		public boolean isTight(Puzzle empty) {
			for (int i = 0; i < this.map.length; i++) {
				for (int j = 0; j < this.map[i].length; j++) {
					if (empty.map[i][j] != this.map[i][j]) {
						return false;
					}
				}
			}

			return true;
		}
	}

	class Node {
		int y, x;

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}

	}

	int[] dy = {-1, 1, 0, 0}, dx = {0, 0, -1, 1};
	int n, m;
	boolean v[][];

	public int solution(int[][] game_board, int[][] table) {
		int answer = 0;
		n = game_board.length;
		m = game_board[0].length;

		List<Puzzle> empties = new ArrayList<>();
		List<Puzzle> puzzles = new ArrayList<>();
		v = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (game_board[i][j] == 0 && !v[i][j]) {
					List<Node> emptyBlocks = getBlock(game_board, i, j, 0);

					List<Integer> yList = emptyBlocks.stream().map(node -> node.y).collect(Collectors.toList());
					List<Integer> xList = emptyBlocks.stream().map(node -> node.x).collect(Collectors.toList());

					int minY = yList.stream().min(Integer::compareTo).orElseGet(() -> 0);
					int maxY = yList.stream().max(Integer::compareTo).orElseGet(() -> 0);
					int minX = xList.stream().min(Integer::compareTo).orElseGet(() -> 0);
					int maxX = xList.stream().max(Integer::compareTo).orElseGet(() -> 0);
					int r = maxY - minY + 1;
					int c = maxX - minX + 1;
					int map[][] = new int[r][c];

					emptyBlocks.forEach(node -> map[node.y - minY][node.x - minX] = 2);

					empties.add(new Puzzle(map, emptyBlocks.size()));
				}
			}
		}

		v = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (table[i][j] == 1 && !v[i][j]) {
					List<Node> puzzleNodes = getBlock(table, i, j, 1);
					List<Integer> yList = puzzleNodes.stream().map(node -> node.y).collect(Collectors.toList());
					List<Integer> xList = puzzleNodes.stream().map(node -> node.x).collect(Collectors.toList());

					int minY = yList.stream().min(Integer::compareTo).orElseGet(() -> 0);
					int maxY = yList.stream().max(Integer::compareTo).orElseGet(() -> 0);
					int minX = xList.stream().min(Integer::compareTo).orElseGet(() -> 0);
					int maxX = xList.stream().max(Integer::compareTo).orElseGet(() -> 0);
					int r = maxY - minY + 1;
					int c = maxX - minX + 1;
					int map[][] = new int[r][c];

					puzzleNodes.forEach(node -> map[node.y - minY][node.x - minX] = 2);

					puzzles.add(new Puzzle(map, puzzleNodes.size()));
				}
			}
		}

		Set<Integer> usings = new HashSet<>();// 퍼즐 사용여부
		for (int i = 0; i < empties.size(); i++) {
			Puzzle emptyPuzzle = empties.get(i);

			for (int j = 0; j < puzzles.size(); j++) {
				if (usings.contains(j))
					continue;

				Puzzle puzzle = puzzles.get(j);

				if (emptyPuzzle.cnt != puzzle.cnt)
					continue;
				boolean isTight = false;
				for (int k = 0; k < 4; k++) {
					if (k != 0) {
						puzzle.rotate();
					}

					if (!emptyPuzzle.isEqualSize(puzzle))
						continue;

					if (emptyPuzzle.isTight(puzzle)) {
						isTight = true;
					}
				}

				// 되돌리기
				puzzle.rotate();

				if(isTight){
					usings.add(j);
					answer+=puzzle.cnt;
					break;
				}

			}
		}

		return answer;
	}

	List<Node> getBlock(int arr[][], int y, int x, int type) {
		LinkedList<Node> q = new LinkedList<>();
		q.offer(new Node(y, x));
		v[y][x] = true;

		List<Node> results = new ArrayList<>();
		results.add(new Node(y, x));

		while (!q.isEmpty()) {
			Node cur = q.poll();

			for (int i = 0; i < 4; i++) {
				int ny = dy[i] + cur.y;
				int nx = dx[i] + cur.x;

				if (isOutOfRange(ny, nx))
					continue;
				if (v[ny][nx])
					continue;
				if (arr[ny][nx] != type)
					continue;

				v[ny][nx] = true;
				q.offer(new Node(ny, nx));
				results.add(new Node(ny, nx));
			}
		}

		return results;
	}

	boolean isOutOfRange(int ny, int nx) {
		return ny < 0 || nx < 0 || ny >= n || nx >= m;
	}

}
