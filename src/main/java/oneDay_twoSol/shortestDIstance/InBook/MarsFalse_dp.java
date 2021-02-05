package oneDay_twoSol.shortestDIstance.InBook;

import java.util.Scanner;

public class MarsFalse_dp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int dp[][] = new int[n + 1][n + 1];
            sc.nextLine();
            for (int i = 1; i < n + 1; i++) {
                String str[] = sc.nextLine().split(" ");
                for (int j = 1; j < n + 1; j++) {
                    dp[i][j] = Integer.parseInt(str[j - 1]);
                }
            }
            int INF = (int) 1e9;
            for (int i = 0; i < n + 1; i++) {
                dp[0][i] = INF;
                dp[i][0] = INF;
            }

        }
    }
    static void print(int [][]dp)
    {
        for (int i = 1; i <dp.length ; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("----");
    }
}
/*
3
3
5 5 4
3 9 1
3 2 7
5
3 7 2 0 1
2 8 0 9 1
1 2 1 8 1
9 8 9 2 0
3 6 5 1 5
7
9 0 5 1 1 5 3
4 1 2 1 6 5 3
0 7 6 1 6 8 5

*/