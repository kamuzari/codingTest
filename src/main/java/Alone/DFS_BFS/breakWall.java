package Alone.DFS_BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class breakWall {
    static class Node {
        private int y, x,dis,drill;

        public Node(int y, int x, int dis, int drill) {
            this.y = y;
            this.x = x;
            this.dis = dis;
            this.drill = drill;
        }

        public int getY() {
            return y;
        }

        public int getX() {
            return x;
        }
    }

    static int n, m,min;
    static int dy[] = {-1, 1, 0, 0};
    static int dx[] = {0, 0, -1, 1};
    static int map[][], drillCnt[][];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        drillCnt = new int[n][m];
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String str[] = sc.nextLine().split("");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(str[j]);
                if (map[i][j] == 1) {
                    map[i][j] = -1;
                }
                drillCnt[i][j]=Integer.MAX_VALUE;
            }
        }
        min=Integer.MAX_VALUE;

        bfs(0,0);
        if(min==Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(min);
    }

    public static void bfs(int y,int x)
    {
        Queue<Node> q=new LinkedList<>();

        q.add(new Node(y,x,1,0));
        drillCnt[y][x]=0;
        while (!q.isEmpty())
        {
            Node cur=q.poll();

            if(cur.getY()==n-1 && cur.getX()==m-1) // 도달할 수 없으면 min은 MaxInteger value 이다.
            {
                min=cur.dis;
                break;
            }
            for (int i = 0; i < 4; i++) {
                int ny=dy[i]+cur.getY();
                int nx=dx[i]+cur.getX();
                if(ny<0 || nx<0 || ny>=n || nx >=m ) continue;
                if(drillCnt[ny][nx]<=cur.drill)
                    continue;
                if(map[ny][nx]==0)
                {
                    drillCnt[ny][nx]=cur.drill;
                    q.add(new Node(ny,nx,cur.dis+1,cur.drill));
                }
                else
                {
                    // 공사 횟수가 1번까지 가능하므로 1보다 크면 할 수 없다..
                    if(cur.drill==0) {
                        drillCnt[ny][nx] = cur.drill + 1;
                        q.add(new Node(ny, nx, cur.dis + 1, cur.drill + 1));
                    }
                }
            }
        }
    }
}
