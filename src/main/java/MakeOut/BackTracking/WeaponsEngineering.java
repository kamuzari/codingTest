package MakeOut.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class WeaponsEngineering {
    static final int INF = Integer.MIN_VALUE;
    static int max = INF;
    private static int n;
    private static int m;
    private static int[][] wood;
    private static boolean[][] v;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        wood = new int[n][m];
        v = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                wood[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        pick(0, 0);
        int answer = max == INF ? -1 : max;
        System.out.println(answer);
    }

    static void pick(int idx, int sum) {
        if (idx == n * m) {
            max = Math.max(max, sum);
            return;
        }

        int row = idx / m;
        int col = idx % m;

        if (!v[row][col]) {
            if (promisingWaepon(row, col, 1)) {
                v[row][col] = true;
                v[row + 1][col] = true;
                v[row][col - 1] = true;
                int midSum = sum + getWaepon(row, col, 1);
                pick(idx + 1, midSum);
                v[row][col] = false;
                v[row + 1][col] = false;
                v[row][col - 1] = false;
            }
            if (promisingWaepon(row, col, 2)) {
                v[row][col] = true;
                v[row - 1][col] = true;
                v[row][col - 1] = true;
                int midSum = sum + getWaepon(row, col, 2);
                pick(idx + 1, midSum);
                v[row][col] = false;
                v[row - 1][col] = false;
                v[row][col - 1] = false;
            }
            if (promisingWaepon(row, col, 3)) {
                v[row][col] = true;
                v[row - 1][col] = true;
                v[row][col + 1] = true;
                int midSum = sum + getWaepon(row, col, 3);
                pick(idx + 1, midSum);
                v[row][col] = false;
                v[row - 1][col] = false;
                v[row][col + 1] = false;
            }
            if (promisingWaepon(row, col, 4)) {
                v[row][col] = true;
                v[row + 1][col] = true;
                v[row][col + 1] = true;
                int midSum = sum + getWaepon(row, col, 4);
                pick(idx + 1, midSum);
                v[row][col] = false;
                v[row + 1][col] = false;
                v[row][col + 1] = false;
            }
        }
        pick(idx + 1, sum);
    }

    static boolean promisingWaepon(int row, int col, int idx) {
        switch (idx) {
            case 1:
                return !outOfIndex(row + 1, col - 1) && !v[row + 1][col] && !v[row][col - 1];
            case 2:
                return !outOfIndex(row - 1, col - 1) && !v[row - 1][col] && !v[row][col - 1];
            case 3:
                return !outOfIndex(row - 1, col + 1) && !v[row - 1][col] && !v[row][col + 1];
            case 4:
                return !outOfIndex(row + 1, col + 1) && !v[row + 1][col] && !v[row][col + 1];
            default:
                return false;
        }
    }

    private static int getWaepon(int y, int x, int idx) {
        switch (idx) {
            case 1:
                return wood[y + 1][x] + wood[y][x - 1] + wood[y][x] * 2;
            case 2:
                return wood[y - 1][x] + wood[y][x - 1] + wood[y][x] * 2;
            case 3:
                return wood[y - 1][x] + wood[y][x + 1] + wood[y][x] * 2;
            case 4:
                return wood[y + 1][x] + wood[y][x + 1] + wood[y][x] * 2;
            default:
                return -1;
        }
    }

    static boolean outOfIndex(int y, int x) {
        return (y < 0 || x < 0 || y > n - 1 || x > m - 1);
    }

}
