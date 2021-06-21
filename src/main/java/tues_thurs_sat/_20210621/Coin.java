package tues_thurs_sat._20210621;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Coin {
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
        dp[0]=1;
        for (int i = 0; i < n; i++) {
            for (int j = arr[i]; j < k+1; j++) {
                dp[j]+=dp[j-arr[i]];
            }
        }
//        System.out.println(Arrays.toString(dp));

            System.out.println(dp[k]);
    }
}
