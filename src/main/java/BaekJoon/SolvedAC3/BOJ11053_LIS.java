package BaekJoon.SolvedAC3;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11053_LIS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int arr[]=new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }
        int dp[]=new int[n];
        Arrays.fill(dp,1);
        int max=1;
        for (int i = 1; i < n; i++) {
            for (int j = i-1; j >=0 ; j--) {
                if(arr[i]>arr[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                    max=Math.max(max,dp[i]);
                }
            }
        }
        System.out.println(max);
    }
}
