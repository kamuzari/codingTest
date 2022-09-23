package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Mentoring {

	private static int n;
	private static int m;

	static List<int[]> numberOfCases = new LinkedList<>();
	static int result[] = new int[2]; // 0번째 멘토, 1번째 멘티
	static boolean[] v;

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		v = new boolean[n+1];

		int answer = 0;
		Map<Integer, Map<Integer, Integer>> testCase = new HashMap<>();

		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(reader.readLine());
			HashMap<Integer, Integer> grades = new HashMap<>();
			testCase.put(i, grades);

			for (int j = 1; j <= n; j++) {
				int grade = Integer.parseInt(st.nextToken());
				grades.put(grade, j);
			}
		}

		pick(0, 2);

		for (int[] pick : numberOfCases) {
			int mentor = pick[0];
			int mentee = pick[1];

			int pass = 0;
			for (int test = 1; test <= m; test++) {
				Map<Integer, Integer> grades = testCase.get(test);
				Integer mentorScore = grades.get(mentor);
				Integer menteeScore = grades.get(mentee);

				if (menteeScore > mentorScore) {
					pass++;
				}
			}

			if (pass == m) {
				answer++;
			}
		}

		System.out.println(answer);
	}

	public static void pick(int cnt, int target) {
		if (cnt == target) {
			numberOfCases.add(result.clone());
			return;
		}

		for (int i = 1; i <= n; i++) {
			if (v[i])
				continue;

			v[i] = true;
			result[cnt] = i;
			pick(cnt + 1, target);
			v[i] = false;

		}
	}
}
