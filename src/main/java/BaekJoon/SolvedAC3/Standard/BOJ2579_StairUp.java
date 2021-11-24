package BaekJoon.SolvedAC3.Standard;

import java.io.*;
public class BOJ2579_StairUp {

    private static int[] dp;
    private static int[] stairs;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        stairs = new int[n+1];
        dp = new int[n+1];
        for (int i = 1; i < n+1; i++) {
            stairs[i]=Integer.parseInt(br.readLine());
        }
        dp[0]=stairs[0];
        dp[1]=stairs[1];

        if(n>=2){
            dp[2]=stairs[1]+stairs[2];
        }
        System.out.println(find(n));
    }
    static int find(int n){
        if(n==0){
            return 0;
        }
        if(dp[n]==0){
            dp[n]=Math.max(find(n-2),find(n-3)+stairs[n-1])+stairs[n];
        }
        return dp[n];
    }
}
