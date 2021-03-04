package oneDay_twoSol.DFS_BFS2;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Tomato {
    static int dy[] = {-1, 1, 0, 0};
    static int dx[] = {0, 0, -1, 1};
    static int Farm[][];
    static int cnt;
    static int n, m;
    static boolean visisted[][];
    static Queue<Node> q = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        Farm = new int[m][n];
        visisted = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Farm[i][j] = sc.nextInt();
                if (Farm[i][j] == 1) {
                    q.offer(new Node(i, j));
                    visisted[i][j] = true;
                } else if (Farm[i][j] == 0)
                    cnt++;

            }
        }
        if (cnt == 0) {
            System.out.println(0);
            return;
        }
        System.out.println(solution());
    }

    public static int solution() {
        int max = -1;
        while (!q.isEmpty()) {
            Node cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int ny = dy[i] + cur.getY();
                int nx = dx[i] + cur.getX();
                if (ny >= 0 && nx >= 0 && ny < m && nx < n && !visisted[ny][nx]) {
                    if (Farm[ny][nx] == 0) {
                        Farm[ny][nx] = Farm[cur.getY()][cur.getX()] + 1;
                        max = Math.max(max, Farm[ny][nx]);
                        cnt--;
                        q.offer(new Node(ny, nx));
                    }
                }
            }
        }
//        for (int i = 0; i < Farm.length; i++) {
//            System.out.println(Arrays.toString(Farm[i]));
//        }
        if (cnt != 0)
            return max = -1;
        else
            return max - 1;
    }

    static class Node {
        private int y, x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public int getX() {
            return x;
        }
    }
}
