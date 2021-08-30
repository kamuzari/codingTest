package AL_CS_STUDY.Weekly_20to30.Weekly25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class TeenagerShark {
    static class Shark {
        int y, x, dir, eatSum;

        public Shark(int y, int x, int dir, int eatSum) {
            this.y = y;
            this.x = x;
            this.dir = dir;
            this.eatSum = eatSum;
        }
    }

    static class Fish {
        int idx, y, x, dir;
        boolean live;

        public Fish(int idx, int y, int x, int dir, boolean live) {
            this.idx = idx;
            this.y = y;
            this.x = x;
            this.dir = dir;
            this.live = live;
        }

        @Override
        public String toString() {
            return "Fish{" +
                    "idx=" + idx +
                    ", y=" + y +
                    ", x=" + x +
                    ", dir=" + dir +
                    ", live=" + live +
                    '}';
        }
    }

    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
    static int maxSum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int map[][] = new int[4][4];
        List<Fish> fishList = new LinkedList<>();

        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 4; j++) {
                int idx = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken())-1;

                fishList.add(new Fish(idx, i, j, dir, true));
                map[i][j] = idx;
            }
        }

        fishList.sort((o1, o2) -> o1.idx - o2.idx);
//        System.out.println(fishList);
        Fish eating = fishList.get(map[0][0] - 1);
        Shark shark = new Shark(0, 0, eating.dir, eating.idx);
        eating.live = false;
        map[0][0] = -1;

        dfs(shark, map, fishList);
        System.out.println(maxSum);
    }

    private static void dfs(Shark shark, int[][] map, List<Fish> fishList) {

        maxSum = Math.max(maxSum, shark.eatSum);

        fishList.forEach(fish -> move(fish, map, fishList));

        for (int dist = 1; dist < 4; dist++) {
            int ny = shark.y + dy[shark.dir] * dist;
            int nx = shark.x + dx[shark.dir] * dist;

            if (ny >= 0 && nx >= 0 && ny < 4 && nx < 4 && map[ny][nx] > 0) {
                int copy[][] = copyArr(map);
                List<Fish> copyList = copyList(fishList);

                copy[shark.y][shark.x] = 0;
                Fish eating = copyList.get(map[ny][nx] - 1);
                Shark newShark = new Shark(eating.y, eating.x, eating.dir, shark.eatSum + eating.idx);
                eating.live = false;
                copy[eating.y][eating.x] = -1;
//                for (int i = 0; i < 4; i++) {
//                    System.out.println(Arrays.toString(copy[i]));
//                }

                dfs(newShark, copy, copyList);
            }
        }
    }

    private static int[][] copyArr(int[][] map) {
        int temp[][] = new int[4][4];
        for (int i = 0; i < 4; i++) {
            temp[i] = map[i].clone();
        }

        return temp;
    }

    private static List<Fish> copyList(List<Fish> fishList) {
        List<Fish> temp = new LinkedList<>();
        fishList.forEach(fish -> temp.add(new Fish(fish.idx, fish.y, fish.x, fish.dir, fish.live)));
        return temp;
    }

    private static void move(Fish fish, int[][] arr, List<Fish> fishList) {
        if (!fish.live) {
            return;
        }
        for (int i = 0; i < 8; i++) {
            int nDir = (fish.dir + i) % 8;
            int ny = fish.y + dy[nDir];
            int nx = fish.x + dx[nDir];

            if (ny >= 0 && nx >= 0 && ny < 4 && nx < 4 && arr[ny][nx] > -1) {
                arr[fish.y][fish.x] = 0;
                if (arr[ny][nx] == 0) {
                    fish.y = ny;
                    fish.x = nx;
                } else if (arr[ny][nx] != 0) {
                    Fish swapping = fishList.get(arr[ny][nx] - 1);
                    swapping.y = fish.y;
                    swapping.x = fish.x;
                    arr[fish.y][fish.x] = swapping.idx;

                    fish.y = ny;
                    fish.x = nx;
                }
                arr[ny][nx] = fish.idx;
                fish.dir = nDir;
                return;
            }
        }
    }

}
/*

[Fish{x=1, y=1, id=1, dir=7, isAlive=true},
  Fish{x=0, y=1, id=2, dir=2, isAlive=true},
    Fish{x=1, y=0, id=3, dir=0, isAlive=true},
      Fish{x=2, y=2, id=4, dir=2, isAlive=true},
        Fish{x=3, y=2, id=5, dir=1, isAlive=true}, Fish{x=2, y=0, id=6, dir=0, isAlive=true}, Fish{x=0, y=0, id=7, dir=5, isAlive=true}, Fish{x=3, y=1, id=8, dir=6, isAlive=true}, Fish{x=0, y=3, id=9, dir=7, isAlive=true}, Fish{x=1, y=3, id=10, dir=0, isAlive=true}, Fish{x=2, y=3, id=11, dir=3, isAlive=true}, Fish{x=3, y=3, id=12, dir=1, isAlive=true}, Fish{x=2, y=1, id=13, dir=5, isAlive=true}, Fish{x=1, y=2, id=14, dir=6, isAlive=true}, Fish{x=0, y=2, id=15, dir=5, isAlive=true}, Fish{x=3, y=0, id=16, dir=0, isAlive=true}]
0
[0, 2, 9, 10]
[6, -1, 1, 14]
[16, 5, 15, 13]
[3, 4, 11, 8]
7
[-1, 9, 10, 14]
[16, 0, 0, 1]
[5, 2, 13, 8]
[3, 4, 11, 15]
19
[0, 2, 9, 10]
[6, 12, 1, 14]
[16, 5, -1, 13]
[3, 4, 11, 8]
[12, 9, 10, 14]
[16, 6, 0, 1]
[5, 13, 0, 8]
[3, 4, 2, -1]
25
[0, 2, 9, 10]
[6, 12, 1, 14]
[16, 5, 15, 13]
[3, 4, 11, -1]
33


*/