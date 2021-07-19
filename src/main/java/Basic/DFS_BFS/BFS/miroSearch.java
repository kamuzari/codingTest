package Basic.DFS_BFS.BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class miroSearch {
    static int n,m,miro[][];
    static int dy[]={-1,1,0,0};
    static int dx[]={0,0,-1,1};
    static boolean visited[][];
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
         n=sc.nextInt();
         m=sc.nextInt();
        sc.nextLine();
        miro=new int[n][m];
        visited=new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String[] str = sc.nextLine().split("");
            for (int j = 0; j < m; j++) {
                miro[i][j] = Integer.parseInt(str[j]);
            }
        }
        bfs(0,0);
    }
    public static void bfs(int y,int x)
    {
        Queue<Position> q=new LinkedList<>();
        visited[y][x]=true;
        q.add(new Position(y,x,1));
        while (!q.isEmpty())
        {

            Position cur=q.poll();
//            System.out.println(cur.y +"  "+cur.x);
            if(cur.y==n-1 && cur.x==m-1)
            {
                System.out.println(cur.dist);
                break;
            }
            for (int i = 0; i < 4; i++) {
                int ny=dy[i]+cur.y;
                int nx=dx[i]+cur.x;
                if(ny>=n || nx >=m || ny<0 || nx<0 || visited[ny][nx] || miro[ny][nx]!=1)
                    continue;
                visited[ny][nx]=true;
                q.offer(new Position(ny,nx,cur.dist+1));
            }
        }
        for (int i = 0; i < 4; i++) {
            int ny=dy[i]+y;
            int nx=dx[i]+x;
            if(ny>=n || nx >=n || ny<0 || nx<0 || visited[ny][nx] || miro[ny][nx]!=1)
                continue;


        }
    }
    static class Position{
        int y, x, dist;

        public Position(int y, int x, int dist) {
            this.y = y;
            this.x = x;
            this.dist = dist;
        }
    }
}
