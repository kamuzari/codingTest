package oneDay_twoSol.shortestDIstance.groupSolving;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class makingMiro {
    static class Node{
        private int y;
        private int x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }

    }
    static int INF=(int)1e9;
    static int dy[] = {-1, 1, 0, 0};
    static int dx[] = {0, 0, -1, 1};
    static int map[][];
    static int dist[][];
    static int n;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        // bfs 문제와 유사?
        map=new int[n][n];
        sc.nextLine();
        for (int i = 0; i <n ; i++) {
            String str[]=sc.nextLine().split("");
            for (int j = 0; j < n; j++) {
                map[i][j]=Integer.parseInt(str[j]);
            }
        }
        dist=new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i],INF);
        }
        dist[0][0]=0;
        bfs(0,0);
        System.out.println(dist[n-1][n-1]);
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(dist[i]));
        }

    }
    static void bfs(int y,int x)
    {
        Queue<Node> q=new LinkedList<>();
        q.offer(new Node(y,x));
        while (!q.isEmpty())
        {
            Node cur=q.poll();
            int cur_y= cur.y;;
            int cur_x=cur.x;
            for (int i = 0; i < 4; i++) {
                int ty=dy[i]+cur_y;
                int tx=dx[i]+cur_x;
                if(ty>=0 && tx>=0 && ty<n && tx<n)
                {
                    if(map[ty][tx]==0 &&dist[ty][tx]>dist[cur_y][cur_x]+1) // 검은 방이면 +` 하면서 갱신
                    {
                        dist[ty][tx]=dist[cur_y][cur_x]+1;
                        q.offer(new Node(ty,tx));
                    }

                    else if(map[ty][tx]==1 &&dist[ty][tx]>dist[cur_y][cur_x]) // 검은방아니면 그대로 값물려주기
                    {
                            dist[ty][tx]=dist[cur_y][cur_x];
                            q.offer(new Node(ty,tx));
                    }
                }
            }

        }

    }
}
/*
best
[0, 0, 0, 1, 2, 2, 2, 3]
[0, 0, 1, 1, 2, 3, 2, 3]
[0, 1, 1, 1, 1, 2, 2, 3]
[0, 0, 0, 1, 1, 1, 2, 2]
[1, 0, 1, 2, 2, 1, 1, 1]
[2, 1, 1, 1, 2, 2, 2, 1]
[1, 1, 2, 1, 1, 2, 3, 2]
[1, 1, 2, 2, 2, 2, 2, 2]
*/