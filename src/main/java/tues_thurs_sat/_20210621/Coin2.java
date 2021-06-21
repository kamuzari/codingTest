package tues_thurs_sat._20210621;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Coin2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());
        int arr[]=new int[n];

        for (int i = 0; i < n; i++) {
            int val=Integer.parseInt(br.readLine());
            arr[i]=val;
        }
        int dp[]=new int[k+1];
        Arrays.fill(dp,1_000_000_000);
        dp[0]=0;
        for (int i = 0; i < n; i++) {
            for (int j = arr[i]; j <k+1 ; j++) {
                dp[j]=Math.min(dp[j-arr[i]]+1,dp[j]);
            }
        }
//        System.out.println(Arrays.toString(dp));
        if(dp[k]!=1_000_000_000)
            System.out.println(dp[k]);
        else
            System.out.println(-1);

    }
}
