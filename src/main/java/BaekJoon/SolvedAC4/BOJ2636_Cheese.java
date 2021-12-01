package BaekJoon.SolvedAC4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ2636_Cheese {

    static final int CHEESE = 1;
    static final int MELTED_CHEESE = 0;
    static final int AIR = 0;
    static int n, m, cheese, map[][];
    static int dy[] = {-1, 1, 0, 0};
    static int dx[] = {0, 0, -1, 1};

    static class Node {

        private int y, x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        getInitialInput(br, st);
    }

    private static void getInitialInput(BufferedReader br, StringTokenizer st) throws IOException {
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    cheese++;
                }
            }
        }
        int time = 0;
        int lastCheese = 0;
        while (cheese != 0) {
            time++;
            lastCheese = cheese;
            meltingCheese();
        }
        System.out.println(time);
        System.out.println(lastCheese);
    }

    /*
     * 치즈가 내부에 있다는 것을 어떻게 판단해야할까? -- 난이도의 중점
     * 치즈가 아닌 곳 부터 시작하여
     */
    private static void meltingCheese() {
        LinkedList<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0));
        boolean v[][] = new boolean[n][m];
        v[0][0] = true;
        while (!q.isEmpty()) {
            Node cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int ny = dy[i] + cur.y;
                int nx = dx[i] + cur.x;
                if (outOfIndex(ny, nx)) {
                    continue;
                }
                if (v[ny][nx]) {
                    continue;
                }
                v[ny][nx] = true;
                if (map[ny][nx] == CHEESE) {
                    cheese--;
                    map[ny][nx]=MELTED_CHEESE;
                } else if (map[ny][nx] == AIR) {
                    q.offer(new Node(ny, nx));
                }
            }
        }
    }

    /*
     * 치즈가 내부에 있다는 것을 어떻게 판단해야할까? -- 난이도의 중점
     */
    private static boolean outOfIndex(int ny, int nx) {
        return ny < 0 || nx < 0 || ny > n - 1 || nx > m - 1;
    }
}
