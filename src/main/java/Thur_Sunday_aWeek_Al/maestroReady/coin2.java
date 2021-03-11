package Thur_Sunday_aWeek_Al.maestroReady;

import java.util.Arrays;
import java.util.Scanner;

// 동전의 양은 무한대 이므로 사용가능하다.
// 동전의 양이 무한대가 아니라 한정되어 있다면 소마 2번 pc방 문제.
public class coin2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int coin[]=new int[n];
        for (int i = 0; i < n; i++) {
            coin[i]=sc.nextInt();
        }
        int dp[]=new int[k+1];


        Arrays.fill(dp,10001);
        dp[0]=0;
        for (int i = 0; i < n; i++) {
            for (int j = coin[i]; j <=k ; j++) {
                if(dp[j-coin[i]]!=10001)
                    dp[j]=Math.min(dp[j],dp[j-coin[i]]+1);
            }
        }
        if(dp[k]==10001)
        {
            System.out.println(-1);
        }
        else
        {
            System.out.println(dp[k]);
        }
    }
}
