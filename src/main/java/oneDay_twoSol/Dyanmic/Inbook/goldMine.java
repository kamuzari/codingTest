package oneDay_twoSol.Dyanmic.Inbook;

import java.util.Arrays;

public class goldMine {
    static int n, m;

    public static void main(String[] args) {
        int info[][] = {
                {0, 0, 0, 0, 0},
                {0, 1, 3, 3, 2},
                {0, 2, 1, 4, 1},
                {0, 0, 6, 4, 7},
                {0, 0, 0, 0, 0}
        };
        n = 3;
        m = 4;
        n += 1;
        m += 1;
        mineMax(info);
    }

    static int dp[][];

    public static void mineMax(int info[][]) {
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
            info[i][j]=info[i][j]+Math.max(Math.max(info[i-1][j-1],info[i][j-1]),info[i+1][j-1]);
            }
        }
        System.out.println(info.length);
        for (int i = 0; i <info.length ; i++) {
            System.out.println(Arrays.toString(info[i]));
        }
        System.out.println(info[n-1][m-1]);
    }
}
