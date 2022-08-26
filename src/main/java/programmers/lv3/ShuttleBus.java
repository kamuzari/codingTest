package programmers.lv3;

import java.util.PriorityQueue;

public class ShuttleBus {
    static final int startHour = 9;

    class Time implements Comparable<Time> {
        int hour, minute;

        public Time(int hour, int minute) {
            if (minute < 0) {
                minute += 60;
                hour--;
            } else if (minute >= 60) {
                minute -= 60;
                hour++;
            }
            this.hour = hour;
            this.minute = minute;
        }

        @Override
        public int compareTo(Time o) {
            if (hour == o.hour)
                return minute - o.minute;
            return hour - o.hour;
        }
    }

    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        PriorityQueue<Time> pq = new PriorityQueue<>();
        for (String mmhh : timetable) {
            String[] split = mmhh.split(":");
            pq.offer(new Time(Integer.parseInt(split[0]),
                    Integer.parseInt(split[1])));
        }

        Time bus = new Time(startHour, 0);
        Time corn = new Time(startHour, 0);
        for (int i = 0; i < n; i++) {
            int ridedPassenger = 0;
            for (int j = 0; j < m; j++) {
                if (!pq.isEmpty()) {
                    Time peek = pq.peek();
                    if (bus.compareTo(peek) >= 0) {
                        corn = pq.poll();
                        ridedPassenger++;
                    }
                }
                if (i == n - 1 && ridedPassenger == m) {
                    corn = new Time(corn.hour, corn.minute - 1);
                } else if (i == n - 1 && ridedPassenger < m) {
                    corn = new Time(bus.hour, bus.minute);
                }
            }
            bus = new Time(bus.hour, bus.minute + t);
        }
        answer += (corn.hour < 10 ? "0" + corn.hour : corn.hour) + ":" + (corn.minute < 10 ? "0" + corn.minute : corn.minute);
        return answer;
    }
}
