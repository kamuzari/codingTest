package BaekJoon.SolvedAC3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1780_PaperNumber {
    private static int[][] paper;
    private static int n;
    private static int[] answer = new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        paper = new int[n][n];
        boolean flag = true;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        partition(0, 0, n);
        for (int val : answer) {
            System.out.println(val);
        }
    }

    private static void partition(int r, int c, int size) {
        if (check(r, c, size)) {
            int val = paper[r][c];
            if (val == -1) {
                answer[0]++;
            } else if (val == 0) {
                answer[1]++;
            } else if (val == 1) {
                answer[2]++;
            }
            return;
        }
        partition(r, c, size / 3);
        partition(r, c + size / 3, size / 3);
        partition(r, c + size / 3 * 2, size / 3);

        partition(r + size / 3, c, size / 3);
        partition(r + size / 3, c + size / 3, size / 3);
        partition(r + size / 3, c + size / 3 * 2, size / 3);

        partition(r + size / 3 * 2, c, size / 3);
        partition(r + size / 3 * 2, c + size / 3, size / 3);
        partition(r + size / 3 * 2, c + size / 3 * 2, size / 3);
    }

    private static boolean check(int r, int c, int size) {
        int pivot = paper[r][c];
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (pivot != paper[i][j]) return false;
            }
        }
        return true;
    }
}
