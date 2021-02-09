package oneDay_twoSol.Samsung;

import java.util.Scanner;

public class teengerShark {
    static int dy[] = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int dx[] = {0, -1, -1, -1, 0, 1, 1, 1};
    static class Fish {
        int y, x;
        int dir;

        public Fish(int y, int x, int direc) {
            this.y = y;
            this.x = x;
            this.dir = direc;
        }

        @Override
        public String toString() {
            return "Fish{" +
                    "y=" + y +
                    ", x=" + x +
                    ", dir=" + dir +
                    '}';
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       int[][] map = new int[4][4];
        Fish[] fish = new Fish[16];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int a = sc.nextInt(); // 상어 번호
                int b = sc.nextInt(); // 방향 정의 1,2,3,4,5,6,7,8
                a--;
                b--;
                fish[a] = new Fish(i, j, b);
                map[i][j] = a;
            }
        }
        dfs(map, fish, 0, 0, 0);
        System.out.println(max);
    }

    static int max = 0;

    public static void dfs(int[][] map, Fish[] fish, int y, int x, int sum) {
        // 재귀 적으로 덮어서 쓰기..
        int[][] tempMap = new int[4][4];
        Fish[] tempFish = new Fish[16];
        // 복제.
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                tempMap[i][j]=map[i][j];
            }
        }

        for (int i = 0; i < fish.length; i++) {
            tempFish[i]=fish[i];
        }
        //==============


        // eat
        int fishNumber = tempMap[y][x];
        int shark_direc = tempFish[fishNumber].dir; // 상어가 방향 가지고.
        // 먹고 나서 초기화 해주고.
        tempFish[fishNumber].y = -1;
        tempFish[fishNumber].x = -1;
        tempFish[fishNumber].dir = -1;
        tempMap[y][x] = -1; // 상어 출현 -1;

        sum += (fishNumber + 1);
        if (max < sum)
            max = sum;
        // fish shift(작은 순서대로.)
        for (int i = 0; i < 16; i++) {
            if (tempFish[i].y == -1 ) // 상어의 위치.
                continue;
            System.out.println(tempFish[i].toString());
            int cy = tempFish[i].y;
            int cx = tempFish[i].x;
            int cdir = tempFish[i].dir;

            int ny = cy + dy[cdir];
            int nx = cx + dx[cdir];
            int ndir = cdir;
            // 상어자리 이거나 혹은 범위 밖으로 초과할 때 갱신.방향 갱신.
            while (ny < 0 || ny >= 4 || nx < 0 || nx >= 4 || (ny == y && nx == x)) {
                ndir = (ndir + 1) % 8;
                ny = cy + dy[ndir];
                nx = cx + dx[ndir];
            }
            if (tempMap[ny][nx] != -1) { // 물고기가 업는 것.
                int target = tempMap[ny][nx];
                tempFish[target].y = cy;
                tempFish[target].x = cx;
                // 방향 안바뀜...
                tempFish[i].y = ny;
                tempFish[i].x = nx;
                tempFish[i].dir = ndir;

                tempMap[ny][nx] = i;
                tempMap[cy][cx] = target;
            } else {
                tempFish[i].y = ny;
                tempFish[i].x = nx;
                tempFish[i].dir = ndir;
                tempMap[ny][nx] = i;
                tempMap[cy][cx] = -1;
            }

        }
        System.out.println("========");
        // 한번에 1~3칸 이동.
        for (int step = 1; step < 4; ++step) {
            int ny = y + dy[shark_direc] * step;
            int nx = x + dx[shark_direc] * step;
            if (ny < 0 || ny >= 4 || nx < 0 || nx >= 4) {
                break;
            }
            if (tempMap[ny][nx] != -1) {
                System.out.println("호출"+x +" ,"+y);
                dfs(tempMap, tempFish, ny, nx, sum);
            }
        }
    }


    ;

}
