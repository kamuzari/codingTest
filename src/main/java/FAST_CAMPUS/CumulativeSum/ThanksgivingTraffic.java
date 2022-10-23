package FAST_CAMPUS.CumulativeSum;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class ThanksgivingTraffic {
	public static void main(String[] args) {
		ThanksgivingTraffic thanksgivingTraffic = new ThanksgivingTraffic();
		int solution = thanksgivingTraffic.solution(new String[] {
			"2016-09-15 01:00:04.002 2.0s", "2016-09-15 01:00:07.000 2s"
		});

		System.out.println(solution);
	}

	public int solution(String[] lines) {
		int answer = 0;
		int n = lines.length;
		int[] traffics = new int[n];

		Arrays.fill(traffics, 1);

		for (int i = 0; i < n; i++) {
			String time = getTime(lines[i]);
			String[] times = time.split(":");
			int end = getEndTime(times);

			for (int j = i + 1; j < n; j++) {
				String comparenceTime = getTime(lines[j]);
				String comparenceProcessTime = getProcessTime(lines[j]);
				int compEndTime = getEndTime(comparenceTime.split(":"));
				int compStartTime = getStartTime(comparenceProcessTime, compEndTime);

				if (end + 1000 >= compStartTime) {
					traffics[i]++;
					answer = Math.max(answer, traffics[i]);
				}
			}
		}

		return answer;
	}

	private String getProcessTime(String lines) {
		return lines.split(" ")[2].split("s")[0];
	}

	private String getTime(String lines) {
		return lines.split(" ")[1];
	}

	private int getStartTime(String processTime, int end) {
		return end - (int)(Double.parseDouble(processTime) * 1000) + 1;
	}

	private int getEndTime(String[] times) {
		int hour = Integer.parseInt(times[0]) * 60 * 60 * 1000;
		int minute = Integer.parseInt(times[1]) * 60 * 1000;
		double second = (Double.parseDouble(times[2])) * 1000;

		return hour + minute + (int)second;
	}

	public int solution_green(String[] lines) throws ParseException {
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
