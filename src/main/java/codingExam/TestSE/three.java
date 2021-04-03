package codingExam.TestSE;

import java.util.Scanner;

public class three {
    static int n;
    static int[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }
//        for (int i = 0; i <n ; i++) {
//            System.out.println(Arrays.toString(map[i]));
//        }
        System.out.println(devide(0, 0, n, n));

    }

    public static int devide(int y1, int x1, int y2, int x2) {
        int middle_Y = (y1 + y2) / 2;
        int middle_X = (x1 + x2) / 2;
        int sum1 = 0;
        int sum2 = 0;
        if (middle_X != x1) {
            for (int i = y1; i < y2; i++) {
                for (int j = middle_X; j < x2; j++) {
                    sum1 = Math.max(sum1, map[i][j]);
                }
            }
            sum1 += devide(y1, x1, y2, middle_X);
        }
        if (middle_X != x1) {
            for (int i = y1; i < y2; i++) {
                for (int j = x1; j < middle_X; j++) {
                    sum2 = Math.max(sum2, map[i][j]);
                }
            }
            sum2 += devide(y1, middle_X, y2, x2);
        }

        int sum3 = 0;
        int sum4 = 0;
        if (middle_Y != y1) {
            for (int i = middle_Y; i < y2; i++) {
                for (int j = x1; j < x2; j++) {
                    sum3 = Math.max(sum3, map[i][j]);
                }
            }
            sum3 += devide(y1, x1, middle_Y, x2);
        }
        if (middle_Y != y1) {
            for (int i = y1; i < middle_Y; i++) {
                for (int j = x1; j < middle_X; j++) {
                    sum4 = Math.max(sum4, map[i][j]);
                }
            }
            sum4 += devide(middle_Y, x1, y2, x2);
        }
        return Math.max(Math.max(sum1, sum2), Math.max(sum3, sum4));
    }
}
