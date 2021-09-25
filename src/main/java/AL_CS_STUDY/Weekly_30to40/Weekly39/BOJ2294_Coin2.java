package AL_CS_STUDY.Weekly_30to40.Weekly39;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2294_Coin2 {
    private static int INF = (int) 1e9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int coinValues[] = new int[n];

        for (int i = 0; i < n; i++) {
            coinValues[i] = Integer.parseInt(br.readLine());
        }
        int dp[] = new int[k + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = coinValues[i]; j <= k; j++) {
                dp[j] = Math.min(dp[j], dp[j - coinValues[i]] + 1);
            }
        }
        if (dp[k] == INF) {
            System.out.println(-1);
        } else {
            System.out.println(dp[k]);
        }
    }
}
