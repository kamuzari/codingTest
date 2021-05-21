package WeeklyThuseday.SAMSUNG;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
바이러스를 m개 만큼 순서에 상관없이 뽑고. bfs 돌려서 거리를 map에 남긴다.

*/
public class Laboratory2 {
    static class Position {
        int y;
        int x;
        int previousDist;

        public Position(int y, int x, int previousDist) {
            this.y = y;
            this.x = x;
            this.previousDist = previousDist;
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
    static int answer = Integer.MAX_VALUE;
    static ArrayList<Position> virus = new ArrayList<>();
    static int virusCnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0)
                    zeroCnt++;
                else if (map[i][j] == 2) {
                    virus.add(new Position(i, j, 0));
                    virusCnt++;
                }
            }
        }
        if (zeroCnt == 0 && virusCnt ==m)
            System.out.println(0);
        else {
            comb(0, 0);
            System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
        }

    }

    static Set<Position> set = new LinkedHashSet<>();

    static void comb(int idx, int cnt) {
        if (cnt == m) {
            spread(zeroCnt);
            return;
        }
        for (int i = idx; i < virus.size(); i++) {
            set.add(virus.get(i));
            comb(i + 1, cnt + 1);
            set.remove(virus.get(i));
        }
    }

    private static void spread(int zero) {
        Queue<Position> q = new LinkedList<>();
        boolean v[][] = new boolean[n][n];
        for (Position virus : set) {
            v[virus.y][virus.x] = true;
            q.offer(virus);
        }
        ArrayList<Position> recovery = new ArrayList<>();
        for (int i = 0; i < virus.size(); i++) {
            if (!set.contains(virus.get(i))) {
                Position nonVirus = virus.get(i);
                recovery.add(nonVirus);
                map[nonVirus.y][nonVirus.x] = 0;
                zero++;
            }
        }

        while (!q.isEmpty()) {
            Position cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int ny = dy[i] + cur.y;
                int nx = dx[i] + cur.x;
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                if (v[ny][nx] || map[ny][nx] == 1) continue;
                if (map[ny][nx] == 0) {
                    zero--;
                }
                if (zero == 0) {
                    for (int j = 0; j < recovery.size(); j++) {
                        Position nonVirus = recovery.get(j);
                        map[nonVirus.y][nonVirus.x] = 2;
                    }
                    answer = Math.min(answer, cur.previousDist + 1);
                    return;
                }
                v[ny][nx] = true;
                q.offer(new Position(ny, nx, cur.previousDist + 1));
            }
        }
    }

}

