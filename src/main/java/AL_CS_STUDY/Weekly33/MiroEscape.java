package AL_CS_STUDY.Weekly33;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class MiroEscape {
    static class Node {
        private int y, x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static Queue<Node> q;
    static int N, M, answer;
    static boolean v[][];
    static char map[][];
    static int dy[]={-1,1,0,0};
    static int dx[]={0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        q = new LinkedList<>();
        answer = 0;
        map=new char[N][M];
        v = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            char[] input = br.readLine().toCharArray();
            map[i] = input.clone();
        }
        vertaxSearch();
        cornerSearch();
        answer = q.size();
        if(answer==0)
        {
            System.out.println(answer);
        }
        else
        {
            bfs();
            System.out.println(answer);
        }
    }

    private static void bfs() {
        for (Node node : q) {
            v[node.y][node.x]=true;
        }
        while (!q.isEmpty())
        {
            Node cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int ny=cur.y+dy[i];
                int nx=cur.x+dx[i];
                if(indexOutOfBound(ny,nx) || v[ny][nx])
                    continue;
                int nny=ny;
                int nnx=nx;
                char newSpot = map[ny][nx];
                switch (newSpot)
                {
                    case 'U':
                        nny+=dy[0];
                        nnx+=dx[0];
                        break;
                    case 'D':
                        nny+=dy[1];
                        nnx+=dx[1];
                        break;
                    case 'L':
                        nny+=dy[2];
                        nnx+=dx[2];
                        break;
                    case 'R':
                        nny+=dy[3];
                        nnx+=dx[3];
                        break;
                }
                if(cur.y==nny && cur.x==nnx)
                {
                    answer++;
                    v[ny][nx]=true;
                    q.offer(new Node(ny,nx));
                }


            }
        }
    }

    private static boolean indexOutOfBound(int ny,int nx) {
        return ny<0 || nx<0 || ny>=N || nx>=M;
    }

    private static void cornerSearch() {
        for (int row = 1; row <N-1 ; row++) {
            if(map[row][0]=='L'){
                q.offer(new Node(row,0));
            }
            if(map[row][M-1]=='R')
            {
                q.offer(new Node(row,M-1));
            }
        }

        for (int col = 1; col < M - 1; col++) {
            if(map[0][col]=='U')
            {
                q.offer(new Node(0,col));
            }
            if(map[N-1][col]=='D')
            {
                q.offer(new Node(N-1,col));
            }
        }
    }

    private static void vertaxSearch() {
        if (map[0][0] == 'L' || map[0][0] == 'U') {
            q.offer(new Node(0, 0));
        }
        if (map[0][M - 1] == 'R' || map[0][M - 1] == 'U') {
            q.offer(new Node(0, M - 1));
        }
        if (map[N - 1][0] == 'L' || map[N - 1][0] == 'D') {
            q.offer(new Node(N - 1, 0));
        }
        if (map[N - 1][M - 1] == 'R' || map[N - 1][M - 1] == 'D') {
            q.offer(new Node(N - 1, M - 1));
        }
    }
}
