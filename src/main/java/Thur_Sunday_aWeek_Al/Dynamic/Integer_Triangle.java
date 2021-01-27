package Thur_Sunday_aWeek_Al.Dynamic;

import java.util.Scanner;

public class Integer_Triangle {
    static int n;
    static int arr[][];
    static int dp[][];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        arr = new int[n][n];
        dp = new int[n][n];

        sc.nextLine();

        for (int i = 0; i < n; i++) {
            String str[] = sc.nextLine().split(" ");
            for (int j = 0; j < str.length; j++) {
                int x = Integer.parseInt(str[j]);
                arr[i][j] = x;
                dp[i][j]=0;
            }
            for (int j = str.length; j < n; j++) {
                arr[i][j] = 10000;
                dp[i][j]=10000;
            }
        }

        for (int i = 0; i <n; i++) {
            dp[n-1][i]=arr[n-1][i];
        }
        for (int i = 0; i < n; i++) {
//            System.out.println(Arrays.toString(arr[i]));
        }
        System.out.println(top_down(0,0));

        System.out.println("bottom Up");
        int dp2[][]=new int[n][n];
        int max=0;
        for (int i = 1; i <n ; i++) {
            for (int j = 0; j <=i ; j++) {
                if(j==0)
                {
                    dp2[i][j]=dp2[i-1][j]+arr[i][j];
                }
                else if(j==i)
                {
                    dp2[i][j]=dp2[i-1][j-1]+arr[i][j];
                }
                else
                    dp2[i][j] = Math.max(dp2[i-1][j-1], dp2[i-1][j]) + arr[i][j];

                max=Math.max(max,dp2[i][j]);
            }
        }
    }

    static int top_down(int depth, int idx) {
        if (depth == n - 1)
            return dp[depth][idx];
        if (dp[depth][idx] == 0) {
            dp[depth][idx] = Math.max(top_down(depth + 1, idx), top_down(depth + 1, idx + 1) )+ arr[depth][idx];
        }
        if(dp[depth][idx]==10000)
            return 0;

        return  dp[depth][idx];
    }
}
