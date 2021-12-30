package Programmers.LV3;

public class ThanksgivingTraffic {
    private static int len;

    public int solution(String lines[]) {
        int answer = 0;
        len = lines.length;
        int startTimes[] = new int[len];
        int endTimes[] = new int[len];

        getStartTime(lines, startTimes, endTimes);

        for (int i = 0; i < len; i++) {
            int cnt = 0;
            // Interval
            int startOfSection = startTimes[i];
            int endOfSection = startOfSection + 1000;

        // lines 배열은 응답완료시간 S를 기준으로 오름차순 정렬됨.
            for (int j = 0; j < len; j++) {
                if (startTimes[j] >= startOfSection && startTimes[j] < endOfSection) {
                    // 구간에 포함 될 때.
                    cnt++;
                } else if (endTimes[j] >= startOfSection && endTimes[j] < endOfSection) {
                    // 걸쳐 있을 때.
                    cnt++;
                } else if (startTimes[j] <= startOfSection && endTimes[j] >= endOfSection) {
                    // 시작시간 전부터 시작해서  끝나는 시간도 끝나는 영역보다 클 때 포함.
                    cnt++;
                }
            }
            answer = Math.max(cnt, answer);
        }

        for (int i = 0; i < len; i++) {
            int cnt = 0;
            // Interval
            int startOfSection = endTimes[i];
            int endOfSection = startOfSection + 1000; // 1초간 최대 처리량

            for (int j = 0; j < len; j++) {
                if (startTimes[j] >= startOfSection && startTimes[j] < endOfSection) {
                    // 구간에 포함 될 때.
                    cnt++;
                } else if (endTimes[j] >= startOfSection && endTimes[j] < endOfSection) {
                    // 걸쳐 있을 때.
                    cnt++;
                } else if (startTimes[j] <= startOfSection && endTimes[j] >= endOfSection) {
                    // 시작시간 전부터 시작해서  끝나는 시간도 끝나는 영역보다 클 때 포함.
                    cnt++;
                }
            }
            answer = Math.max(cnt, answer);
        }
        return answer;
    }

    private void getStartTime(String[] lines, int[] startTimes, int[] endTimes) {
        for (int i = 0; i < len; i++) {
            String[] log = lines[i].split(" "); // { "yyyy-mm-dd" , "HH:mm:ss.sss ,T"
            String[] responseTime = log[1].split(":");
            int processTime = (int) (Double.parseDouble(log[2].substring(0, log[2].length() - 1)) * 1000); //최대 소수점 셋째자리 정수 표현

            int startTime = 0, endTime = 0;
            endTime += Integer.parseInt(responseTime[0]) * 60 * 60 * 1000;  // 시간
            endTime += Integer.parseInt(responseTime[1]) * 60 * 1000; // 분
            endTime += (int) (Double.parseDouble(responseTime[2]) * 1000);
            startTime = endTime - processTime + 1; // 0.001 -> 정수화
            startTimes[i] = startTime;
            endTimes[i] = endTime;
        }
    }
}
