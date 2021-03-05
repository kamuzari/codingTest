package oneDay_twoSol.DFS_BFS2.Theory;

public class drinkFreeze {
    static int n = 4;
    static int m = 5;
    static int cnt = 0;
    static int dy[] = {-1, 1, 0, 0};
    static int dx[] = {0, 0, -1, 1};
    static boolean visited[][];
    static int drink[][];

    public static void main(String[] args) {
        drink = new int[][]{
                {0, 0, 1, 1, 0},
                {0, 0, 0, 1, 1},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0},
        };
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (drink[i][j] == 0 && !visited[i][j]) {
                    DFS(i, j);
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }

    public static void DFS(int y, int x) {
        visited[y][x] = true;
        for (int i = 0; i < 4; i++) {
            int ny = dy[i] + y;
            int nx = dx[i] + x;
            if (ny >= 0 && nx >= 0 && ny<n && nx< m && !visited[ny][nx]) {
                if (drink[ny][nx] == 0)
                    DFS(ny, nx);
            }
        }
    }
}
