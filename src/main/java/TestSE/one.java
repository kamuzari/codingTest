package TestSE;

import java.util.*;

/*
2
5 6
0 0 1 0 2 0
1 0 1 0 0 0
0 0 1 1 1 0
0 3 0 1 0 0
4 0 0 0 0 0
5 6
0 0 1 0 2 0
1 0 1 0 0 0
0 0 1 1 1 0
0 3 0 1 0 0
4 0 0 1 0 0
*/
public class one {
    static int n, m;
    static int dy[] = {-1, 1, 0, 0};
    static int dx[] = {0, 0, -1, 1};
    static int arr[][];
    static ArrayList<position> sw = new ArrayList<>();
    static ArrayList<position> key = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        StringBuilder sb=new StringBuilder();
        while (T-- > 0) {
            n = sc.nextInt();
            m = sc.nextInt();
            boolean visited[][] = new boolean[n][m];
            arr = new int[n][m];
            Queue<position> q = new LinkedList<>();

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = sc.nextInt();
                    if (arr[i][j] == 3) {
                        q.offer(new position(i, j));
                        visited[i][j] = true;
                    }
                }
            }

            while (!q.isEmpty()) {
                position cur = q.poll();
                if (arr[cur.y][cur.x] == 4) {
                    arr[cur.y][cur.x]=0;
                    key.add(new position(cur.y, cur.x));
                    break;
                }
                for (int i = 0; i < 4; i++) {

                    int ny = dy[i] + cur.y;
                    int nx = dx[i] + cur.x;
                    if (ny >= 0 && nx >= 0 && ny < n && nx < m && !visited[ny][nx]) {
                        visited[ny][nx] = true;
                        if (arr[ny][nx] == 0 || arr[ny][nx] == 2 || arr[ny][nx] == 4) {
                            q.offer(new position(ny, nx));
                        }
                    }
                }
            }
            if (key.isEmpty()) {
               sb.append(0+"\n");
            } else {
                visited = new boolean[n][m];
                q.clear();
                q.offer(key.get(0));
                boolean flag = false;
                while (!q.isEmpty()) {
                    position cur = q.poll();
                    if (arr[cur.y][cur.x] == 2) {
                        flag=true;
                        break;
                    }
                    for (int i = 0; i < 4; i++) {
                        int ny = dy[i] + cur.y;
                        int nx = dx[i] + cur.x;
                        if (ny >= 0 && nx >= 0 && ny < n && nx < m && !visited[ny][nx]) {
                            visited[ny][nx] = true;
                            if (arr[ny][nx] == 0 || arr[ny][nx]==2) {
                                q.offer(new position(ny, nx));
                            }
                        }
                    }
                }
                if(flag)
                {
                    sb.append(1+"\n");
                }
                else
                {
                    sb.append(0+"\n");
                }
            }
        }
        System.out.println(sb);
    }


    static class position {
        int y, x;

        public position(int key, int box) {
            this.y = key;
            this.x = box;
        }
    }
}
