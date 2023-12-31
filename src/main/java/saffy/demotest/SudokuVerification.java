package saffy.demotest;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class SudokuVerification {
	private static Scanner sc = new Scanner(System.in);
	private static final int VERIFICATION_SUCCESS = 1;
	private static final int VERIFICATION_FAIL = 0;
	private static final boolean CACHE_HIT = true;
	private static final int SUDOKU_SIZE = 9;

	private static Set<Integer> cacheVerificationRow;
	private static Set<Integer> cacheVerificationColum;

	public static void main(String[] args) {
		StringBuilder answers = new StringBuilder();
		int repeatCount = toInt(sc.nextLine());

		for (int testCase = 1; testCase <= repeatCount; testCase++) {
			int[][] sudoku = new int[SUDOKU_SIZE][SUDOKU_SIZE];
			for (int i = 0; i < SUDOKU_SIZE; i++) {
				StringTokenizer st = new StringTokenizer(sc.nextLine());
				for (int j = 0; j < SUDOKU_SIZE; j++) {
					sudoku[i][j] = toInt(st.nextToken());
				}
			}

			cacheVerificationColum = new HashSet<>();
			cacheVerificationRow = new HashSet<>();

			int verification = verify(sudoku);
			String answer = String.format("#%d %d", testCase, verification);
			answers.append(answer).append(System.lineSeparator());
		}

		System.out.println(answers);
	}

	private static int verify(int[][] sudoku) {
		for (int row = 0; row < SUDOKU_SIZE; row++) {
			for (int col = 0; col < SUDOKU_SIZE; col++) {
				if (!verifyRow(row, sudoku))
					return VERIFICATION_FAIL;
				cacheVerificationRow.add(row);

				if (!verifyColumn(col, sudoku))
					return VERIFICATION_FAIL;
				cacheVerificationColum.add(col);

				boolean isSmallRectanglePosition = row % 3 == 0 && col % 3 == 0;
				if (isSmallRectanglePosition && !verifySmallRectangle(row, col, sudoku)) {
					return VERIFICATION_FAIL;
				}
			}
		}

		return VERIFICATION_SUCCESS;
	}

	private static boolean verifySmallRectangle(int i, int j, int[][] sudoku) {
		Set<Integer> numbers = new HashSet<>();
		for (int k = i; k < i + 3; k++) {
			for (int l = j; l < j + 3; l++) {
				numbers.add(sudoku[k][l]);
			}
		}

		return numbers.size() == 9;
	}

	private static boolean verifyRow(int fixRow, int[][] sudoku) {
		if (cacheVerificationRow.contains(fixRow)) {
			return CACHE_HIT;
		}

		Set<Integer> numbers = new HashSet<>();
		for (int i = 0; i < SUDOKU_SIZE; i++) {
			numbers.add(sudoku[fixRow][i]);
		}

		return numbers.size() == 9;
	}

	private static boolean verifyColumn(int fixColumn, int[][] sudoku) {
		if (cacheVerificationColum.contains(fixColumn)) {
			return CACHE_HIT;
		}

		Set<Integer> numbers = new HashSet<>();

		for (int i = 0; i < SUDOKU_SIZE; i++) {
			numbers.add(sudoku[i][fixColumn]);
		}

		return numbers.size() == 9;
	}

	private static int toInt(String s) {
		return Integer.parseInt(s);
	}
}