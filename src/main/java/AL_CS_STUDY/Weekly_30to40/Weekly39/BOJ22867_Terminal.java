package AL_CS_STUDY.Weekly_30to40.Weekly39;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// 정렬 (끝나는시간 정렬) 우선순위큐
public class BOJ22867_Terminal {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int time[] = new int[60 * 60 * 24 *1000+1];
        for (int i = 0; i < n; i++) {
            String startAndEndTime[] = br.readLine().split(" ");
            String sTime[] = startAndEndTime[0].split(":");
            String eTime[] = startAndEndTime[1].split(":");
            int start = toSeconds(sTime);
            int end = toSeconds(eTime)+1;
            time[start]++;
            time[end+1]--;
        }
        int max = 0;
        for (int i = 1; i < 60 * 60 * 24 *1000+1; i++) {
            time[i] += time[i - 1];
            max = Math.max(max, time[i]);
        }
        System.out.println(max);
    }

    public static int toSeconds(String str[]) {
        int hour = Integer.parseInt(str[0]) * 60 * 60 * 1000;
        int minute = Integer.parseInt(str[1]) * 60 * 1000;
        String sub[] = str[2].split("\\.");
        int seconds = Integer.parseInt(sub[0])*1000;
        int milliSeconds = Integer.parseInt(sub[1]);
        return hour + minute + seconds + milliSeconds;
    }

}
