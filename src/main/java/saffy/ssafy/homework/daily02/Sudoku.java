package saffy.ssafy.homework.daily02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sudoku {
	static class Node {
		private int y, x;

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	static Scanner sc = new Scanner(System.in);
	static List<Node> toFills;
	static int[][] puzzle;
	static boolean flag = false;

	public static void main(String[] args) {
		puzzle = new int[9][9];
		toFills = new ArrayList<>();
		for (int i = 0; i < 9; i++) {
			String[] s = sc.nextLine().split("");
			for (int j = 0; j < 9; j++) {
				puzzle[i][j] = Integer.parseInt(s[j]);
				if (puzzle[i][j] == 0) {
					toFills.add(new Node(i, j));
				}
			}
		}
		choose(0);
	}

	static void choose(int cnt) {
		if (flag) {
			return;
		}

		if (cnt == toFills.size()) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					System.out.print(puzzle[i][j]);
				}
				System.out.println();
			}
			flag = true;

			return;
		}

		Node node = toFills.get(cnt);
		for (int number = 1; number <= 9; number++) {
			if (isPossible(node, number)) {
				puzzle[node.y][node.x] = number;
				choose(cnt + 1);
				puzzle[node.y][node.x] = 0;
			}
		}
	}

	static boolean isPossible(Node node, int number) {
		// row 판단
		for (int col = 0; col < 9; col++) {
			if (node.x == col)
				continue;
			if (puzzle[node.y][col] == number) {
				return false;
			}
		}

		// col 판단
		for (int row = 0; row < 9; row++) {
			if (node.y == row) {
				continue;
			}

			if (puzzle[row][node.x] == number) {
				return false;
			}
		}

		Node start = resolveStartNode(node);
		for (int i = start.y; i < start.y + 3; i++) {
			for (int j = start.x; j < start.x + 3; j++) {
				if (node.y == i && node.x == j) {
					continue;
				}

				if (puzzle[i][j] == number) {
					return false;
				}
			}
		}

		return true;
	}

	static Node resolveStartNode(Node node) {
		int startY = 0;
		if (node.y >= 6) {
			startY = 6;
		} else if (node.y >= 3) {
			startY = 3;
		} else {
			startY = 0;
		}

		int startX = 0;
		if (node.x >= 6) {
			startX = 6;
		} else if (node.x >= 3) {
			startX = 3;
		} else {
			startX = 0;
		}

		return new Node(startY, startX);
	}
}
