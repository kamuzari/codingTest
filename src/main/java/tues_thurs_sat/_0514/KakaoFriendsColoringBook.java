package tues_thurs_sat._0514;

import java.awt.geom.Area;
import java.util.*;

public class KakaoFriendsColoringBook {

    public static void main(String[] args) {
        int p[][] = {
                {1, 1, 1, 0},
                {1, 2, 2, 0},
                {1, 0, 0, 1},
                {0, 0, 0, 1},
                {0, 0, 0, 3},
                {0, 0, 0, 3}
        };

        System.out.println(Arrays.toString(solution(6,4,p)));
    }

    static boolean visited[][];
    static int dy[] = {-1, 1, 0, 0};
    static int dx[] = {0, 0, -1, 1};
    static int map[][], row, col;

    static class Node {
        private int y, x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    public static int[] solution(int m, int n, int[][] picture) {
        row=0;
        col=0;
        map=new int[m][n];
        visited = new boolean[m][n];
        row= m;
        col = n;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j]=picture[i][j];
            }
        }


        int totalAreaSize=0;
        int max=0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (picture[i][j] != 0 && !visited[i][j]) {
                    totalAreaSize++;
                    int key = picture[i][j];
                    int cnt = go(i, j, picture[i][j]);
                    max=Math.max(cnt,max);

                }
            }

        }
        int[] answer = new int[2];
        answer[0]=totalAreaSize;
        answer[1]=max;



        return answer;
    }



    public static int go(int y, int x, int val) {
        Queue<Node> q = new LinkedList<>();
        int cnt = 1;
        q.offer(new Node(y, x));
        visited[y][x] = true;
        while (!q.isEmpty()) {
            Node cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int ny = dy[i] + cur.y;
                int nx = dx[i] + cur.x;

                if (ny >= 0 && nx >= 0 && ny < row && nx < col && !visited[ny][nx] && map[ny][nx] == val) {
                    cnt++;
                    visited[ny][nx] = true;
                    q.offer(new Node(ny, nx));
                }

            }
        }
        return cnt;
    }
}
