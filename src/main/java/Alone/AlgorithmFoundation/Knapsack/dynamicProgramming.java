package Alone.AlgorithmFoundation.Knapsack;

import java.util.Scanner;

public class dynamicProgramming {
    static int n;
    static int k;
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        n=input.nextInt();
        k=input.nextInt();
        int[] w=new int[n+1]; // 무게
        int[] p=new int[n+1]; // 가치.
        int[][] dp=new int[n+1][k+1]; // 다이나믹 배열
        for(int i=1;i<=n;i++){
            w[i]=input.nextInt();
            p[i]=input.nextInt();
        }
        Knapsack(w,p,dp);
    }

    public static void Knapsack(int w[], int p[], int dp[][])
    {
        for(int i=1;i<=n;i++){
            for(int j=1;j<=k;j++){
                dp[i][j]=dp[i-1][j];
                if(j-w[i]>=0){
                    dp[i][j]=Math.max(dp[i][j],  dp[i-1][j-w[i]]+p[i]);
                }
            }
        }

        System.out.println(dp[n][k]);
    }
}
