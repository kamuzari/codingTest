package Basic.DFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SecurityArea {
    static int n;
    static int map[][];
    static boolean visisted[][];
    static int dy[] = {-1, 1, 0, 0};
    static int dx[] = {0, 0 ,- 1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int creteria=0;
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
                creteria=Math.max(map[i][j],creteria);
            }
        }
        int max=-1;
        for (int k = 0; k <=creteria; k++) {
            visisted = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visisted[i][j]&&k<map[i][j])
                    {
                        BFS(i,j,k);
                        cnt++;
                    }
                }
            }
            max=Math.max(max,cnt);
            cnt=0;
        }
        System.out.println(max);
    }
    static int cnt=0;

    static void BFS(int y, int x, int limit) {
        Queue<Position> q = new LinkedList<>();

        visisted[y][x] = true;
        q.add(new Position(y, x));
        while (!q.isEmpty()) {
            Position cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];
                if (ny >= 0 && nx >= 0 && ny < n && nx < n && !visisted[ny][nx]) {
                    if (limit < map[ny][nx]) {
                        visisted[ny][nx] = true;
                        q.offer(new Position(ny, nx));
                    }
                }
            }
        }

    }

    static class Position {
        int y, x;

        public Position(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
