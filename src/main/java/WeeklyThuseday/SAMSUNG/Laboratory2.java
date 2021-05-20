package WeeklyThuseday.SAMSUNG;

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

        @Override
        public String toString() {
            return "Position{" +
                    "y=" + y +
                    ", x=" + x +
                    '}';
        }
    }

    static int dy[] = {-1, 1, 0, 0};
    static int dx[] = {0, 0, -1, 1};
    static int map[][];
    static int n;
    static int m;
    static int zeroCnt = 0;
    static ArrayList<Position> virus = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][n];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int a = sc.nextInt();
                if (a == 2)
                    virus.add(new Position(i, j));
                if (a == 0)
                    zeroCnt++;
                map[i][j] = a;
            }
        }

        comb(0, 0);
       if(min==Integer.MAX_VALUE)
       {
           System.out.println("-1");
       }
       else if(min==0)
       {
           System.out.println("0");
       }
       else
       {
           System.out.println(min);
       }
    }

    static Set<Position> set = new HashSet<>();
    static void comb(int idx, int cnt) {
        if (cnt == m) {
            int copyMap[][] = copy(set);
            int ret = bfs(copyMap);
            min = Math.min(ret, min);
            return;
        }
        for (int i = idx; i < virus.size(); i++) {
            set.add(virus.get(i));
            comb(i + 1, cnt + 1);
            set.remove(virus.get(i));
        }
    }

    static int min = Integer.MAX_VALUE;

    private static int bfs(int[][] copyMap) {
        int max = 0;
        Queue<Position> q = new LinkedList<>();
        boolean v[][] = new boolean[n][n];
        for (Position p : set) {
            q.offer(p);
            v[p.y][p.x] = true;
        }
        while (!q.isEmpty()) {
            Position cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int ny = dy[i] + cur.y;
                int nx = dx[i] + cur.x;
                if (ny >= 0 && nx >= 0 && ny < n && nx < n && !v[ny][nx]) {
                    if (copyMap[ny][nx] == 0) {
                        if (copyMap[cur.y][cur.x] == -2) {
                            copyMap[ny][nx] = 1;
                        }
                        else {
                            copyMap[ny][nx] = copyMap[cur.y][cur.x] + 1;
                        }
                        v[ny][nx]=true;
                        max = Math.max(copyMap[ny][nx], max);
                        q.offer(new Position(ny, nx));
                    }
                }
            }
        }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (copyMap[i][j] == 0) {
                        max = Integer.MAX_VALUE;
                        break;
                    }
                }
            }
        return max;
    }

    private static int[][] copy(Set<Position> set) {
        int temp[][] = new int[n][n];
        for (Position p : set) {
            temp[p.y][p.x] = -2;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] != 2) {
                    if (map[i][j] == 1)
                        temp[i][j] = -1;
                    else
                        temp[i][j] = map[i][j];
                }
            }
        }
        return temp;
    }
}

