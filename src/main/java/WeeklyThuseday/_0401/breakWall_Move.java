package WeeklyThuseday._0401;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class breakWall_Move {
    static int n,m,map[][];
    static int dy[] = {-1, 1, 0, 0};
    static int dx[] = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        map=new int[n][m];
        visited=new int[n][m];
        for (int i = 0; i < n; i++) {
            String str[]=br.readLine().split("");
            for (int j = 0; j < m; j++) {
                map[i][j]=Integer.parseInt(str[j]);
                visited[i][j]=Integer.MAX_VALUE;
            }
        }
       int ans= bfs(0,0);
        System.out.println(ans);

    }
    static int ans=Integer.MAX_VALUE;
    static int visited[][];
    public static int bfs(int y,int x)
    {
        Queue<Node> q=new LinkedList<>();
        q.add(new Node(y,x,1,0));
        visited[y][x]=0;
        while (!q.isEmpty())
        {
            Node cur = q.poll();
            if(cur.y==n-1 && cur.x==m-1)
            {
             return cur.dist;
            }

            for (int i = 0; i < 4; i++) {
                int ny=dy[i]+cur.y;
                int nx=dx[i]+cur.x;
                if(ny>=0 && nx>=0 && ny<n && nx<m)
                {
                    // bfs 라 어차피 늦게오면 더 빠른 거리가 아님과 동시에 공사 횟수가 적은 것만 통과.
                    //
                    if(visited[ny][nx]<=cur.wallBreak_cnt)
                        continue;
//                    if(visited[ny][nx]>cur.wallBreak_cnt)
                    if(map[ny][nx]!=1)
                    {
                        q.offer(new Node(ny,nx, cur.dist+1, cur.wallBreak_cnt));
                        visited[ny][nx]=cur.wallBreak_cnt; // 방문과 공사 횟수를 중의적으로 표현.
                    }
                    else if(cur.wallBreak_cnt==0&&map[ny][nx]==1)
                    {
                        q.offer(new Node(ny,nx, cur.dist+1, cur.wallBreak_cnt+1 ));
                        visited[ny][nx]=cur.wallBreak_cnt+1;
                    }

                }
            }
        }
        return -1;
    }
    static class Node{
        private int y, x,dist,wallBreak_cnt;

        public Node(int y, int x,int dist,int wallBreak_cnt) {
            this.y = y;
            this.x = x;
            this.dist=dist;
            this.wallBreak_cnt=wallBreak_cnt;
        }
    }
}
