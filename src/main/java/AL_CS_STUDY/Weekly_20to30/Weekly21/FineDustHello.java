package AL_CS_STUDY.Weekly_20to30.Weekly21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class FineDustHello {
    static class Dust {
        private int y, x, amount;

        public Dust(int y, int x, int amount) {
            this.y = y;
            this.x = x;
            this.amount = amount;
        }
    }

    static int n, m, t, cleaner = -1, map[][];
    static Queue<Dust> q;
    static int dy[] = {-1, 1, 0, 0};
    static int dx[] = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (cleaner == -1 && map[i][j] == -1) {
                    cleaner = i;
                }
            }
        }
        for (int i = 0; i < t; i++) {
            checkDust();
            spread();
            wind();
        }
        int answer=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j]==-1) continue;
                answer+=map[i][j];
            }
        }
        System.out.println(answer);
    }

    private static void wind() {
        int top=cleaner;
        int bottom=cleaner+1;

        // top wind
        for (int i = top-1; i >0; i--) {
            map[i][0]=map[i-1][0];
        }

        for (int i = 0; i < m-1; i++) {
            map[0][i]=map[0][i+1];
        }
        for (int i = 0; i < top; i++) {
            map[i][m-1]=map[i+1][m-1];
        }
        for (int i = m-1; i >1 ; i--) {
            map[top][i]=map[top][i-1];
        }
        map[top][1]=0;


        // bottom wind

        for (int i = bottom+1; i <n-1 ; i++) {
            map[i][0]=map[i+1][0];
        }
        for (int i = 0; i <m-1 ; i++) {
            map[n-1][i]=map[n-1][i+1];
        }
        for (int i = n-1; i >bottom ; i--) {
            map[i][m-1]=map[i-1][m-1];
        }
        for (int i = m-1; i >1 ; i--) {
            map[bottom][i]=map[bottom][i-1];
        }

        map[bottom][1]=0;
    }

    private static void spread() {
        while (!q.isEmpty())
        {
            Dust cur = q.poll();
            if(cur.amount<5)
                continue;
            int spreadAmount=cur.amount/5;
            int cnt=0;
            for (int i = 0; i < 4; i++) {
                int ny=dy[i]+cur.y;
                int nx=dx[i]+cur.x;

                if(ny>=0 && nx>=0 && ny<n && nx<m && map[ny][nx]!=-1)
                {
                    map[ny][nx]+=spreadAmount;
                    cnt++;
                }
            }
            map[cur.y][cur.x]-=spreadAmount*cnt;
        }
    }

    private static void checkDust() {

        q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == -1 || map[i][j] == 0) continue;
                q.add(new Dust(i, j, map[i][j]));
            }
        }

    }




}


