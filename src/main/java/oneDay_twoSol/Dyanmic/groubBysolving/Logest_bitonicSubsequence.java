package oneDay_twoSol.Dyanmic.groubBysolving;

import java.util.Arrays;
import java.util.Scanner;

public class Logest_bitonicSubsequence {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int subSequence[]=new int[n];
        for (int i = 0; i < n; i++) {
            subSequence[i]=sc.nextInt();
        }

        int dp[]=new int[n];
        int dp2[]=new int[n];
        // init
        for (int i = 0; i <n ; i++) {
            dp[i]=1;
        }
        for (int i = 0; i <n ; i++) {
            dp2[i]=1;
        }
        // logic
        for (int i = 1; i <n ; i++) {
//            LIS
            for (int j = 0; j <i ; j++) {
                if(subSequence[i]>subSequence[j])
                    dp[i]=Math.max(dp[i],dp[j]+1);
            }
        }
        for (int i = n-2; i >=0 ; i--) {
            for (int j = n-1; j >i ; j--) {
                if(subSequence[i]>subSequence[j])
                    dp2[i]=Math.max(dp2[i],dp2[j]+1);
            }
        }

        System.out.println(Arrays.toString(dp));
        System.out.println(Arrays.toString(dp2));
        int max=0;
        for (int i = 0; i <n ; i++) {
            if(max<dp[i]+dp2[i])
            {
                max=dp[i]+dp2[i];
            }
        }
        System.out.println(max-1);
    }
}
