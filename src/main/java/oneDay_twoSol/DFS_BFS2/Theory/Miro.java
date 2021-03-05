package oneDay_twoSol.DFS_BFS2.Theory;

import java.util.LinkedList;
import java.util.Queue;

public class Miro {
    static int dy[] = {-1, 1, 0, 0};
    static int dx[] = {0, 0, -1, 1};
    static boolean visited[][];
    static class Position{
        private int y, x,dist;

        public Position(int y, int x, int dist) {
            this.y = y;
            this.x = x;
            this.dist = dist;
        }
    }
    static int miro[][];
    static int n,m;
    public static void main(String[] args) {
        miro = new int[][]{
                {1, 0, 1, 0, 1, 0},
                {1, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1},
        };
            n=miro.length;
            m=miro[0].length;
        visited=new boolean[n][m];

        System.out.println(BFS(0,0));
    }
    static int BFS(int y,int x)
    {
        Queue<Position> q=new LinkedList<>();
        q.add(new Position(y,x,1));
        visited[y][x]=true;
        while (!q.isEmpty())
        {
            Position cur=q.poll();
            if(cur.y==n-1 && cur.x==m-1)
            {
                return cur.dist;
            }
            for (int i = 0; i < 4; i++) {
                int ny = dy[i] + cur.y;
                int nx = dx[i] + cur.x;
                if (ny >= 0 && nx >= 0 && ny<n && nx< m && !visited[ny][nx]) {
                    if(miro[ny][nx]==1)
                    {
                        visited[ny][nx]=true;
                        q.offer(new Position(ny,nx,cur.dist+1));
                    }
                }
            }
        }
        // 끝점에 도달할 수 없는 경우.
        return -1;
    }
}
