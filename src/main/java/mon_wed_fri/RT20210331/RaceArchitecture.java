package mon_wed_fri.RT20210331;

import java.util.LinkedList;
import java.util.Queue;

public class RaceArchitecture {
    static int dy[] = {-1, 1, 0, 0};
    static int dx[] = {0, 0, -1, 1};
    static int n, map[][];
    static int ans=Integer.MAX_VALUE;

    public static void main(String[] args) {
        int b[][] = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        System.out.println(solution(b));
        int b2[][]={
                {0,0,0,0,0,0,0,1},{0,0,0,0,0,0,0,0},{0,0,0,0,0,1,0,0},{0,0,0,0,1,0,0,0},{0,0,0,1,0,0,0,1},{0,0,1,0,0,0,1,0},{0,1,0,0,0,1,0,0},{1,0,0,0,0,0,0,0}
        };
        ans=Integer.MAX_VALUE;
        System.out.println(solution(b2));
    }

    public static int solution(int[][] board) {
        n = board.length;
        map = board;
        bfs(0, 0, 0, -1);
        return ans;
    }

    public static void bfs(int y, int x, int cost, int dir) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(y, x, cost, dir));
        map[y][x] = 1;
        while (!q.isEmpty()) {
            Node cur = q.poll();
            if (cur.y == n - 1 && cur.x == n - 1) {
                ans = Math.min(ans, cur.cost);
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int ny = dy[i] + cur.y;
                int nx = dx[i] + cur.x;
                if (ny >= 0 && nx >= 0 && ny < n && nx < n && map[ny][nx] != 1) {
                    int newCost = 0;
                    if (cur.dir == -1 || cur.dir == i) {
                        // 직진
                        newCost = cur.cost + 100;
                    } else if (cur.dir != i) {
                        // 코너 만들기
                        newCost = cur.cost + 600;
                    }

                    if (map[ny][nx] == 0) {
                        map[ny][nx] = newCost;
                        q.add(new Node(ny, nx, newCost, i));
                    } else if (map[ny][nx] >= newCost) {
                        map[ny][nx] = newCost;
                        q.add(new Node(ny, nx, newCost, i));
                    }
                }

            }
        }
    }

    static class Node {
        private int y, x, cost, dir;

        public Node(int y, int x, int cost, int dir) {
            this.y = y;
            this.x = x;
            this.cost = cost;
            this.dir = dir;
        }
    }
}
