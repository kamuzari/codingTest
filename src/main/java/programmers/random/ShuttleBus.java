package programmers.random;

import java.util.Arrays;
import java.util.PriorityQueue;

public class ShuttleBus {
	class Time implements Comparable<Time> {
		private int hour;
		private int minute;

		public Time(int hour, int minute) {
			if (minute < 0) {
				minute += 60;
				hour--;
			} else if (minute >= 60) {
				hour++;
				minute -= 60;
			}

			this.hour = hour;
			this.minute = minute;
		}

		@Override
		public int compareTo(Time other) {
			if (this.hour == other.hour) {
				return this.minute - other.minute;
			}

			return this.hour - other.hour;
		}

	}

	public String solution(int n, int t, int m, String[] timetable) {
		int busCount = n;
		int interval = t;
		int maximumCapacity = m;

		PriorityQueue<Time> crewArrivals = structure(timetable);
		Time bus = new Time(9, 0);
		Time corn = new Time(9, 0);

		for (int shuttleCount = 0; shuttleCount < busCount; shuttleCount++) {
			int onBoardPassenger = 0;
			for (int limit = 0; limit < maximumCapacity; limit++) {
				if (!crewArrivals.isEmpty()) {
					if (bus.compareTo(crewArrivals.peek()) >= 0) {
						corn = crewArrivals.poll();
						onBoardPassenger++;
					}
				}
				boolean isLastShuttle = shuttleCount == n - 1;
				if (isLastShuttle) {
					corn = resetTime(maximumCapacity, bus, corn, onBoardPassenger);
				}
			}

			bus = new Time(bus.hour, bus.minute + interval);
		}

		return createAnswer(corn);
	}

	private Time resetTime(int maximumCapacity, Time bus, Time corn, int onBoardPassenger) {
		if (onBoardPassenger == maximumCapacity) {
			corn = new Time(corn.hour, corn.minute - 1);
		} else if (onBoardPassenger < maximumCapacity) {
			corn = new Time(bus.hour, bus.minute);
		}

		return corn;
	}

	private PriorityQueue<Time> structure(String[] timetable) {
		PriorityQueue<Time> crewArrivals = new PriorityQueue<>();
		Arrays.stream(timetable)
				.map(time -> {
					String[] hourAndMinute = time.split(":");

					return new Time(Integer.parseInt(hourAndMinute[0]),
							Integer.parseInt(hourAndMinute[1]));
				}).sorted()
				.forEach(crewArrivals::offer);

		return crewArrivals;
	}

	private String createAnswer(Time corn) {
		StringBuilder answer = new StringBuilder();
		if (corn.hour < 10) {
			answer.append("0");
		}
		answer.append(corn.hour);

		answer.append(":");

		if (corn.minute < 10) {
			answer.append("0");
		}
		answer.append(corn.minute);

		return answer.toString();
	}
}
