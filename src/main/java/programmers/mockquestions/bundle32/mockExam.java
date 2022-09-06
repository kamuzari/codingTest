package programmers.mockquestions.bundle32;

import java.util.ArrayList;
import java.util.List;

public class mockExam {

	public int[] solution(int[] answers) {
		int[] a = new int[] {1, 2, 3, 4, 5};
		int[] b = new int[] {2, 1, 2, 3, 2, 4, 2, 5};
		int[] c = new int[] {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
		int[] cnt = new int[3];
		int aLen = a.length;
		int bLen = b.length;
		int cLen = c.length;

		for (int i = 0; i < answers.length; i++) {
			int ans = answers[i];
			if (a[i % aLen] == ans) {
				cnt[0]++;
			}

			if (b[i % bLen] == ans) {
				cnt[1]++;
			}

			if (c[i % cLen] == ans) {
				cnt[2]++;
			}
		}

		List<Integer> results = new ArrayList<>();
		int maxVal = Math.max(cnt[0], Math.max(cnt[1], cnt[2]));

		for (int i = 0; i < 3; i++) {
			if (maxVal == cnt[i]) {
				results.add(i + 1);
			}
		}

		return results.stream().mapToInt(i -> i).toArray();
	}
}
