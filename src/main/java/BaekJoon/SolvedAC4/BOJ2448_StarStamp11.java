package BaekJoon.SolvedAC4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BOJ2448_StarStamp11 {

    static char map[][];
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new char[n][2 * n - 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(map[i], ' ');
        }
        stampStar(0, n - 1, n);
        print();
    }

    private static void stampStar(int y, int x, int n) {
        if (n == 3) {
            map[y][x] = '*';
            map[y + 1][x - 1] = map[y + 1][x + 1] = '*';
            for (int j = x - 2; j <= x + 2; j++) {
                map[y + 2][j] = '*';
            }
            return;
        }
        stampStar(y, x, n / 2);
        stampStar(y + n / 2, x - n / 2, n / 2);
        stampStar(y + n / 2, x + n / 2, n / 2);
    }

    private static void print() throws IOException {
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2 * n - 1; j++) {
                bw.write(map[i][j]);
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}
