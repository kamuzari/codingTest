package BaekJoon.SolvedAC4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Combination {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        System.out.println(combination(n, m));
    }

    private static BigInteger combination(int n, int m) {
        BigInteger dp[][] = new BigInteger[101][101];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    dp[i][0] = BigInteger.ONE;
                } else if (i == j) {
                    dp[i][j] = BigInteger.ONE;
                } else {
                    dp[i][j] = dp[i - 1][j].add(dp[i - 1][j - 1]);
                }
            }
        }
        return dp[n][m];
    }

}
