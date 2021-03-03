package Thur_Sunday_aWeek_Al.SAMSUNG;

import java.util.*;

/*
바이러스를 m개 만큼 순서에 상관없이 뽑고. bfs 돌려서 거리를 map에 남긴다.

*/
public class Laboratory2 {
    static class Position {
        int y;
        int x;

        public Position(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int dy[] = {-1, 1, 0, 0};
    static int dx[] = {0, 0, -1, 1};
    static int map[][];
    static int n;
    static int m;
    static ArrayList<Position> virus = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][n];
        int cnt=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int a = sc.nextInt();
                if (a == 2)
                    virus.add(new Position(i, j));
                map[i][j] = a;
                if(a==0)
                    cnt++;
            }
        }

        flag = true;
        if(cnt-virus.size()<0)
            flag=false;

        if (flag) {
            combination(0, 0);
        }
        if(!flag)
        {
            System.out.println("0");
            return;
        }
        if (Min == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(Min);
    }

    static Stack<Position> s = new Stack<>();

    static void combination(int idx, int depth) {
        if (depth == m) {
            int temp[][] = new int[n][n];
            temp = copy();
            bfs(temp);
            return;
        }
        for (int i = idx; i < virus.size(); i++) {
            s.push(virus.get(i));
            combination(i + 1, depth + 1);
            s.pop();
        }
    }

    static int Min = Integer.MAX_VALUE;

    static int[][] copy() {
        int temp[][] = new int[n][n];
        for (Position p : s) {
            temp[p.y][p.x] = -2;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] != 2) {
                    if (map[i][j] == 1) // wall
                    {
                        temp[i][j] = -1;
                    } else
                        temp[i][j] = map[i][j];
                }
            }
        }
        return temp;
    }

    static boolean flag = true;

    static void bfs(int map[][]) {
        int max = -1;
        Queue<Position> q = new LinkedList<>();
        boolean visited[][] = new boolean[n][n];
        for (Position p : s) {
            q.offer(p);
            visited[p.y][p.x] = true;
        }
        while (!q.isEmpty()) {
            Position cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];

                if (ny >= 0 && nx >= 0 && ny < n && nx < n && !visited[ny][nx]) // boundary
                {
                    visited[ny][nx] = true;
                    if (map[ny][nx] != -1 && map[ny][nx] != -2) {
                        if (map[ny][nx] == 0 && map[cur.y][cur.x] == -2) {
                            map[ny][nx] = map[cur.y][cur.x] + 2 + 1;
                        } else if (map[ny][nx] == 0 && map[cur.y][cur.x] != -2) {
                            map[ny][nx] = map[cur.y][cur.x] + 1;
                        } else {
                            map[ny][nx] = Math.min(map[ny][nx], map[cur.y][cur.x] + 1);
                        }
                        max = Math.max(map[ny][nx], max);
                        q.add(new Position(ny, nx));
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 0) {
                    max = Integer.MAX_VALUE;
                }
//                System.out.print((map[i][j])+" ");
            }
//            System.out.println();
        }
//        System.out.println("------------------------");
        Min = Math.min(max, Min);
    }
}

/*
3
3
2 2 2
0 1 0
0 0 0
*/
