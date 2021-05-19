package WeeklyThuseday.Dynamic;

import java.util.Arrays;
import java.util.Scanner;

public class FristGrade {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        int dp[]=new int[n+1];

        for (int i = 2 ; i < n+1; i++) {
            dp[i]=dp[i-1]+1;
            if(i%2==0)
            {
                if(dp[i]>dp[i/2]+1)
                    dp[i]=dp[i/2]+1;

            }
            if(i%3==0)
            {
                if(dp[i]>dp[i/3]+1)
                    dp[i]=dp[i/3]+1;
            }
        }
        System.out.println(Arrays.toString(dp));
        System.out.println(dp[n]);
    }
}
