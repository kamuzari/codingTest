package oneDay_twoSol.RealTimeSolving;

import java.util.Arrays;
import java.util.Scanner;

public class 조짜기 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        sc.nextLine();
        String str[]=sc.nextLine().split(" ");
        int arr[]=new int[n+1];
        int dp[]=new int[n+1];
        for (int i = 0; i <str.length ; i++) {
            arr[i+1]=Integer.parseInt(str[i]);
        }
        System.out.println(Arrays.toString(arr));
        for (int i = 2; i <arr.length ; i++) {
            int min=Integer.MAX_VALUE;
            int max=Integer.MIN_VALUE;
            for (int j = i; j >=1 ; j--) {
                max=Math.max(max,arr[j]);
                min=Math.min(min,arr[j]);
                dp[i]=Math.max(dp[i],max-min+dp[j-1]);
                System.out.println(Arrays.toString(dp));
            }
            System.out.println();
        }
        System.out.println(dp[n]);

    }
}
