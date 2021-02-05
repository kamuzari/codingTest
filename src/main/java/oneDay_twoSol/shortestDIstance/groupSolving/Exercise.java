package oneDay_twoSol.shortestDIstance.groupSolving;

import java.util.Arrays;
import java.util.Scanner;

public class Exercise {
    static final int INF=(int) 1e9;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        int dp[][] = new int[v + 1][v + 1];
        for (int i = 1; i < v + 1; i++) {
            Arrays.fill(dp[i], INF);
        }

        for (int i = 0; i < e; i++) {
            dp[sc.nextInt()][sc.nextInt()] = sc.nextInt();
        }

        for (int k = 1; k < v + 1; k++) {
            for (int i = 1; i < v + 1; i++) {
                for (int j = 1; j < v + 1; j++) {
                    if(i==j)
                        continue;
                    dp[i][j]=Math.min(dp[i][j],dp[i][k]+dp[k][j]);
                }
            }
        }
        int ans=INF;
        for (int i = 1; i <v+1 ; i++) {
            for (int j = 1; j < v+1; j++) {
                if(i==j)
                    continue;;
                 if(dp[i][j]!=INF && dp[j][i]!=INF)
                     ans=Math.min(ans,dp[i][j]+dp[j][i]);
            }
        }
        if(ans==INF)
            System.out.println(-1);
        else
            System.out.println(ans);
    }
}
