package thisCodingTest.ShorthestPath.PS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class MarsExploration {
    static int map[][];
    static int dy[]={-1,1,0,0};
    static int dx[]={0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T= Integer.parseInt(br.readLine());
        while (T-->0)
        {
            StringTokenizer st=new StringTokenizer(br.readLine());
            int n=Integer.parseInt(st.nextToken());
            int map[][]=new int[n][n];
            for (int i = 0; i < n; i++) {
                st=new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j]=Integer.parseInt(st.nextToken());
                }
            }
            int dTable[][]=new int[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(dTable[i],(int)1e9);
            }

            PriorityQueue<Position> q=new PriorityQueue<>();
            q.offer(new Position(0,0,map[0][0]));
            dTable[0][0]=map[0][0];
            int min=Integer.MAX_VALUE;
            while (!q.isEmpty())
            {
                Position cur=q.poll();
               if(dTable[cur.y][cur.x]<cur.dist) continue;

                for (int i = 0; i < 4; i++) {
                    int ny=dy[i]+cur.y;
                    int nx=dx[i]+cur.x;

                    if(ny>=0 && nx>=0 && ny<n && nx<n)
                    {
                        int cost=cur.dist+map[ny][nx];
                        if(cost<dTable[ny][nx])
                        {
                            dTable[ny][nx]=cost;
                            q.offer(new Position(ny,nx,cost));
                        }
                    }

                }
            }

            System.out.println(dTable[n-1][n-1]);
        }
    }
    static class Position implements Comparable<Position>{
        private int y,x,dist;

        public Position(int y, int x, int dist) {
            this.y = y;
            this.x = x;
            this.dist = dist;
        }

        @Override
        public int compareTo(Position o) {
            return dist-o.dist;
        }
    }
}
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