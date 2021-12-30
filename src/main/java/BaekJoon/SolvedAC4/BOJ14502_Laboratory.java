package BaekJoon.SolvedAC4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class BOJ14502_Laboratory {
    static final int EMPTY = 0;
    static final int WALL = 1;
    static final int VIRUS = 2;
    static int answer=0;
    static int dy[] = {-1, 1, 0, 0};
    static int dx[] = {0, 0, -1, 1};
    static int map[][];
    static int n, m;
    static List<Node> emptys;
    static List<Node> virus;
    static Set<Node> pickEmptys;

    static class Node {
        private int y, x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }

        @Override
        public boolean equals(Object comp) {
            if (this == comp) return true;
            if (comp == null || this.getClass() != comp.getClass()) return false;
            Node node = (Node) comp;
            return this.y == node.x && this.x == node.x;
        }

        @Override
        public int hashCode() {
            return Objects.hash(y, x);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        initDataStructure();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) {
                    emptys.add(new Node(i, j));
                } else if (map[i][j] == 2) {
                    virus.add(new Node(i, j));
                }
            }
        }
        setUpWallCombination(0,0);
        System.out.println(answer);
    }

    private static void initDataStructure() {
        map = new int[n][m];
        emptys = new LinkedList<>();
        pickEmptys = new HashSet<>();
        virus=new LinkedList<>();
    }

    private static void setUpWallCombination(int cnt, int idx) {
        if (cnt == 3) {
            // 벽 세우기
            buildWall();
            // 전염시키기
            int[][] infectionMap = infectMap();
            // 안전영역 세기
            int count = countSecureArea(infectionMap);
            // 벽 제거하기
            answer=Math.max(count,answer);
            removeWall();
            return;
        }
        for (int i = idx; i < emptys.size(); i++) {
            Node curEmpty = emptys.get(i);
            if (!pickEmptys.contains(curEmpty)) {
                pickEmptys.add(curEmpty);
                setUpWallCombination(cnt + 1, idx + 1);
                pickEmptys.remove(curEmpty);
            }
        }
    }

    private static int countSecureArea(int[][] infectMap) {
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (infectMap[i][j] == EMPTY) answer++;
            }
        }
        return answer;
    }

    private static int[][] infectMap() {
        LinkedList<Node> q = new LinkedList<>();
        int copyMap[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            copyMap[i] = map[i].clone();
        }
        for (Node virus : virus) {
            q.offer(new Node(virus.y, virus.x));
        }
        while (!q.isEmpty()) {
            Node cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int ny = dy[i] + cur.y;
                int nx = dx[i] + cur.x;
                if (outOfIndex(ny, nx)) continue;
                if (copyMap[ny][nx] != EMPTY) continue;
                copyMap[ny][nx] = 2;
                q.offer(new Node(ny, nx));
            }
        }
        return copyMap;
    }

    private static boolean outOfIndex(int ny, int nx) {
        return ny < 0 || nx < 0 || ny > n - 1 || nx > m - 1;
    }

    private static void buildWall() {
        for (Node cur : pickEmptys) {
            map[cur.y][cur.x] = WALL;
        }
    }

    private static void removeWall() {
        for (Node cur : pickEmptys) {
            map[cur.y][cur.x] = EMPTY;
        }
    }
}
