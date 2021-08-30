package AL_CS_STUDY.RealTimeSolving.Weekly_10to20.Weekly17;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Miro1 {
    static int n = 16;
    static int map[][];
    static int dy[] = {-1, 1, 0, 0};
    static int dx[] = {0, 0, -1, 1};

    static class Node {
        private int y, x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "y=" + y +
                    ", x=" + x +
                    '}';
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T = 10;

        StringBuilder sb=new StringBuilder();
        Node start = null;
        Node end = null;
        for (int test_case = 1; test_case <= T; test_case++) {
            sc.nextInt();
            sc.nextLine();
            map = new int[16][16];
            for (int i = 0; i < 16; i++) {
                String str[] = sc.nextLine().split("");
                for (int j = 0; j < 16; j++) {
                    map[i][j] = Integer.parseInt(str[j]);
                    if (map[i][j] == 2)
                        start = new Node(i, j);
                    else if (map[i][j] == 3)
                        end = new Node(i, j);
                }
            }

            int ans = bfs(start, end);
//            System.out.println("ans : "+ans);
            sb.append("#" + test_case).append(" ").append(ans).append("\n");
        }
        System.out.println(sb);
    }

    static int bfs(Node start,Node end) {
        boolean visited[][]=new boolean[16][16];
        Queue<Node> q = new LinkedList<>();
        q.offer(start);
        visited[start.y][start.x]=true;
        while (!q.isEmpty())
        {
            Node cur=q.poll();
            if(cur.y==end.y && cur.x==end.x)
            {
                return 1;
            }
            for (int i = 0; i < 4; i++) {
                int ny=dy[i]+cur.y;
                int nx=dx[i]+cur.x;
                if(ny>=0 && nx >=0 && ny<16 && nx <16 && (map[ny][nx]==0 || map[ny][nx]==3) && !visited[ny][nx])
                {
                    visited[ny][nx]=true;
                    q.offer(new Node(ny,nx));
                }
            }
        }
        return 0;
    }
}

class Solution
{
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;

        for(int test_case = 1; test_case <= T; test_case++)
        {
            br.readLine();
            int[][] map = new int[16][16];
            int startX = 0;
            int startY = 0;

            for(int i=0; i<16; i++) {
                String input = br.readLine();

                for(int j=0; j<16; j++) {
                    map[i][j] = input.charAt(j) - '0';

                    if(map[i][j]==2) {
                        startX = i;
                        startY = j;
                    }
                }
            }

            int ans = bfs(map, startX, startY);

            System.out.println("#"+test_case+" "+ans);
        }
    }

    public static int bfs(int[][] map, int x, int y) {
        Queue<Pair> queue = new LinkedList<>();
        boolean[][] visited = new boolean[16][16];
        visited[x][y] = true;
        queue.add(new Pair(x, y));

        while(!queue.isEmpty()) {
            Pair temp = queue.poll();

            for(int i=0; i<4; i++) {
                int nx = temp.x+dx[i];
                int ny = temp.y+dy[i];

                if(nx<0 || nx>=16 || ny<0 || ny>=16 || visited[nx][ny]) continue;

                if(map[nx][ny]==0) {
                    visited[nx][ny] = true;
                    queue.add(new Pair(nx, ny));
                }

                else if(map[nx][ny]==3)
                    return 1;
            }
        }

        return 0;
    }

    public static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
