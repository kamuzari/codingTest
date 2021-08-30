package AL_CS_STUDY.Weekly_30to40.Weekly31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
//https://www.acmicpc.net/problem/17135
public class CastleDefence {

    private static int n;
    private static int m;
    private static int d;
    private static int map[][];
    private static int archerX[] = new int[3];
    private static int maxEnemyCnt = 0;

    private static class Node {
        private int y;
        private int x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        ArcherPosition(0, 0);
        System.out.println(maxEnemyCnt);
    }


    static void ArcherPosition(int cnt, int idx) {
        if (cnt == 3) {
            gameInit();
            return;
        }
        for (int i = idx; i < m; i++) {
            archerX[cnt] = i;
            ArcherPosition(cnt + 1, i + 1);
        }
    }

    private static void gameInit() {

        // 1. 궁수 공격
        // 2. 적의 이동
        // 3 적이 아무도 없을 떄 종료.
        int copyMap[][] = copyArray();
        boolean isDead[][];

        int totalRemoveCnt = 0;

        for (int turn = 0; turn < n; turn++) {
            isDead = new boolean[n][m];
            for (int i = 0; i < 3; i++) {
                if (copyMap[n - 1][archerX[i]] == 1) {
                    isDead[n - 1][archerX[i]] = true;
                } else {
                    mindDistSearch(n, archerX[i], isDead, copyMap);
                }
            }

            totalRemoveCnt += removeEnemies(copyMap, isDead);
            moveEnemies(copyMap);

        }
        maxEnemyCnt = Math.max(maxEnemyCnt, totalRemoveCnt);
    }

    private static void moveEnemies(int[][] copyMap) {
        for (int i = n - 1; i > 0; i--) {
            for (int j = 0; j < m; j++) {
                copyMap[i][j] = copyMap[i - 1][j];
            }
        }
        Arrays.fill(copyMap[0],0);
    }

    private static int removeEnemies(int[][] copyMap, boolean[][] isDead) {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (isDead[i][j]) {
                    cnt++;
                    copyMap[i][j] = 0;
                }
            }
        }
        return cnt;

    }

    static int dy[] = {0, -1, 0};
    static int dx[] = {-1, 0, 1};

    private static void mindDistSearch(int y, int x, boolean[][] isDead, int[][] copyMap) {
        Queue<Node> q = new LinkedList<>();
        boolean v[][] = new boolean[n][m];
        q.offer(new Node(y - 1, x));
        v[y - 1][x] = true;
        while (!q.isEmpty()) {
            Node cur = q.poll();
            for (int i = 0; i < 3; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];
                if (ny < 0 || nx < 0 || ny >= n || nx >= m || v[ny][nx])
                    continue;
                int dist = Math.abs(y - ny) + Math.abs(x - nx);
                if (copyMap[ny][nx] == 1) {
                    if (dist > d)
                        continue;
                    isDead[ny][nx] = true;
                    return;
                }
                v[ny][nx] = true;
                q.offer(new Node(ny, nx));

            }
        }
    }


    private static int[][] copyArray() {
        int temp[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            temp[i] = map[i].clone();
        }
        return temp;
    }

}
