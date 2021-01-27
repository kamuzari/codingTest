package Thur_Sunday_aWeek_Al.Dynamic;

import java.util.Scanner;

public class Shift {
    static int n,m;
    static int board[][];
    // 위 왼쪽 오른쪽.
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();
        board=new int[n+1][m+1];
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <= m; j++) {
                board[i][j]=sc.nextInt();
            }
        }
        int dp[][]=new int[n+1][m+1];
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=m; j++) {
                int temp1 = dp[i-1][j];
                int temp2 = dp[i][j-1];
                int temp3 = dp[i-1][j-1];
                dp[i][j] = Math.max(temp1, Math.max(temp2, temp3)) + board[i][j];
            }
        }
        System.out.println(dp[n][m]);
    }
}
