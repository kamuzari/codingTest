package tues_thurs_sat.simulation;

import java.util.Scanner;

public class voyagerOne {
    static int n, m;
    static char[][] map;
    static int dy[] = {-1, 0, 1, 0};
    static int dx[] = {0, 1, 0, -1};
    static int visited[][];

    // 재방문은 visited[]만이 아닌 방향도 기억하고 있어야 한다.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new char[n][m];
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            map[i] = str.toCharArray();
        }
        int y = sc.nextInt() - 1;
        int x = sc.nextInt() - 1;


        int ans = -1;
        int dir = 0;
        for (int i = 0; i < 4; i++) {
            visited = new int[n][m];
            int t = dfs(y, x, i, 1);
            if (t == -1) {
                exchange(i);
                System.out.print("Voyager");
                return;
            } else if (ans < t) {
                ans=t;
                dir=i;
            }
        }
        exchange(dir);
        System.out.print(ans);
    }

    public static int dfs(int y, int x, int dir, int cnt) {
        visited[y][x] = dir + 1;
        if (map[y][x] == '\\') {
            if (dir == 0) {
                dir = 3;
            } else if (dir == 1) {
                dir = 2;
            } else if (dir == 2) {
                dir = 1;
            } else if (dir == 3) {
                dir = 0;
            }
        } else if (map[y][x] == '/') {
            if (dir == 0) {
                dir = 1;
            } else if (dir == 1) {
                dir = 0;
            } else if (dir == 2) {
                dir = 3;
            } else if (dir == 3) {
                dir = 2;
            }
        }

        int ny = y + dy[dir];
        int nx = x + dx[dir];
        if (ny < 0 || nx < 0 || ny >= n || nx >= m || map[ny][nx] == 'C') {
            return cnt;
        } else if (visited[ny][nx] == dir + 1) {
            return -1;
        }
        int dist = dfs(ny, nx, dir, cnt + 1);
        return dist;
    }

    public static void exchange(int dir) {
        switch (dir) {
            case 0:
                System.out.println("U");
                break;
            case 1:
                System.out.println("R");
                break;
            case 2:
                System.out.println("D");
                break;
            case 3:
                System.out.println("L");
                break;
        }
    }
}
