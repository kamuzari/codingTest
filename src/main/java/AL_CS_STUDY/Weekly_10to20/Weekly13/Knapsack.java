package AL_CS_STUDY.Weekly_10to20.Weekly13;

import java.util.Scanner;

public class Knapsack {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        int k=sc.nextInt();
        int arr[][]=new int[n][2];
        for (int i = 0; i < n; i++) {
            int w=sc.nextInt();
            int p=sc.nextInt();
            arr[i][0]=w;
            arr[i][1]=p;
        }
        int dp[][]=new int[n+1][k+1];


        for (int i = 1; i <=n; i++) {
            for (int j = 1; j <k+1 ; j++) {
                dp[i][j]=dp[i-1][j];
                if(j-arr[i-1][0]>=0)
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-arr[i-1][0]]+arr[i-1][1]);
            }
        }
        System.out.println(dp[n][k]);
    }
}
