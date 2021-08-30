package AL_CS_STUDY.RealTimeSolving.Weekly_10to20.weekly13;

import java.util.*;

public class shorthestPath {
    static int n,map[][];
    static boolean visited[][];
    static int dy[]={-1,1,0,0};
    static int dx[]={0,0,-1,1};
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        StringBuilder sb=new StringBuilder();

        for (int i = 0; i < t; i++) {
            n=sc.nextInt();
            map=new int[n][n];
            sc.nextLine();
            for (int j = 0; j < n; j++) {
                String str[]=sc.nextLine().split("");
                for (int k = 0; k < str.length; k++) {
                    map[j][k] = Integer.parseInt(str[k]);
                }
            }

            sb.append(i+1+" "+bfs(0,0)+"\n");
            min=(int)1e9;
        }
        System.out.println(sb);


    }
    static int min=(int)1e9;
    static int bfs(int y,int x)
    {
        Queue<Position> q=new LinkedList<>();
        visited=new boolean[n][n];
        int ans[][]=new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(ans[i],(int)1e9);
        }
        visited[y][x]=true;
        ans[y][x]=0;
        q.offer(new Position(y,x,map[y][x]));
        while (!q.isEmpty())
        {
            Position cur=q.poll();
            for (int i = 0; i < 4; i++) {
                int ny=dy[i]+cur.y;
                int nx=dx[i]+cur.x;
                // 방문을 했어도 더 공사를 안한 좌표가 있다면 교체.
                if(ny>=0 && nx>=0 && ny<n && nx<n && (!visited[ny][nx]||ans[ny][nx]>ans[cur.y][cur.x]+map[ny][nx]))
                {
                    visited[ny][nx]=true;
                    ans[ny][nx]=ans[cur.y][cur.x]+map[ny][nx];
                    q.offer(new Position(ny,nx, cur.dist+map[ny][nx]));
                }
            }
        }
//        for (int i = 0; i < n; i++) {
//            System.out.println(Arrays.toString(ans[i]));
//        }
        return ans[n-1][n-1];

    }
    static class Position implements Comparable<Position>{
        int y;
        int x;
        int dist;

        @Override
        public String toString() {
            return "Position{" +
                    "y=" + y +
                    ", x=" + x +
                    ", dist=" + dist +
                    '}';
        }

        public Position(int y, int x, int dist) {
            this.y = y;
            this.x = x;
            this.dist=dist;
        }

        @Override
        public int compareTo(Position o) {
            return this.dist-o.dist;
        }
    }
}
