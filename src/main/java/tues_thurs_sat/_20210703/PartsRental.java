package tues_thurs_sat._20210703;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;
import java.io.*;

public class PartsRental {

    static class Node {
        String name;
        String part;
        LocalDateTime localDateTime;
        LocalDateTime borrowPeriod;


        public Node(String name, String part, LocalDateTime localDateTime, int plusDay, int plusHour, int plusMinute) {
            this.name = name;
            this.part = part;
            this.localDateTime = localDateTime;
            this.borrowPeriod = localDateTime.plusDays(plusDay);
            this.borrowPeriod = borrowPeriod.plusHours(plusHour);
            this.borrowPeriod = borrowPeriod.plusMinutes(plusMinute);
        }

        public boolean overPeriod(LocalDateTime localDateTime) {

            if(this.borrowPeriod.equals(localDateTime))
            {
                return true;
            }
            return (this.borrowPeriod.isAfter(localDateTime));
        }

        public long calc(LocalDateTime localDateTime)
        {
            Duration duration=Duration.between(borrowPeriod,localDateTime);
            return duration.toMinutes();
        }

    }

    static Map<String, Map<String, Node>> map = new LinkedHashMap<>();
    static Map<String, Long> fineHuman = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        String period[] = st.nextToken().split("/");
        int day = Integer.parseInt(period[0]);
        String subPeriod[]=period[1].split(":");
        int hour = Integer.parseInt(subPeriod[0]);
        int minute = Integer.parseInt(subPeriod[1]);
        int finesPerMinute = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            String str[] = br.readLine().split(" ");
            String date[] = str[0].split("-");
            String time[] = str[1].split(":");
            LocalDateTime localDateTime = LocalDateTime.of(LocalDate.of(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2])),
                    LocalTime.of(Integer.parseInt(time[0]), Integer.parseInt(time[1])));
            String part = str[2];
            String name = str[3];
            if (!map.containsKey(part)) {
                map.put(part, new LinkedHashMap<>());
                map.get(part).put(name, new Node(name, part, localDateTime, day, hour, minute));
            } else if (map.containsKey(part) ) {
                if(map.get(part).containsKey(name)) {
                    //반납했을때
                    if (map.get(part).get(name).overPeriod(localDateTime)) { // 기한 내에 냈을 때.
                        continue;
                    } else {
                        long totalMinute = map.get(part).get(name).calc(localDateTime);
                        fineHuman.put(name, fineHuman.getOrDefault(name, 0L)+totalMinute*finesPerMinute);
                    }
                }
            }
//            System.out.println(fineHuman);
        }
        if(fineHuman.isEmpty())
            System.out.println(-1);
        else
        {
            String str[]=new String[2];
            ArrayList<String []> list=new ArrayList<>();
            for (String key : fineHuman.keySet()) {
                if(fineHuman.get(key)!=0) {
//                    System.out.println(key + " " + fineHuman.get(key));
                    list.add(new String[]{key,String.valueOf(fineHuman.get(key))});
                }
            }
            list.sort((s1, s2) ->{
                return s1[0].compareTo(s2[0]);
            } );
            list.forEach(s -> System.out.println(s[0]+" "+s[1]));
        }
    }
}
