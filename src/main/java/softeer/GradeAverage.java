package softeer;

import java.util.Scanner;
import java.util.StringTokenizer;

public class GradeAverage {

	static Scanner sc = new Scanner(System.in);
	static StringTokenizer st;

	static int n;
	static int k;
	static int[] grades;
	static int[][] request;

	public static void main(String[] args) {
		enterNK();
		enterGrades();
		enterRequest();

		int[] intervalSummaries = getIntervalSummaries();
		StringBuilder answers = new StringBuilder();
		for (int i = 0; i < k; i++) {
			int start = request[i][0];
			int end = request[i][1];
			int totalSummary = 0;
			int size = 0;

			double average = calculateAverage(intervalSummaries, end, start);
			String answer = String.format("%.2f", average);
			answers.append(answer)
				.append(System.lineSeparator());
		}

		System.out.println(answers);
	}

	private static double calculateAverage(int[] intervalSummaries, int end, int start) {
		int size = end - start + 1;
		int intervalSummary = intervalSummaries[end] - intervalSummaries[start - 1];

		return (double)intervalSummary / size;
	}

	private static void enterNK() {
		st = new StringTokenizer(sc.nextLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
	}

	private static void enterGrades() {
		st = new StringTokenizer(sc.nextLine());
		grades = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			grades[i] = Integer.parseInt(st.nextToken());
		}
	}

	private static void enterRequest() {
		request = new int[k][2];
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(sc.nextLine());
			request[i][0] = Integer.parseInt(st.nextToken());
			request[i][1] = Integer.parseInt(st.nextToken());
		}
	}

	private static int[] getIntervalSummaries() {
		int[] intervalSummaries = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			intervalSummaries[i] = grades[i];
			intervalSummaries[i] += intervalSummaries[i - 1];
		}

		return intervalSummaries;
	}

}
