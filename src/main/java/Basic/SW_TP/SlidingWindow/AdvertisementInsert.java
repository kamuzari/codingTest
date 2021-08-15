package Basic.SW_TP.SlidingWindow;

import java.util.Arrays;

public class AdvertisementInsert {
    public static void main(String[] args) {
        AdvertisementInsert advertisementInsert = new AdvertisementInsert();
        String logs[] = {"01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"};
//        String logs2[] = {"00:00:02-00:00:04", "00:00:01-00:00:03"};
//        String play_time = "00:00:10";
//        String adv_time = "00:00:01";
        String play_time = "02:03:55";
        String adv_time = "00:14:15";
        advertisementInsert.solution(play_time, adv_time, logs);
    }

    public String solution(String play_time, String adv_time, String[] logs) {
        String answer = "";
        int playTime = timeToSeconds(play_time);
        int advTime = timeToSeconds(adv_time);
        long prefixSumCnt[] = new long[playTime + 1];
        for (String log : logs) {
            String sub[] = log.split("-");
            int start = timeToSeconds(sub[0]);
            int end = timeToSeconds(sub[1]);
            for (int i = start; i < end; i++) {
                prefixSumCnt[i]++;
            }
        }
        int s = 0;
        int e = 0;
        int len = 0;
        long sum = 0;
        // 목표하는 길이
        int[] LR = new int[2];
        long max = 0;
        while (true) {
            if (len == advTime) {
                if (sum > max) {
                    max = sum;
                    LR[0] = s;
                    LR[1] = e;
                }
            }
            if (e > playTime) {
                break;
            }
            if (len < advTime) {
                len++;
                sum += prefixSumCnt[e++];
            } else if (len >= advTime) {
                len--;
                sum -= prefixSumCnt[s++];
            }
        }
        answer=SecondsToTime(LR[0]);
        return answer;
    }


    private int timeToSeconds(String str) {
        int parsingArr[] = Arrays.stream(str.split(":")).mapToInt(Integer::parseInt).toArray();
        return parsingArr[0] * 3600 + parsingArr[1] * 60 + parsingArr[2];
    }

    private String SecondsToTime(int seconds) {
        return String.format("%02d:%02d:%02d", seconds / (60 * 60), (seconds / 60) % 60, seconds % 60);
    }

}
