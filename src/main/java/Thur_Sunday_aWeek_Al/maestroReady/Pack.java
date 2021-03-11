package Thur_Sunday_aWeek_Al.maestroReady;

import java.util.Scanner;

public class Pack {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int pack[][]=new int[n+1][2];
        for (int i = 1; i < n+1; i++) {
            pack[i][0]=sc.nextInt();
            pack[i][1]=sc.nextInt();
        }

        int dp[][]=new int[n+1][k+1];

        for (int i = 1; i < n+1; i++) {
            for (int j =1; j <=k ; j++) {
                dp[i][j]=dp[i-1][j];
                if(j-pack[i][0]>=0)
                {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-pack[i][0]]+pack[i][1]);
                }
            }
        }
        System.out.println(dp[n][k]);


        


    }

}
