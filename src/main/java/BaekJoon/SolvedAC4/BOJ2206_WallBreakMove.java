package BaekJoon.SolvedAC4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
/*
=== try ===
1. 11% : flase
@throws 예외 케이스
    8 8
    01000100
    01010100
    01010100
    01010100
    01010100
    01010100
    01010100
    00010100
    output : -1
    correct answer: 29
*/
public class BOJ2206_WallBreakMove {
    static final char WALL = '1';
    static final char EMPTY = '0';
    /*
    @STATUS : document
        0 -> 입력받은 2차원 배열 저장소
        1 -> 벽을 부수지 않는 방문 배열 체크 전용
        2 -> 벽을 부슨 방문 배열 체크 전용
    */
    static final int STATUS = 3;

    static int m;
    static int n;
    static char map[][][];
    static int dy[] = {-1, 1, 0, 0};
    static int dx[] = {0, 0, -1, 1};

    static class Node {
        private int y;
        private int x;
        private int dist;
        boolean isBreakWall;

        public Node(int y, int x, int dist, boolean isBreakWall) {
            this.y = y;
            this.x = x;
            this.dist = dist;
            this.isBreakWall = isBreakWall;
        }

        public boolean isEnd() {
            return this.y == n - 1 && this.x == m - 1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[STATUS][n][m];

        for (int i = 0; i < n; i++) {
            char[] chars = br.readLine().toCharArray();
            map[0][i] = chars.clone();
        }
        int answer = Move();
        System.out.println(answer);
    }

    public static int Move() {
        LinkedList<Node> q = new LinkedList<>();
        boolean v[][] = new boolean[n][m];
        q.offer(new Node(0, 0, 1, false));
        v[0][0] = true;
        while (!q.isEmpty()) {

            Node cur = q.pollFirst();
            if (cur.isEnd()) {
                return cur.dist;
            }
            for (int i = 0; i < 4; i++) {
                int ny = dy[i] + cur.y;
                int nx = dx[i] + cur.x;
                if (indexOutOf(ny, nx)) {
                    continue;
                }
                if(cur.isBreakWall && map[2][ny][nx]==0){ // 벽을 이미 부슨 노드이면서 방문하지 않을 떄.
                    if(map[0][ny][nx]!=WALL){
                        q.offer(new Node(ny,nx, cur.dist+1,cur.isBreakWall));
                        map[2][ny][nx]=1;// 방문
                    }else{
                        continue;
                    }
                }else if(!cur.isBreakWall&&map[1][ny][nx]==0){
                    if(map[0][ny][nx]==WALL){
                        q.offer(new Node(ny,nx,cur.dist+1,true)); // STATUS 변경
                    }else if(map[0][ny][nx]==EMPTY){
                        q.offer(new Node(ny,nx,cur.dist+1,cur.isBreakWall));
                        map[1][ny][nx]=1; // 방문
                    }
                }

            }
        }
        return -1;
    }

    public static boolean indexOutOf(int ny, int nx) {
        return ny < 0 || nx < 0 || ny > n - 1 || nx > m - 1;
    }
}
