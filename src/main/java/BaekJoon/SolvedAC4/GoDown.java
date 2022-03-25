package BaekJoon.SolvedAC4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GoDown {

    static final int DEFAULT_COLUMN = 3;
    static final int FIRST = 0;
    static final int SECOND = 1;
    static final int THIRD = 2;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int map[][] = new int[n][DEFAULT_COLUMN];
        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split(" ");
            map[i][FIRST] = Integer.parseInt(split[FIRST]);
            map[i][SECOND] = Integer.parseInt(split[SECOND]);
            map[i][THIRD] = Integer.parseInt(split[THIRD]);
        }

        int maximumValue = getMaximumValue(n, map);
        int minimumValue = getMinimumValue(n, map);
        System.out.println(maximumValue + " " + minimumValue);
    }

    private static int getMaximumValue(int n, int[][] map) {
        int[][] temp = cloneOriginal(n, map);
        for (int i = 1; i < n; i++) {
            temp[i][FIRST] += Math.max(temp[i - 1][FIRST], temp[i - 1][SECOND]);
            temp[i][SECOND] += Math
                .max(temp[i - 1][FIRST], Math.max(temp[i - 1][SECOND], temp[i - 1][THIRD]));
            temp[i][THIRD] += Math.max(temp[i - 1][THIRD], temp[i - 1][SECOND]);
        }
        return Math.max(temp[n - 1][FIRST], Math.max(temp[n - 1][SECOND], temp[n - 1][THIRD]));
    }

    private static int[][] cloneOriginal(int n, int[][] map) {
        int temp[][] = new int[n][DEFAULT_COLUMN];
        for (int i = 0; i < n; i++) {
            temp[i] = map[i].clone();
        }
        return temp;
    }

    private static int getMinimumValue(int n, int[][] map) {
        int[][] temp = cloneOriginal(n, map);
        for (int i = 1; i < n; i++) {
            temp[i][FIRST] += Math.min(temp[i - 1][FIRST], temp[i - 1][SECOND]);
            temp[i][SECOND] += Math
                .min(temp[i - 1][FIRST], Math.min(temp[i - 1][SECOND], temp[i - 1][THIRD]));
            temp[i][THIRD] += Math.min(temp[i - 1][THIRD], temp[i - 1][SECOND]);
        }
        return Math.min(temp[n - 1][FIRST], Math.min(temp[n - 1][SECOND], temp[n - 1][THIRD]));
    }


}
