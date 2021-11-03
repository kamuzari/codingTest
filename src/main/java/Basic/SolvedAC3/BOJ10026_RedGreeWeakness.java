package Basic.SolvedAC3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10026_RedGreeWeakness {
    static final int NOT_WAEKNESS = 0;
    static final int WAEKNESS = 1;
    private static char[][][] map;
    private static int n;
    private static boolean[][][] v;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new char[2][n][n];
        for (int i = 0; i < n; i++) {
            char[] ch = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                if (ch[j] != 'B') {
                    map[WAEKNESS][i][j] = 'Y';
                } else {
                    map[WAEKNESS][i][j] = ch[j];
                }
                map[NOT_WAEKNESS][i][j] = ch[j];
            }
        }
        v = new boolean[2][n][n];
        int[] answer = new int[2];
        for (int k = 0; k < 2; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!v[k][i][j]) {
                        answer[k]++;
                        dfs(k, i, j);
                    }
                }
            }
        }
        System.out.println(answer[0] + " " + answer[1]);
    }

    static int dy[] = {-1, 1, 0, 0};
    static int dx[] = {0, 0, -1, 1};

    private static void dfs(int isWeak, int y, int x) {
        v[isWeak][y][x] = true;
        for (int i = 0; i < 4; i++) {
            int ny = dy[i] + y;
            int nx = dx[i] + x;
            if (indexOutOf(ny, nx) || v[isWeak][ny][nx]) continue;
            if (map[isWeak][ny][nx] != map[isWeak][y][x]) continue;
            dfs(isWeak, ny, nx);
        }
    }

    static boolean indexOutOf(int ny, int nx) {
        return ny < 0 || nx < 0 || ny > n - 1 || nx > n - 1;
    }
}
