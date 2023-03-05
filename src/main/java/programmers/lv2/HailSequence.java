package programmers.lv2;

import java.util.Arrays;

public class HailSequence {
	public double[] solution(int k, int[][] ranges) {
		int cnt = count(k);

		int y[] = new int[cnt + 1];
		y[0] = k;
		for (int i = 1; i < cnt + 1; i++) {
			int pre = y[i - 1];

			if (pre % 2 == 0) {
				pre /= 2;
			} else {
				pre = pre * 3 + 1;
			}

			y[i] = pre;
		}

		double[] areas = new double[cnt + 1];
		for (int i = 1; i < cnt + 1; i++) {
			areas[i] = (y[i - 1] + y[i]) / 2.0;
			areas[i] += areas[i - 1];
		}

		System.out.println(Arrays.toString(areas));
		double[] answer = new double[ranges.length];

		for (int i = 0; i < ranges.length; i++) {
			int s = ranges[i][0];
			int e = ranges[i][1] + cnt;

			if (s < e) {
				double area = areas[e] - areas[s];
				String val = String.format("%.1f", area);
				answer[i] = Double.parseDouble(val);
			} else if (s > e) {
				answer[i] = -1.0;
			}
		}

		return answer;
	}

	public int count(int init) {
		int cnt = 0;
		while (init != 1) {
			if (init % 2 == 0)
				init /= 2;
			else
				init = init * 3 + 1;
			cnt++;
		}

		return cnt;
	}
}
