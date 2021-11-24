package BaekJoon.SolvedAC3.Standard;

import java.io.*;
import java.util.Arrays;
/*
dp[x] : x를 1로 만들기 위한 최소 연산 횟수
dp[1] : 0 -> 목표 값

*/
public class BOJ1463_OneMaking {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int dp[]=new int[n+1];
        final int INF=(int)1e9;
        Arrays.fill(dp,INF);
        dp[1]=0;
        for (int i = 2; i <n+1 ; i++) {
            dp[i]=dp[i-1]+1;

            if(i%2==0){
                dp[i]=Math.min(dp[i],dp[i/2]+1);
            }
            if(i%3==0){
                dp[i]=Math.min(dp[i],dp[i/3]+1);
            }
        }
        System.out.println(dp[n]);
    }
}
