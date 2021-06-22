package AL_CS_STUDY.Weekly26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AdultShark {
    static int n, m, k;
    static Node map[][];
    static int dy[] = {0, -1, 1, 0, 0};
    static int dx[] = {0, 0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new Node[n][n];
        Shark shark[] = new Shark[m + 1];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = new Node(Integer.parseInt(st.nextToken()), -1);

                if (map[i][j].sharkIdx != 0) {
                    shark[map[i][j].sharkIdx] = new Shark(i, j);
                    map[i][j].smellCnt = k;
                }
            }

        }
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < m + 1; i++) {
            shark[i].dir = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i < m + 1; i++) {

            for (int j = 1; j <= 4; j++) {
                st = new StringTokenizer(br.readLine());
                for (int l = 1; l <= 4; l++) {
                    shark[i].posPriority[j][l] = Integer.parseInt(st.nextToken());
                }
            }
        }


        int time = 0;
        while (time < 1001) {
            shrinkSmell();

            int sharkCnt = 0;
            redo:
            for (int i = 1; i <=m; i++) {
                if (!shark[i].isAlive)
                    continue;
                if (map[shark[i].y][shark[i].x].sharkIdx != i) { // 장외
                    shark[i].isAlive = false;
                    continue;
                }
                sharkCnt++;

                int ny = 0, nx = 0;

                int sharkDir = shark[i].dir;
                // 우선 순위 (아무도 가지 않은 칸 )
                for (int j = 1; j <= 4; j++) {
                    int nDir = shark[i].posPriority[sharkDir][j];
                    ny = shark[i].y + dy[nDir];
                    nx = shark[i].x + dx[nDir];
                    if (ny < 0 || nx < 0 || ny >= n || nx >= n)
                        continue;

                    if (map[ny][nx].smellCnt < 0) {
                        shark[i].update(ny, nx, nDir);
                        continue redo;
                    }
                }
                // 내가 갔던 칸.
                for (int j = 1; j <= 4; j++) {
                    int nDir = shark[i].posPriority[sharkDir][j];
                    ny = shark[i].y + dy[nDir];
                    nx = shark[i].x + dx[nDir];
                    if (ny < 0 || nx < 0 || ny >= n || nx >= n)
                        continue;

                    if (map[ny][nx].sharkIdx == i && map[ny][nx].smellCnt >= 0) {
                        shark[i].update(ny, nx, nDir);
                        continue redo;
                    }
                }
            }
            setting(shark);
            if (sharkCnt == 1)
                break;

            time++;
        }
        if (time >= 1001)
            System.out.println(-1);
        else
            System.out.println(time);

    }

    private static void setting(Shark[] shark) {
        for (int i = m; i > 0; i--) {
            if (shark[i].isAlive) {
                map[shark[i].y][shark[i].x].smellCnt = k;
                map[shark[i].y][shark[i].x].sharkIdx = i;

            }
        }
    }

    private static void shrinkSmell() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j].smellCnt--;
            }
        }
    }

    static class Node {
        int sharkIdx;
        int smellCnt;

        public Node(int sharkIdx, int smellCnt) {
            this.sharkIdx = sharkIdx;
            this.smellCnt = smellCnt;
        }
    }

    static class Shark {
        int y, x, dir;
        int posPriority[][];
        boolean isAlive;

        public Shark(int y, int x) {
            this.y = y;
            this.x = x;
            this.dir = 0;
            this.posPriority = new int[5][5];
            this.isAlive = true;
        }


        public void update(int y, int x, int dir) {
            this.y = y;
            this.x = x;
            this.dir = dir;
        }
    }
}
