package AL_CS_STUDY.Weekly_30to40.Weekly37;

import java.util.LinkedList;

public class BlockMove {
    public static void main(String[] args) {
        BlockMove blockMove = new BlockMove();
        int[][] b={
                {0, 0, 0, 1, 1},{0, 0, 0, 1, 0},{0, 1, 0, 1, 1},{1, 1, 0, 0, 1},{0, 0, 0, 0, 0}
        };
        int solution = blockMove.solution(b);
        System.out.println(solution);
    }

    static final int UP = 0, RIGHT = 1, DOWN = 2, LEFT = 3;

    int dy[] = {-1, 1, 0, 0};
    int dx[] = {0, 0, -1, 1};
    int map[][];
    int n;
    boolean v[][][];
    LinkedList<Node[]> q = new LinkedList<>();

    class Node {
        private int y, x, dir, time;

        public Node(int y, int x, int dir, int time) {
            this.y = y;
            this.x = x;
            this.dir = dir;
            this.time = time;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "y=" + y +
                    ", x=" + x +
                    ", dir=" + dir +
                    ", time=" + time +
                    '}';
        }
    }

    public int solution(int[][] board) {
        n = board.length;
        map = new int[n][n];
        v = new boolean[n][n][4];
        for (int i = 0; i < board.length; i++) {
            map = board.clone();
        }
        q.add(new Node[]{new Node(0, 0, RIGHT, 0), new Node(0, 1, LEFT, 0)});
        v[0][0][RIGHT] = true;
        v[0][0][LEFT] = true;

        Node[] cur = new Node[2];
        Node[] next = new Node[2];
        while (!q.isEmpty()) {
            Node[] now = q.poll();
            for (int j = 0; j < 4; j++) {
                for (int i = 0; i < 2; i++) {
                    int ny = now[i].y + dy[j];
                    int nx = now[i].x + dx[j];
                    next[i] = new Node(ny, nx, now[i].dir, now[i].time + 1);
                }

                if (!isValid(next)) {
                    continue;
                }

                for (int i = 0; i < 2; i++) {
                    if (next[i].y == n - 1 && next[i].x == n - 1) {
                        return next[i].time;
                    }
                    v[next[i].y][next[i].x][next[i].dir] = true;
                }
                q.add(new Node[]{next[0], next[1]});
            }
            // 회전 1. 시계 , 2. 반시계

            for (int ccw = 0; ccw < 2; ccw++) { //clockwise counterclockwise : 시계 방향 반시계 방향.
                for (int i = 0; i < 2; i++) { // 회전 축
                    int rotate = rotate(now, ccw, i);
                    if(rotate!=0)
                    {
                        return rotate;
                    }

                }
            }
        }

        return 0;
    }

    static int D[][][] = {{{1, 1}, {1, -1}, {-1, -1}, {-1, 1}},
            {{1, -1}, {-1, -1}, {-1, 1}, {1, 1}}};

    static int Dcorner[][][] = {{{-1, 1}, {1, 1}, {1, -1}, {-1, -1}},
            {{-1, -1}, {-1, 1}, {1, 1}, {1, -1}}};

    private int rotate(Node[] cur, int ccw, int rotatePrincipal) { // rotatePrincipal : 회전축
        Node[] next = new Node[2];
        int primaryIdx = rotatePrincipal, b = (rotatePrincipal + 1) % 2;
        Node current = cur[primaryIdx];
        Node subCur = cur[b];
        next[0] = new Node(current.y, current.x, (current.dir +( ccw == 0 ? 1 : 3)) % 4,
                current.time + 1);
        next[1] = new Node(subCur.y + D[ccw][current.dir][0], subCur.x + D[ccw][current.dir][1],
                (subCur.dir + (ccw == 0 ? 1 : 3)) % 4, subCur.time + 1);
        if (!isValid(next))
            return 0;
        if(map[current.y+Dcorner[ccw][current.dir][0]][current.x+Dcorner[ccw][current.dir][1]]==1)
            return 0;

        for (int i = 0; i < 2; i++) {
            if(next[i].y==n-1 && next[i].x==n-1)
                return next[i].time;
            v[next[i].y][next[i].x][next[i].dir]=true;
        }
        q.add(new Node[]{next[0],next[1]});
        return 0;

    }

    private boolean isValid(Node[] next) {
        for (int i = 0; i < next.length; i++) {
            Node cur = next[i];
            if (cur.y < 0 || cur.x < 0 || cur.y > n - 1 || cur.x > n - 1)
                return false;
            if (map[cur.y][cur.x] == 1)
                return false;
            if (v[cur.y][cur.x][cur.dir])
                return false;
        }
        return true;
    }

}
