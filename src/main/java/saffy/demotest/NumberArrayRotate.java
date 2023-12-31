package saffy.demotest;

import java.util.Scanner;
import java.util.StringTokenizer;

public class NumberArrayRotate {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		StringBuilder answers = new StringBuilder();
		int repeatCount = toInt(sc.nextLine());

		for (int testCase = 1; testCase <= repeatCount; testCase++) {
			int n = toInt(sc.nextLine());

			StringBuilder result[] = new StringBuilder[n];
			for (int i = 0; i < n; i++) {
				result[i] = new StringBuilder();
			}

			int[][] arr = new int[n][n];
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(sc.nextLine());
				for (int j = 0; j < n; j++) {
					arr[i][j] = toInt(st.nextToken());
				}
			}

			for (int i = 0; i < 3; i++) {
				arr = rotate(n, arr);
				writeResult(n, arr, result);
			}

			StringBuilder integratedResult = integrate(n, result);
			String answer = String.format("#%d\n%s", testCase, integratedResult);
			answers.append(answer);
		}

		System.out.println(answers);
	}

	private static StringBuilder integrate(int n, StringBuilder[] result) {
		StringBuilder integratedResult = new StringBuilder();
		for (int i = 0; i < n; i++) {
			integratedResult.append(result[i]).append(System.lineSeparator());
		}

		return integratedResult;
	}

	private static void writeResult(int n, int[][] arr, StringBuilder[] result) {

		for (int r = 0; r < n; r++) {
			for (int c = 0; c < n; c++) {
				result[r].append(arr[r][c]);
			}
			result[r].append(" ");
		}
	}

	private static int[][] rotate(int n, int[][] arr) {
		int[][] clone = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				clone[i][j] = arr[n - 1 - j][i];
			}
		}

		return clone;
	}

	private static int toInt(String s) {
		return Integer.parseInt(s);
	}
}
