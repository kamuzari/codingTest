package oneDay_twoSol.graphTheory.Grouping;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class test {
    static int dy[] = {-1, 1, 0, 0};
    static int dx[] = {0, 0, -1, 1};
    static int n, m, map[][],dist[][];
    static boolean visited[][];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        dist = new int[n][m];
        visited = new boolean[n][m];
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String str[]=sc.nextLine().split("");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(str[j]);
            }
        }
        bfs(0,0);
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(dist[i]));
        }
    }
    static void bfs(int y,int x)
    {
        dist[y][x]=1;
        Queue<Node> q=new LinkedList<>();
        q.offer(new Node(y,x));
        while (!q.isEmpty())
        {
            Node cur=q.poll();
            for (int i = 0; i < 4; i++) {
                int ny=cur.y+dy[i];
                int nx=cur.x+dx[i];
                if(nx>=0 && ny>=0 && nx<m && ny<n)
                {
                    if(map[ny][nx]==1 && dist[ny][nx]==0) {
                        dist[ny][nx]=dist[cur.y][cur.x]+1;
                        q.offer(new Node(ny, nx));
                    }
                }
            }
        }
        System.out.println(dist[n-1][m-1]+1);
    }
    static class Node{
        private int y,x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
