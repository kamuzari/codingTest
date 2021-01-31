package oneDay_twoSol.Dyanmic.groubBysolving;

import java.util.Arrays;
import java.util.Scanner;

public class easyStairs {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        long dp[][]=new long[n+2][10];
        for (int i = 1; i<10; i++) {
            dp[1][i]=1;
            if(i==9)
                dp[2][i]=1;
            else
                dp[2][i]=2;
        }
        for (int i = 3; i<n+1; i++) {
            for (int j = 1; j < 10; j++) {
                 if(j==1)
                {
                    dp[i][j]=(dp[i-2][j]+dp[i-1][j+1])%1000000000;
                }
                 else if(j==9)
                 {
                     dp[i][j]=(dp[i-1][j-1])%1000000000;// 9인경우 뒤에는 8밖에 나올수 없으므로 한 행 전에 [8]번째를 참조한다.
                 }
                else
                {
                    dp[i][j]=( dp[i-1][j-1]+dp[i-1][j+1] )% 1000000000;
                }
            }
        }
        int sum=0;
        for (int i = 1; i < 10; i++) {
            sum+=dp[n][i]%1000000000;
        }
        System.out.println(Arrays.stream(dp[n]).sum()%1000000000);
    }
}
