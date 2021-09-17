package AL_CS_STUDY.Weekly_30to40.Weekly38;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1149_RGBdistance {

    static int arr[][];
    static final int COLOR_NUMBER = 3;
    static int n;

    public static void main(String[] args) throws IOException {
        input();
        solve(arr, n);
    }

    private static void solve(int[][] arr, int n) {
        int dp[][] = new int[n][COLOR_NUMBER];
        for (int i = 0; i < COLOR_NUMBER; i++) {
            dp[0][i] = arr[0][i];
        }
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + arr[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + arr[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + arr[i][2];
        }
        int min = Math.min(Math.min(dp[n - 1][0], dp[n - 1][1]), dp[n - 1][2]);
        System.out.println(min);
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n][COLOR_NUMBER];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < COLOR_NUMBER; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

    }
}
