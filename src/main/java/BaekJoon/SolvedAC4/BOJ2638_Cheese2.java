package BaekJoon.SolvedAC4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;
import java.util.StringTokenizer;

/*
8 9
0 0 0 0 0 0 0 0 0
0 1 1 0 0 0 1 1 0
0 1 0 1 X 1 0 1 0
0 1 0 0 1 0 0 1 0
0 1 0 1 X 1 0 1 0
0 1 1 0 0 0 1 1 0
0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0

X := 해당 지점이 2초에 같이 지워짐. (버그 제거)
원인 := 노출이 누적됨 map 초기화
     if (ny == 2 && nx == 4) {
         System.out.println("cur : " + cur);
         System.out.println("cur exposure : " + cheeseMap.get(new Node(ny, nx)));
     }
answer : 3
*/
public class BOJ2638_Cheese2 {

    static final int CHEESE = 1;
    static final int MELTED_CHEESE = 0;
    static final int AIR = 0;
    static int n, m, cheese, map[][];
    static int dy[] = {-1, 1, 0, 0};
    static int dx[] = {0, 0, -1, 1};
    // Node{좌표}, 노출 횟수
    private static Map<Node, Integer> cheeseMap;

    static class Node {

        private int y, x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }

        /*
         * 객체 판단 재정의
         */
        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || this.getClass() != o.getClass()) {
                return false;
            }
            Node other = (Node) o;
            return other.y == y && other.x == x;
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.y, this.x);
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
        cheeseMap = new HashMap();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    cheeseMap.put(new Node(i, j), 0);
                }
            }
        }
        int time = 0;
        while (cheeseMap.size() != 0) {
            time++;
            meltingCheese();
            cheeseMap = hashMapInit();
        }
        System.out.println(time);
    }

    private static HashMap<Node, Integer> hashMapInit() {
        HashMap<Node, Integer> newMap = new LinkedHashMap<>();
        for (Node notMeltedCheese : cheeseMap.keySet()) {
            newMap.put(new Node(notMeltedCheese.y, notMeltedCheese.x), 0);
        }
        return newMap;
    }

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
                if (map[ny][nx] == CHEESE) {

                    Node key = new Node(ny, nx);
                    if (cheeseMap.get(key) == 1) {
                        cheeseMap.remove(key);
                        cheese--;
                        map[ny][nx] = MELTED_CHEESE;
                    } else {
                        cheeseMap.put(key, cheeseMap.getOrDefault(key, 0) + 1);
                    }
                } else if (map[ny][nx] == AIR) {
                    if (v[ny][nx]) {
                        continue;
                    } else if (!v[ny][nx]) {
                        q.offer(new Node(ny, nx));
                    }
                }
                v[ny][nx] = true;
            }
        }
    }

    private static boolean outOfIndex(int ny, int nx) {
        return ny < 0 || nx < 0 || ny > n - 1 || nx > m - 1;
    }
}
