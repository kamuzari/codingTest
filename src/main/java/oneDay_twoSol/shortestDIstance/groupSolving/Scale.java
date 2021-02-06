package oneDay_twoSol.shortestDIstance.groupSolving;

import java.util.Arrays;
import java.util.Scanner;

public class Scale {
    static int INF = (int) 1e9;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int matrix[][] = new int[n + 1][n + 1];

        for (int i = 1; i < n + 1; i++) {
            Arrays.fill(matrix[i], INF);
        }
        for (int i = 0; i <n+1 ; i++) {
            matrix[i][i]=0;
            matrix[i][0]=0;
        }
        for (int i = 0; i < m; i++) {
            matrix[sc.nextInt()][sc.nextInt()] = 1;
        }
        for (int k = 1; k < n + 1; k++) {
            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                }
            }
        }
        for (int i = 1; i < n + 1; i++) {
            int cnt = 0;
            for (int j = 1; j < n + 1; j++) {
                if (i!=j &&(matrix[i][j] != INF || matrix[j][i] != INF))
                    cnt++;
            }
            System.out.println(n-cnt-1);
        }
    }
}
