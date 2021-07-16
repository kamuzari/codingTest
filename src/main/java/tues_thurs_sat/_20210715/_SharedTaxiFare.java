package tues_thurs_sat._20210715;

import java.util.Arrays;

public class _SharedTaxiFare {

    public static void main(String[] args) {
        int fares[][] = {
//                {4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}
                {5, 7, 9}, {4, 6, 4}, {3, 6, 1}, {3, 2, 3}, {2, 1, 6}
        };
//        System.out.println(solution(6,4,6,2,fares));
        System.out.println(solution(7, 3, 4, 1, fares));
    }

    static int INF = (int) 1e9;
    public static int solution(int n, int s, int a, int b, int[][] fares) {
        int matrix[][] = new int[n + 1][n + 1];
        for (int i = 1; i < n + 1; i++) {
            Arrays.fill(matrix[i], INF);
            matrix[i][i] = 0;
        }

        for (int i = 0; i < fares.length; i++) {
            int v1 = fares[i][0];
            int v2 = fares[i][1];
            int cost = fares[i][2];
            matrix[v1][v2] = cost;
            matrix[v2][v1] = cost;
        }
        for (int k = 0; k < n+1; k++) {
            for (int i = 0; i < n+1; i++) {
                for (int j = 0; j < n+1; j++) {
                    if(matrix[i][j]>matrix[i][k]+matrix[k][j])
                    {
                        matrix[i][j]=matrix[i][k]+matrix[k][j];
                    }
                }
            }
        }
        int min=INF;
        for (int i = 1; i < n+1; i++) {
            if(matrix[s][i]!=INF && matrix[i][a]!=INF && matrix[i][b]!=INF)
                min=Math.min(min,matrix[s][i]+matrix[i][a]+matrix[i][b]);
        }
        return min;

    }
}
