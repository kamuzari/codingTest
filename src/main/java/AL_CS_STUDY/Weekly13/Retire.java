package AL_CS_STUDY.Weekly13;

import java.util.Scanner;

public class Retire {
    static int k;
    static int temp[][];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        k = n;
        temp = new int[n][2];
        int consulting[][] = new int[n][2];
        for (int i = 0; i < n; i++) {
            int day = sc.nextInt();
            int profit = sc.nextInt();
            temp[i][0] = consulting[i][0] = day;
            temp[i][1] = consulting[i][1] = profit;

        }
        int dp[] = new int[n + 1];
        int max = 0;
        for (int i = n - 1; i >= 0; i--) {
            int time = consulting[i][0] + i;
            if (time < n + 1) {
                max = dp[i] = Math.max(consulting[i][1] + dp[time], max);
            } else
                dp[i] = max;
        }
        System.out.println(max);


    }

    static int max2 = 0;


}
