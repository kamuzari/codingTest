package oneDay_twoSol.Samsung;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class test {
    static int dy[] = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int dx[] = {0, -1, -1, -1, 0, 1, 1, 1};
    static class Shark {
        int y, x;
        int dir,eatSum;


        public Shark(int y, int x, int dir, int eatSum) {
            this.y = y;
            this.x = x;
            this.dir = dir;
            this.eatSum = eatSum;
        }
    }
    static class Fish {
        int y, x,id;
        int dir;
        boolean isAlive = true;
        public Fish(int id,int y, int x, int direc,boolean isAlive) {
            this.id=id;
            this.y = y;
            this.x = x;
            this.dir = direc;
            this.isAlive = isAlive;
        }

    }
    static int maxSum=0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int map[][] = new int[4][4];
        ArrayList<Fish> fish=new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int a = sc.nextInt(); // 물고기 번호
                int b = sc.nextInt(); // 방향 정의 1,2,3,4,5,6,7,8
               Fish f=new Fish(a,i,j,b,true);
               fish.add(f);
               map[i][j]=a;
            }
        }
        Collections.sort(fish, new Comparator<Fish>() {
            @Override
            public int compare(Fish o1, Fish o2) {
                return o1.id - o2.id;
            }
        });
        Fish f=fish.get(map[0][0]-1);
        Shark s=new Shark(0,0,f.dir,f.id);
        f.isAlive=false;
        map[0][0]=-1;
        dfs(map, s, fish);
        System.out.println(maxSum);
    }
    public static void dfs(int [][] map,Shark shark,ArrayList<Fish> fishes)
    {
        if(maxSum< shark.eatSum)
            maxSum= shark.eatSum;

        fishes.forEach(e->moveFish(e,map,fishes));

        for (int dist = 1; dist < 4; dist++) {
            int nx = shark.x + dx[shark.dir] * dist;
            int ny = shark.y + dy[shark.dir] * dist;

            if (0 <= nx && nx < 4 && 0 <= ny && ny < 4 && map[nx][ny] > -1) {
                // 물고기 잡아먹고 dfs
                int[][] mapCopy =new int[4][4];
                for (int i = 0; i < 4; i++) {
                    mapCopy[i]=map[i].clone();
                }
                ArrayList<Fish> fishCopies = new ArrayList<>(fishes);


                mapCopy[shark.x][shark.y] = 0;
                Fish f = fishCopies.get(map[nx][ny] - 1);
                Shark newShark = new Shark(f.y, f.x, f.dir, shark.eatSum + f.id);
                f.isAlive = false;
                mapCopy[f.x][f.y] = -1;

                dfs(mapCopy, newShark, fishCopies);
            }
        }
    }
    static void moveFish(Fish fish,int[][]map,ArrayList<Fish> fishes)
    {
        if(!fish.isAlive)
            return;

        for (int i = 0; i < 8; i++) {
            int nd=(fish.dir+i)%8;
            int ny= fish.y+dy[nd];
            int nx= fish.x+dx[nd];
            if(ny>=0 && nx>=0 && ny<4 && nx<4 && map[ny][nx]>-1)
            {
                map[fish.y][fish.x]=0;

                if (map[nx][ny] == 0) {
                    fish.x = nx;
                    fish.y = ny;
                } else {
                    Fish temp = fishes.get(map[nx][ny] - 1);
                    temp.x = fish.x;
                    temp.y = fish.y;
                    map[fish.x][fish.y] = temp.id;

                    fish.x = nx;
                    fish.y = ny;
                }

                map[nx][ny] = fish.id;
                fish.dir = nd;
                return;
            }
        }

    }
    static int[][] copyArr(int[][] arr) {
        int[][] temp = new int[4][4];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                temp[i][j] = arr[i][j];
            }
        }

        return temp;
    }

    static ArrayList<Fish> copyFishes(ArrayList<Fish> fishes) {
        ArrayList<Fish> temp = new ArrayList<>();
        fishes.forEach(e -> temp.add(new Fish(e.x, e.y, e.id, e.dir, e.isAlive)));
        return temp;
    }

    }