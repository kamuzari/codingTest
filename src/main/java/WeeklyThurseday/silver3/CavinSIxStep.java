package WeeklyThurseday.silver3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CavinSIxStep {
    static int INF = (int) 1e9;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int adjMatrix[][] = new int[n + 1][n + 1];
        for (int i = 1; i < n + 1; i++) {
            Arrays.fill(adjMatrix[i], INF);
        }
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            adjMatrix[a][b] = 1;
            adjMatrix[b][a] = 1;

        }

        for (int k = 1; k < n + 1; k++) {
            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    adjMatrix[i][j] = Math.min(adjMatrix[i][j], adjMatrix[i][k] + adjMatrix[k][j]);
                }
            }
        }
        int min = INF;
        int seq = 0;
        ArrayList<Integer> personNumber = new ArrayList<>();
        for (int i = 1; i < n + 1; i++) {
            int sum = 0;
            for (int j = 1; j < n + 1; j++) {
                sum += adjMatrix[i][j];
//                System.out.print(adjMatrix[i][j]+" ");
            }
//            System.out.println();
            if (min > sum) {
                min = sum;
                seq=i;
            }
            personNumber.add(sum);
            sum = 0;
        }

        System.out.println(seq);
    }
}
