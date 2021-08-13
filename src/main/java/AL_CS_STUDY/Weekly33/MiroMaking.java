package AL_CS_STUDY.Weekly33;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MiroMaking {
    static class Node {
        private int y;
        private int x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }

    }

    static int INF = (int) 1e9;
    static int dy[] = {-1, 1, 0, 0};
    static int dx[] = {0, 0, -1, 1};
    static char map[][];
    static int dist[][];
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map=new char[n][n];
        for (int i = 0; i <n ; i++) {
            map[i]=br.readLine().toCharArray();
        }
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i],INF);
        }
        dist=new int[n][n];
        dist[0][0]=0;
        bfs(0,0);
    }

    private static void bfs(int y, int x) {
        Queue<Node> q=new LinkedList<>();
        q.offer(new Node(y,x));

        while (!q.isEmpty())
        {
            Node cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int ny=dy[i]+cur.y;
                int nx=dx[i]+cur.x;

                if(isInnerIndex(ny,nx))
                {
                    //0 이 검은방 고체 ? 가능 : 불가능
                    if(map[ny][nx]=='0' && dist[ny][nx]>dist[cur.y][cur.x]+1)
                    {
                        dist[ny][nx]=dist[cur.y][cur.x]+1;
                        q.offer(new Node(ny,nx));
                    }
                    // 1이 흰방
                    else if(map[ny][nx]=='1' && dist[ny][nx]>dist[cur.y][cur.x])
                    {
                        dist[ny][nx]=dist[cur.y][cur.x];
                        q.offer(new Node(ny,nx));
                    }
                }
            }
        }

    }

    private static boolean isInnerIndex(int ny, int nx) {
        return ny>=0 && nx>=0 && ny<n && nx<n;
    }
}
