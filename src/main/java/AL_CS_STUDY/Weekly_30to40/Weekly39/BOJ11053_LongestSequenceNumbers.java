package AL_CS_STUDY.Weekly_30to40.Weekly39;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11053_LongestSequenceNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n + 1];
        final StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i + 1] = Integer.parseInt(st.nextToken());
        }

        int max = 1;
        int dp[] = new int[n + 1];
        Arrays.fill(dp, 1);
        for (int i = 2; i < n + 1; i++) {
            for (int j = 1; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max,dp[i]);
        }
        System.out.println(max);
    }
}
