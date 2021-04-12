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
            for (int i = 0; i < n; i++) {
                System.out.println(Arrays.toString(dTable[i]));
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

/*
[5, 10, 14]
[8, 17, 15]
[11, 13, 20]
20

[3, 10, 11, 11, 12]
[5, 13, 9, 18, 13]
[6, 8, 9, 17, 14]
[15, 16, 18, 16, 14]
[18, 22, 22, 17, 19]
19

[9, 9, 14, 14, 15, 20, 23]
[13, 10, 12, 13, 19, 24, 26]
[13, 17, 18, 14, 20, 28, 31]
[14, 15, 22, 22, 23, 25, 28]
[23, 19, 19, 26, 29, 29, 29]
[28, 27, 22, 24, 28, 36, 32]
[35, 31, 30, 28, 36, 39, 36]
36
*/