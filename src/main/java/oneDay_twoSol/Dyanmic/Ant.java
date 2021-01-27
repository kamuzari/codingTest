package oneDay_twoSol.Dyanmic;

import java.util.Arrays;
import java.util.Scanner;

public class Ant {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();
        String str[]=sc.nextLine().split(" ");
        int arr[]=new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=Integer.parseInt(str[i]);
        }
        System.out.println(Arrays.toString(arr));
        int dp[]=new int[n] ;
        dp[0]=arr[0];
        dp[1]=Math.max(arr[0],arr[1]);
        for (int i = 2; i <n ; i++) {
            System.out.println(dp[i-1]);
            System.out.println(dp[i-2]+arr[i]);
            dp[i]=Math.max(dp[i-1],dp[i-2]+arr[i]);
        }
        System.out.println(dp[n-1]);
    }
}
