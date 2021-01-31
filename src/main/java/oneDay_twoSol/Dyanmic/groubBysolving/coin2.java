package oneDay_twoSol.Dyanmic.groubBysolving;

import java.util.Arrays;
import java.util.Scanner;

public class coin2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int coin_value[]=new int[n];
        for (int i = 0; i < n; i++) {
            coin_value[i]=sc.nextInt();
        }
        int coin[]=new int[k+1];

        for (int i = 1; i <k+1; i++) {
            coin[i]=10001;
        }


        for (int i = 0; i <n ; i++) {
            for (int j = coin_value[i]; j <k+1 ; j++) {
                if(j-coin_value[i]>=0)
                   coin[j] = Math.min(coin[j],coin[j-coin_value[i]]+1);
            }
        }
        System.out.println(Arrays.toString(coin));
        if(coin[k]==10001)
        {
            System.out.println(-1);
        }
        else
            System.out.println(coin[k]);
    }
}
