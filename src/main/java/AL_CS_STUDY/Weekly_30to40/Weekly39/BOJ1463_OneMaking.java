package AL_CS_STUDY.Weekly_30to40.Weekly39;
import java.io.*;
import java.util.Arrays;

public class BOJ1463_OneMaking {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());

        int dp[]=new int[n+1];
        Arrays.fill(dp,1_000_001);
        dp[1]=0;
        for (int i = 2; i < n+1; i++) {
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
