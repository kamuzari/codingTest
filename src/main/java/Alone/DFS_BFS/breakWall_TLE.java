package Alone.DFS_BFS;

import java.util.*;

//https://www.acmicpc.net/problem/2206
public class breakWall_TLE {
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

    static int n, m;
    static int dy[] = {-1, 1, 0, 0};
    static int dx[] = {0, 0, -1, 1};
    static int map[][];
    static ArrayList<Node> wall = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String str[] = sc.nextLine().split("");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(str[j]);
                if (map[i][j] == 1) {
                    map[i][j] = -1;
                    wall.add(new Node(i, j));
                }
            }
        }

        for (int i = 0; i < wall.size(); i++) {
            Node cur = wall.get(i);
            map[cur.getY()][cur.getX()] = 0;
            int temp[][] = copy();
            bfs(temp);
            map[cur.getY()][cur.getX()] = -1;
        }
        if (min == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(min+1);
    }

    static int min = Integer.MAX_VALUE;

    static int[][] copy() {

        int temp[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                temp[i][j] = map[i][j];
            }
        }
        return temp;
    }

    public static void bfs(int map[][]) {
        boolean visited[][] = new boolean[n][m];
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0));
        visited[0][0] = true;
        int max = 0;
        while (!q.isEmpty()) {
            Node cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int ny = dy[i] + cur.getY();
                int nx = dx[i] + cur.getX();
                if (ny >= 0 && nx >= 0 && ny < n && nx < m && !visited[ny][nx] && map[ny][nx] != -1) {
                    visited[ny][nx] = true;
                    map[ny][nx] = map[cur.getY()][cur.getX()] + 1;
                    max = Math.max(max, map[ny][nx]);
                    q.offer(new Node(ny, nx));
                }
            }
        }
//        System.out.println("max ->"+max);
//        for (int i = 0; i < n; i++) {
//            System.out.println(Arrays.toString(map[i]));
//        }
//        System.out.println();

        if (map[n - 1][m - 1] == 0 || map[n - 1][m - 1] == -1) {
            max = Integer.MAX_VALUE;
        }
        min=Math.min(max,min);
    }
}

/*
 (x, y, 벽을 허물었는지의 여부)
*/