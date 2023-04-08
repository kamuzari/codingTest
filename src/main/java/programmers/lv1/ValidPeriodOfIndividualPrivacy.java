package programmers.lv1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValidPeriodOfIndividualPrivacy {
	class Date {
		int y, m, d;

		private Date(int y, int m, int d) {
			this.y = y;
			this.m = m;
			this.d = d;
		}

		public boolean isDestroy(Date today, int period) {
			return today.toDay() - this.toDay() >= period;
		}

		public int toDay() {
			return y * 28 * 12 + m * 28 + d;
		}

	}

	// 파기해야할 번호를 출력하라
	public int[] solution(String today, String[] terms, String[] privacies) {
		Map<String, Integer> expircies = new HashMap<>();
		for (String term : terms) {
			String sp[] = term.split(" ");
			expircies.put(sp[0], Integer.parseInt(sp[1]) * 28);
		}

		String sp[] = today.split("\\.");
		Date TODAY = new Date(Integer.parseInt(sp[0]),
			Integer.parseInt(sp[1]),
			Integer.parseInt(sp[2]));

		int idx = 1;
		List<Integer> answers = new ArrayList<>();
		for (String privacy : privacies) {
			String s[] = privacy.split("\\.| "); // .과 띄어쓰기 파싱
			Date cur = new Date(Integer.parseInt(s[0]),
				Integer.parseInt(s[1]),
				Integer.parseInt(s[2]));

			if (cur.isDestroy(TODAY, expircies.get(s[3]))) {
				answers.add(idx);
			}

			idx++;
		}

		return answers.stream()
			.mapToInt(v -> v)
			.toArray();
	}

}
