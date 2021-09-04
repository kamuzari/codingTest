package tues_thurs_sat._202105._20210501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class BossMonster {
    static int n, m, p;
    static int dy[] = {-1, 1, 0, 0};
    static int dx[] = {-0, 0, -1, 1};
    static boolean visited[][][];
    static char map[][];
    static Map<Integer, Integer> power;

    static class Player {
        private int idx, y, x;

        public Player(int idx, int y, int x) {
            this.idx = idx;
            this.y = y;
            this.x = x;
        }
    }

    static int boss;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s[] = br.readLine().split(" ");
        m = Integer.parseInt(s[0]);
        n = Integer.parseInt(s[1]);
        p = Integer.parseInt(s[2]);
        map = new char[m][n];
        visited = new boolean[p][m][n];
        Queue<Player> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            char[] ch = br.readLine().toCharArray();
            map[i] = ch;
            for (int j = 0; j < m; j++) {
                if (map[i][j] >= 'a' && map[i][j] <= 'z') {
                    int idx = map[i][j] - 'a';
                    q.add(new Player(idx, i, j));
                    visited[idx][i][j] = true;
                }
            }
        }
        power = new HashMap<>();
        for (int i = 0; i < p; i++) {
            s = br.readLine().split(" ");
            power.put(s[0].charAt(0) - 'a', Integer.parseInt(s[1]));
        }
        boss = Integer.parseInt(br.readLine());


        boolean[] flag = new boolean[p];
        int cnt = 0;

        while (boss > 0) {
            int size = q.size();
            while (size-- > 0) {
                Player cur = q.poll();
                if (flag[cur.idx])
                    continue;
                if (map[cur.y][cur.x] == 'B') {
                    flag[cur.idx] = true;
                    cnt++;
                }
                for (int i = 0; i < 4; i++) {
                    int ny=dy[i]+cur.y ;
                    int nx=dx[i]+cur.x ;
                    if(ny>=0 && nx>=0 && ny<m && nx<n)
                    {
                        if(!visited[cur.idx][ny][nx]
                        && map[ny][nx]!='X')
                        {
                            visited[cur.idx][ny][nx]=true;
                            q.add(new Player(cur.idx,ny,nx));
                        }
                    }
                }
            }

            for (int i = 0; i < p; i++) {
                if(flag[i])
                    boss-=power.get(i);
            }
        }
        System.out.println(cnt);


    }
}
