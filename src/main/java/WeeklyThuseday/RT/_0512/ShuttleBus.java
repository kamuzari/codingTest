package WeeklyThuseday.RT._0512;

import java.util.PriorityQueue;

public class ShuttleBus {
    public static void main(String[] args) {
        String s[] = {"09:00", "09:00", "09:00", "09:00"};

        System.out.println(solution(2,1, 2, s));
    }
    static class Time implements Comparable<Time>
    {
        int hour,minute;

        public Time(int hour, int minute) {
            if(minute<0)
            {
                minute+=60;
                hour--;
            }
            if(minute>=60)
            {
                minute-=60;
                hour++;
            }
            this.hour = hour;
            this.minute = minute;
        }

        @Override
        public int compareTo(Time time) {
            if(hour== time.hour)
                return minute-time.minute;
            return hour-time.hour;
        }
    }
   static PriorityQueue<Time>pq=new PriorityQueue<Time>();
    static String answer;
    public static String solution(int n, int t, int m, String[] timetable) {
        answer="";
        for (int i = 0; i < timetable.length; i++) {
            String s[]=timetable[i].split(":");
            pq.offer(new Time(Integer.parseInt(s[0]),Integer.parseInt(s[1])));
        }
        bus(n,t,m);
        return answer;
    }

    private static void bus(int n, int t, int m) {
        Time bus=new Time(9,0);
        Time corn=new Time(9,0);
        for (int i = 0; i < n; i++) {
            int people=0;
            for (int j = 0; j < m; j++) {
                if(!pq.isEmpty())
                {
                    Time peek = pq.peek();
                    if(bus.compareTo(peek)>=0)
                    {
                        corn=pq.poll();
                        people++;
                    }
                }
                if(i==n-1 && people==m)
                {
                    corn=new Time(corn.hour,corn.minute-1);
                }
                else if(i==n-1 && people<m)
                {
                    corn=new Time(bus.hour,bus.minute);
                }
            }
            bus=new Time(bus.hour,bus.minute+t);
        }
        answer+=(corn.hour<10 ? "0"+corn.hour:corn.hour)+":"+(corn.minute<10 ? "0"+corn.minute : corn.minute);
    }
}
