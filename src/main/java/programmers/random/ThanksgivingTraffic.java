package programmers.random;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ThanksgivingTraffic {
	class Log {
		private int requestSeconds;
		private int responseSeconds;

		public Log(int requestSeconds, int responseSeconds) {
			this.requestSeconds = requestSeconds;
			this.responseSeconds = responseSeconds;
		}

		public String toString() {
			return String.format("request: %d, response: %d", requestSeconds, responseSeconds);
		}
	}

	class Time {
		private int hour;
		private int minute;
		private double seconds;

		public Time(int hour, int minute, double seconds) {
			this.hour = hour;
			this.minute = minute;
			this.seconds = seconds;
		}

		public int toSeconds() {
			return hour * 60 * 60 * 1000 + minute * 60 * 1000 + (int)(seconds * 1000);
		}

	}

	private final static int TRAFFIC_SIZE = 24 * 60 * 60 * 1000 + 60 * 60 * 1000 + 60 * 1000 + 1000;

	public int solution(String[] lines) {
		int answer = 1;

		List<Log> logs = Arrays.stream(lines)
				.map(line -> toLog(line))
				.collect(Collectors.toList());

		for (int i = 0; i < logs.size(); i++) {
			int overlapCount = 1;
			Log pivot = logs.get(i);
			for (int j = i + 1; j < logs.size(); j++) {
				Log compareance = logs.get(j);

				if (pivot.responseSeconds + 1000 > compareance.requestSeconds) {
					overlapCount++;
				}
			}

			answer = Math.max(answer, overlapCount);
		}

		return answer;
	}

	public Log toLog(String line) {
		String[] totalLog = line.split(" ");
		String[] times = totalLog[1].split(":");
		String hour = times[0];
		String minute = times[1];
		String seconds = times[2];
		String processTime = totalLog[2].split("s")[0];

		Time end = new Time(toInt(hour), toInt(minute), toDouble(seconds));
		int endSeconds = end.toSeconds();
		int startSeconds = endSeconds - (int)(toDouble(processTime) * 1000) + 1;

		return new Log(startSeconds, endSeconds);
	}

	public Integer toInt(String s) {
		return Integer.parseInt(s);
	}

	public Double toDouble(String s) {
		return Double.parseDouble(s);
	}
}
