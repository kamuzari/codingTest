package tues_thurs_sat.simulation;

import java.util.Scanner;

//https://www.acmicpc.net/problem/3987
public class voyagerOneFalse {
    static int n, m;
    static char[][] map;
    static int dy[] = {-1, 0, 1, 0};
    static int dx[] = {0, 1, 0, -1};
    static boolean visited[][];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new char[n][m];
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            map[i] = str.toCharArray();
        }

        int y = sc.nextInt();
        int x = sc.nextInt();
        for (int i = 0; i < 4; i++) {
            visited = new boolean[n][m];
            dfs(y - 1, x - 1, i, i);
            if (max == (int) 1e9) {
                break;
            }
//            for (int j = 0; j < n; j++) {
//                System.out.println(Arrays.toString(visited[j]));
//            }
        }
        switch (dir_idx) {
            case 0:
                System.out.println("U");
                if (max == (int) 1e9) {
                    System.out.println("Voyager");
                } else {
                    System.out.println(max);
                }
                break;
            case 1:
                System.out.println("R");
                if (max == (int) 1e9) {
                    System.out.println("Voyager");
                } else {
                    System.out.println(max);
                }
                break;
            case 2:
                System.out.println("D");
                if (max == (int) 1e9) {
                    System.out.println("Voyager");
                } else {
                    System.out.println(max);
                }
                break;
            case 3:
                System.out.println("L");
                if (max == (int) 1e9) {
                    System.out.println("Voyager");
                } else {
                    System.out.println(max);
                }
                break;
        }

    }

    static int cnt = 1;
    static int max = 0;
    static int dir_idx = -1;

    static void dfs(int y, int x, int dir, int original_dir) {
        if (map[y][x] == 'C') {
            if (max < cnt) {
                max = cnt;
                dir_idx = original_dir;
            }
//            System.out.println(cnt);
            cnt = 1;
            return;
        }
        visited[y][x] = true;

        int ny = y + dy[dir];
        int nx = x + dx[dir];
        if (ny >= 0 && nx >= 0 && ny < n && nx < m) {
            cnt++;
            if (visited[ny][nx] && map[ny][nx]=='*') {
                cnt--;
                max = (int) 1e9;
                dir_idx = original_dir;
                return;
            }
            if (map[ny][nx] == '\\') {
                if (dir == 0) {
                    dir = 3;
                } else if (dir == 1) {
                    dir = 2;
                } else if (dir == 2) {
                    dir = 1;
                } else if (dir == 3) {
                    dir = 0;
                }

                dfs(ny, nx, dir, original_dir);
            } else if (map[ny][nx] == '/') {
                if (dir == 0) {
                    dir = 1;
                } else if (dir == 1) {
                    dir = 0;
                } else if (dir == 2) {
                    dir = 3;
                } else if (dir == 3) {
                    dir = 2;
                }
                dfs(ny, nx, dir, original_dir);
            } else
                dfs(ny, nx, dir, original_dir);
        } else {
            if (max < cnt) {
                max = cnt;
                dir_idx = original_dir;
            }
//            System.out.println(cnt);
            cnt = 1;
            return;
        }
    }
}
