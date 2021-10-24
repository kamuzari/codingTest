package Basic.SolvedAC3;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1931_MeetingRoomAssignment {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int time[][] = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            time[i][0] = start;
            time[i][1] = end;
        }
        int answer = solution(n, time);
        System.out.println(answer);
    }

    private static int solution(int n, int[][] time) {
        int answer = 1;
        Arrays.sort(time, (a, b) -> {
            if (a[1] - b[1] == 0) return a[0] - b[0];
            return a[1] - b[1];
        });
        int end=time[0][1];
        for (int i = 1; i < n; i++) {
            if(end<=time[i][0]){
                answer++;
                end=time[i][1];
            }
        }
        return answer;
    }
}
