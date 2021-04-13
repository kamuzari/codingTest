package Thur_Sunday_aWeek_Al._0413;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class WallBreaking3 {
    static class Node{
        private int y,x,breakCnt,dist,day;

        public Node(int y, int x, int dist,int day,int breakCnt) {
            this.y = y;
            this.x = x;
            this.breakCnt = breakCnt;
            this.day=day;
            this.dist=dist;
        }
    }
    static int n,m,limitCnt;
    static int map[][];
    static boolean visited[][][][];
    static int dy[] = {-1, 1, 0, 0};
    static int dx[] = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=parser(st.nextToken());
        m=parser(st.nextToken());
        limitCnt=parser(st.nextToken());
        map=new int[n][m];
        visited=new boolean[n][m][2][limitCnt+1];
        for (int i = 0; i <n ; i++) {
            String str[]=br.readLine().split("");
            for (int j = 0; j < m; j++) {
                map[i][j]=parser(str[j]);
            }
        }
        bfs(0,0);
    }
    static void bfs(int y,int x)
    {
        Queue<Node> q=new LinkedList<>();
        q.add(new Node(y,x,1,0,0)); // 낮 day==0;
        while (!q.isEmpty())
        {
           Node cur=q.poll();
            if(cur.y==n-1 && cur.x==m-1)
            {
                System.out.println(cur.dist);
                return;
            }
            for (int i = 0; i < 4; i++) {
                int ny=cur.y+dy[i];
                int nx=cur.x+dx[i];
                if(ny>=0 && nx>=0 && ny<n && nx<m)
                {
                    // 벽이 아니고 방문한 흔적이 없다면
                    if(map[ny][nx]!=1 && !visited[ny][nx][cur.day][cur.breakCnt])
                    {
                        int day=0;
                        if(cur.day==0)
                        {
                            day=1;
                        }

                        q.offer(new Node(ny,nx, cur.dist+1,day,cur.breakCnt ));
                        visited[ny][nx][cur.day][cur.breakCnt]=true;
                    }// 벽일떄 그리고 현재 제한된 횟수의 공사이고 방문한 흔적이 없다면.
                    else if(map[ny][nx]==1 && cur.day==0 &&cur.breakCnt<limitCnt && !visited[ny][nx][cur.day][cur.breakCnt])
                    {
                        q.offer(new Node(ny,nx, cur.dist+1,1,cur.breakCnt+1 ));
                        visited[ny][nx][cur.day][cur.breakCnt]=true;
                    }
                    else if(map[ny][nx]==1 && cur.day==1 &&cur.breakCnt<limitCnt && !visited[ny][nx][cur.day][cur.breakCnt] )
                    {
                        q.offer(new Node(cur.y,cur.x, cur.dist+1,0,cur.breakCnt ));
                    }
                }
            }
        }
        System.out.println(-1);
    }
    static int parser(String str)
    {
        return Integer.parseInt(str);
    }
}
