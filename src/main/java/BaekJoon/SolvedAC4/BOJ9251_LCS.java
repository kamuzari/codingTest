package BaekJoon.SolvedAC4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9251_LCS {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();
        int answer = longestCommonSubsequence(str1, str2);
        System.out.println(answer);
    }

    private static int longestCommonSubsequence(String a, String b) {
        int commonMaxLength = 0;
        a = "0" + a;
        b = "0" + b;
        int aLength = a.length();
        int bLength = b.length();
        int dp[][] = new int[aLength][bLength];
        for (int i = 1; i < aLength; i++) {
            for (int j = 1; j < bLength; j++) {
                if (a.charAt(i) == b.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else if (a.charAt(i) != b.charAt(j)) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
                commonMaxLength = Math.max(commonMaxLength, dp[i][j]);
            }
        }
        return commonMaxLength;
    }
}
