package tues_thurs_sat._20210515;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TileFill {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int dp[]=new int[n+1];
        if(n==1)
        {
            System.out.println(0);
            return;
        }
        dp[0]=1;
        dp[2]=3;
        for (int i = 4; i <n+1 ; i++) {
            dp[i]=dp[i-2]*3;
            for (int j = 4; j <=i ; j+=2) {
                dp[i]+=dp[i-j]*2;
            }
        }
        System.out.println(dp[n]);
    }
}
