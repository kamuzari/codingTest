package AL_CS_STUDY.RealTimeSolving.Weekly_30to40.Weekly31;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class MiroSearch {
    static final int TESTCASE = 10;
    static final int N = 16;
    static final int startDot = 1;
    static final int finishDot = 13;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < TESTCASE; t++) {
            br.readLine();
            char map[][] = new char[N][N];
            for (int i = 0; i < N; i++) {
                map[i] = br.readLine().toCharArray();
            }

            sb.append("#").append(t + 1).append(" ").append(BFS(map) ? 1 : 0).append("\n");
        }
        System.out.println(sb);

    }

    static class Node {
        int y, x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }

        public boolean isFinish(int finish) {
            return this.y == finish && this.x == finish;
        }
    }

    private static boolean BFS(char[][] map) {
        Queue<Node> q = new LinkedList<>();
        boolean[][] v = new boolean[N][N];
        q.offer(new Node(startDot, startDot));
        v[startDot][startDot] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();
            if (cur.isFinish(finishDot)) {
                return true;
            }

            for (int i = 0; i < 4; i++) {
                int ny = dy[i] + cur.y;
                int nx = dx[i] + cur.x;
                if (outOfIdx(ny, nx) || v[ny][nx])
                    continue;
                if (map[ny][nx] == '1') {
                    continue;
                }
                v[ny][nx] = true;
                q.offer(new Node(ny, nx));
            }
        }

        return false;

    }

    static boolean outOfIdx(int y, int x) {
        return y < 0 || x < 0 || y >= N || x >= N;
    }
}
