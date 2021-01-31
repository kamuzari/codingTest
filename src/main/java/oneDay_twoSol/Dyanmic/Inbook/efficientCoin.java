package oneDay_twoSol.Dyanmic;

import java.util.Arrays;

public class efficientCoin {
    static int max;
    public static void main(String[] args) {
        int n=3;
        int m=10;
        int coin[]={3,5,7};
        max= coin[n-1];
        effiCoin(coin,n,m);
    }
    static int dp[];
    static void effiCoin(int arr[],int coinNumber,int targetCoin)
    {
        dp=new int[targetCoin+1];

        for (int i = 1; i < dp.length; i++) {
            dp[i]=-1;
        }
        for (int i = 0; i <arr.length; i++) {
            dp[arr[i]]=1;
        }
        System.out.println(Arrays.toString(dp));

        for (int i = 0; i < arr.length; i++) {
            for (int j = arr[i]; j < targetCoin+1; j+=arr[i]) {
                dp[j]=dp[j-arr[i]]+1;
            }
        }System.out.println(Arrays.toString(dp));
        System.out.println();

        System.out.println(dp[targetCoin]);
    }
}
