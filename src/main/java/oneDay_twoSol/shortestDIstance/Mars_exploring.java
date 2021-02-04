package oneDay_twoSol.shortestDIstance;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
/*
3
3
5 5 4
3 9 1
3 2 7
5
3 7 2 0 1
2 8 0 9 1
1 2 1 8 1
9 8 9 2 0
3 6 5 1 5
7
9 0 5 1 1 5 3
4 1 2 1 6 5 3
0 7 6 1 6 8 5
1 1 7 8 3 2 3
9 4 0 7 6 4 1
5 8 3 2 4 8 3
7 4 8 4 8 3 4

*/
public class Mars_exploring {
    static int n,T,map[][],dist[][];
    static final int INF=(int)1e9;
    static int dy[]={-1,1,0,0};
    static int dx[]={0,0,-1,1};

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        T=sc.nextInt();
        while (T-->0)
        {
            n=sc.nextInt();
            map=new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    map[i][j]=sc.nextInt();
                }
            }

            dist=new int[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(dist[i],INF);
            }
            int y=0; int x=0;
            PriorityQueue<Node> pq=new PriorityQueue<>();
            pq.offer(new Node(y,x,map[y][x]));
            dist[y][x]=map[y][x];
            while (!pq.isEmpty())
            {
                Node node=pq.poll();
                int d=node.dist;
                y=node.y;
                x=node.x;
                if(dist[y][x]<d)
                {
                    continue;
                }
                for (int i = 0; i < 4; i++) {
                    int ty=y+dy[i];
                    int tx=x+dx[i];
                    if(ty>=0 && tx>=0 && ty<n && tx<n)
                    {
                        int cost=d+map[ty][tx];
                        if(cost< dist[ty][tx])
                        {
                            dist[ty][tx]=cost;
                            pq.offer(new Node(ty,tx,cost));
                        }
                    }
                }
            }
            System.out.println(dist[n-1][n-1]);
        }
    }
    static class Node implements Comparable<Node>{
        private int y;
        private int x;
        private int dist;

        public Node(int y, int x, int dist) {
            this.y = y;
            this.x = x;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return this.dist-o.dist;
        }
    }
}
