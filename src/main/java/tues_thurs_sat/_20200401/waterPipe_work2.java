package tues_thurs_sat._20200401;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class waterPipe_work2 {
//    dp[x]=x  dp[요구하는 길이]=요구하는 길이에 대한 최소 용량.
    /*

    * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int d = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int dp[] = new int[d + 1];
        // dp[길이]=용량.
        dp[0] = (int) 1e9;
        for (int i = 1; i < p + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int len = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
//            System.out.println(Arrays.toString(dp));
            for (int j = d; j >= len; j--) {
                dp[j] = Math.max(dp[j], Math.min(c, dp[j - len]));
//                System.out.println(Arrays.toString(dp));
            }
        }
        System.out.println(dp[d]);
    }
}
