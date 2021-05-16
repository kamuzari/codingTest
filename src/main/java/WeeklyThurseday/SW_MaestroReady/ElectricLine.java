package WeeklyThurseday.SW_MaestroReady;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class ElectricLine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[][] = new int[n][2];
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String s[] = sc.nextLine().split(" ");
            arr[i][0] = Integer.parseInt(s[0]);
            arr[i][1] = Integer.parseInt(s[1]);
        }
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int dp[] = new int[n];
        int max=0;
        for (int i = 1; i < n; i++) {
            dp[i]=1;
            for (int j = 0; j <i ; j++) {
                if(arr[i][1]>arr[j][1])
                {
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            max=Math.max(max,dp[i]);
        }
        System.out.println(n-max);
    }
}
