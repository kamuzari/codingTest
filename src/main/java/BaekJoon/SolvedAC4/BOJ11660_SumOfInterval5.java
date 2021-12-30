package BaekJoon.SolvedAC4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11660_SumOfInterval5 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int arr[][] = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int copyArr[][] = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            copyArr[i] = arr[i].clone();
        }
        inItAccumulateArrays(copyArr, n);
        StringBuilder answers = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int y1 = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            answers.append(sumOfInterval(y1, x1, y2, x2, copyArr)).append("\n");
        }
        System.out.println(answers);
    }

    static void printArrays(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }

    static void inItAccumulateArrays(int[][] arr, int size) {
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                arr[i][j] += arr[i][j - 1] + arr[i - 1][j] - arr[i - 1][j - 1];
            }
        }
    }

    static int sumOfInterval(int y1, int x1, int y2, int x2, int[][] accumulateArr) {
        return accumulateArr[y2][x2] - accumulateArr[y2][x1 - 1] - accumulateArr[y1 - 1][x2] + accumulateArr[y1 - 1][x1 - 1];
    }
}
