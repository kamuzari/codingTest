package AL_CS_STUDY.Weekly19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ColorWheel {
    static final int mod=1_000_000_003;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int k=Integer.parseInt(br.readLine());
        int dp[][]=new int[n+1][n+1];
        // i개 의 색이 있을 때 j개의 색을 선택하는 경우의 수
        for (int i = 1; i < n+1; i++) {
            dp[i][1]=i;
            dp[i][0]=1;
        }

        for (int i = 3; i < n+1; i++) {
            for (int j = 2; j <=(i+1)/2 ; j++) {
                dp[i][j]=(dp[i-1][j]+dp[i-2][j-1])%mod;
            }
        }
        System.out.println((dp[n-3][k-1]+dp[n-1][k])%mod);
    }
}
