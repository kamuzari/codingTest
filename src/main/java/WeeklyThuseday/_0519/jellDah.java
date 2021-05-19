package WeeklyThuseday._0519;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class jellDah {
    static int dy[] = {-1, 1, 0, 0};
    static int dx[] = {0, 0, -1, 1};
    static StringBuilder sb=new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc=1;
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if(n==0)
                break;
            int map[][] = new int[n][n];
            for (int i = 0; i < n; i++) {
                String str[] = br.readLine().split(" ");
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(str[j]);
                }
            }
           sb.append("Problem "+tc+++": "+bfs(map,n)).append("\n");
        }
        System.out.println(sb);
    }
    static class Node{
        int y,x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    static int bfs(int map[][],int n)
    {
        int stealing[][]=new int[n][n];
        Queue<Node> q=new LinkedList<>();
        q.offer(new Node(0,0));
        for (int i = 0; i < n; i++) {
            Arrays.fill(stealing[i],(int)1e9);
        }
        stealing[0][0]=map[0][0];
        while (!q.isEmpty())
        {
            Node cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int ny=dy[i]+cur.y;
                int nx=dx[i]+cur.x;
                if(ny>=0 && nx>=0 && ny<n && nx<n)
                {
                   /* if(stealing[ny][nx]==0)
                    {
                        stealing[ny][nx]=map[ny][nx]+stealing[cur.y][cur.x];
                        q.offer(new Node(ny,nx));
                    }*/
                    if(stealing[ny][nx]>stealing[cur.y][cur.x]+map[ny][nx])
                    {
                        stealing[ny][nx]=stealing[cur.y][cur.x]+map[ny][nx];
                        q.offer(new Node(ny,nx));
                    }
                }
            }
        }

        /*for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(stealing[i]));
        }
        System.out.println();*/
        return stealing[n-1][n-1];

    }
}
