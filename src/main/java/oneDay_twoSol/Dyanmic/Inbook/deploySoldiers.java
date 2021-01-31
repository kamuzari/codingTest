package oneDay_twoSol.Dyanmic.Inbook;

import java.util.Arrays;
import java.util.Scanner;

public class deploySoldiers {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int combatPower[]=new int[n];
        sc.nextLine();
        String str[]=sc.nextLine().split(" ");
        int idx=0;
        for (int i = n-1; i >-1; i--) {
            combatPower[i]=Integer.parseInt(str[idx++]);
        }
        int dp[]=new int[n];
        for (int i = 0; i < n; i++) {
            dp[i]=1;
        }
//        System.out.println(Arrays.toString(combatPower));

        //LIS 최장증가수열
        for (int i = 1; i <n ; i++) {
            for (int j = 0; j <i ; j++) {
                if(combatPower[i]>combatPower[j])
                    dp[i]=Math.max(dp[i],dp[j]+1);
            }
        }
//        System.out.println(Arrays.toString(dp));
        int max=0;
        Arrays.sort(dp);

        System.out.println(n-dp[n-1]);
    }
}
