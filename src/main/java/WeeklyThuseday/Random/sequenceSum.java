package WeeklyThuseday.Random;

import java.util.Arrays;
import java.util.Scanner;

public class sequenceSum {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        int arr[]=new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=sc.nextInt();
        }
        int dp[]=new int[n];
        dp[0]=arr[0];

        for (int i = 1; i < n; i++) {
            dp[i]=Math.max(dp[i-1]+arr[i],arr[i]);
        }

        Arrays.sort(dp);
        System.out.println(dp[n-1]);
    }
}
//https://zoonvivor.tistory.com/152