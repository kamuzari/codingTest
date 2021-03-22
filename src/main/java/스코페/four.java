package 스코페;

import java.util.*;

public class four {
    static int n, m;
    static int map[][];
    static boolean visited[][];
    static int dy[] = {1, 0, 0};
    static int dx[] = {0, -1, 1};
    static ArrayList<Node> startDot = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[m][n];
        sc.nextLine();
        for (int i = 0; i < m; i++) {
            String str[] = sc.nextLine().split("");
            for (int j = 0; j < n; j++) {
                char ch = str[j].charAt(0);
                if (ch == '.' || ch == 'c') {
                    if (ch == 'c')
                        startDot.add(new Node(i, j, 0));
                    map[i][j] = 1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(map[i]));
        }

        System.out.println("-------------------------------");
        int min = (int) 1e9;
        for (Node start : startDot) {
            Queue<Node> q = new LinkedList<>();
            visited = new boolean[m][n];
            visited[start.y][start.x] = true;
            q.offer(start);
            while (!q.isEmpty()) {
                Node cur = q.poll();
                if (cur.y == m - 1) {
                    min = Math.min(min, cur.LRCnt);
                }
                for (int i = 0; i < 3; i++) {
                    int ny = cur.y + dy[i];
                    int nx = cur.x + dx[i];

                    if (ny >= 0 && nx >= 0 && ny < m && nx < n && !visited[ny][nx]) {
                        if (map[ny][nx] == 1) {
                            visited[ny][nx] = true;
                            if (i > 0)
                                q.offer(new Node(ny, nx, cur.LRCnt + 1));
                            else
                                q.offer(new Node(ny, nx, cur.LRCnt));
                        }
                    }
                }
            }
        }
        if (min == (int) 1e9)
            System.out.println(-1);
        else
            System.out.println(min);
    }

    static class Node {
        int y;
        int x;
        int LRCnt;

        public Node(int y, int x, int LRCnt) {
            this.y = y;
            this.x = x;
            this.LRCnt = LRCnt;
        }
    }
}
