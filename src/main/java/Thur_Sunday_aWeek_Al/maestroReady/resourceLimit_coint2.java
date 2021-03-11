package Thur_Sunday_aWeek_Al.maestroReady;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class resourceLimit_coint2 {
    static Map<Integer,Integer> map=new TreeMap<>();
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int coin[]=new int[n];
        for (int i = 0; i < n; i++) {
            coin[i]=sc.nextInt();
            if(map.containsKey(coin[i]))
            {
                map.put(coin[i],map.getOrDefault(coin[i],0)+1);
            }
            else
                map.put(coin[i],1);
        }

        System.out.println(map);
        int dp[]=new int[k+1];

        Arrays.fill(dp,10001);
        dp[0]=0;
        for (int i = 0; i < n; i++) {
            for (int j = coin[i]; j <=k ; j++) {
                if(dp[j-coin[i]]!=10001) {
                    if(j/coin[i]<=map.get(coin[i]))
                        dp[j] = Math.min(dp[j], dp[j - coin[i]] + 1);
                }
            }
        }
        if(dp[k]==10001)
        {
            System.out.println(Arrays.toString(dp));
            for (int i = k; i >=0 ; i--) {
                if(dp[i]!=10001)
                {
                    System.out.println(i);
                    break;
                }
            }
        }
        else
        {
            System.out.println(dp[k]);
        }
    }
}
