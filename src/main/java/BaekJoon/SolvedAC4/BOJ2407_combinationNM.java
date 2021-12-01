package BaekJoon.SolvedAC4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class BOJ2407_combinationNM {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BigInteger dp[][] = new BigInteger[101][101];

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        pascalCombinationDp(n, m);
        System.out.println(dp[n][m]);
    }

    private static void pascalCombinationDp(int n, int m) {
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                if (i == j || j == 0) {
                    dp[i][j] = BigInteger.ONE;
                } else {
                    dp[i][j] = dp[i - 1][j - 1].add(dp[i - 1][j]);
                }
            }
        }
    }

}
