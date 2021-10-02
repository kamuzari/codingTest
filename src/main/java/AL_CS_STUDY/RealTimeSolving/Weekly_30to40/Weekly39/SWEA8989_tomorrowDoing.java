package AL_CS_STUDY.RealTimeSolving.Weekly_30to40.Weekly39;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA8989_tomorrowDoing {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int totalTestCase = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();

        for (int testCase = 1; testCase <= totalTestCase; testCase++) {
            int n = Integer.parseInt(br.readLine());
            int t[] = new int[n];
            int d[] = new int[n];
            int s = 0;
            int e = 0;

            for (int i = 0; i < n; i++) {
                final StringTokenizer st = new StringTokenizer(br.readLine());
                t[i] = Integer.parseInt(st.nextToken());
                d[i] = Integer.parseInt(st.nextToken());
                e=Math.max(d[i]-t[i],e);
            }

            int answer = Integer.MIN_VALUE;
            while (s <= e) {
                int mid = (s + e) >> 1;

                if (check(mid, t, d, n)) {
                    s = mid + 1;
                } else {
                    e = mid - 1;
                }
            }
            answer=e;
            sb.append("#").append(testCase).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }

    private static boolean check(int startDay, int[] t, int[] d, int n) {
        int cnt=0;
        for (int i = 0; i < n; i++) {
            if (startDay + t[i] > d[i]) {
                return false;
            }
            if(startDay+t[i]==d[i]){
                cnt++;
                if(cnt>2){
                    return false;
                }
            }
        }
        return true;
    }
}
