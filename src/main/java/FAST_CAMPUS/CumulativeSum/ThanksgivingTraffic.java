package FAST_CAMPUS.CumulativeSum;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class ThanksgivingTraffic {

	public int solution(String[] lines) throws ParseException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss.SSS");
		int n = lines.length;
		int[] counts = new int[n];
		Arrays.fill(counts, 1);
		int answer = 1;

		for (int i = 0; i < n; i++) {
			Date preEndDate = simpleDateFormat.parse(lines[i].split(" ")[1]);
			long preEndTime = preEndDate.getTime();

			for (int j = i + 1; j < n; j++) {
				String[] next = lines[j].split(" ");
				Date nextEndDate = simpleDateFormat.parse(next[1]);
				double second = Double.parseDouble(next[2].split("s")[0]) * 1000;

				long nextStart = nextEndDate.getTime() - (long)second + 1;

				if (preEndTime + 1000 > nextStart) {
					counts[i]++;
					answer = Math.max(answer, counts[i]);
				}
			}
		}

		return answer;
	}
}
