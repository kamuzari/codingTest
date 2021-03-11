package Thur_Sunday_aWeek_Al.SW_MaestroReady;

import java.util.Scanner;

public class LongestIncreasingPartSequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int dp[] = new int[n];

        dp[0]=1;

        for (int i = 1; i <n ; i++) {
            dp[i]=1;
            for (int j = 0; j < i; j++) {
                if(arr[j]<arr[i]&& dp[i]<=dp[j])
                    dp[i]=dp[j]+1;
            }
        }

        int max=0;
        for (int i : dp) {
            max=Math.max(i,max);
        }

        System.out.println(max);
    }
}
