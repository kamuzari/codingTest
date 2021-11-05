package Programmers.ProgrammersKit.KakaoBlind;

import java.util.Arrays;

public class CheckTheDistance {
    public static void main(String[] args) {
        String p[][] = {
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"},
                {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}

        };
        solution(p);
        System.out.println();
    }
    public static int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        char map[][] = new char[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                map[j] = places[i][j].toCharArray();
                System.out.println(Arrays.toString(map[j]));
            }
            System.out.println();
            if (check(map))
                answer[i] = 1;
            else
                answer[i] = 0;
        }
        System.out.println(Arrays.toString(answer));
        return answer;
    }

    public static boolean check(char map[][]) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (map[i][j] == 'P') {
                    if (!nearChecking(i, j, map))
                        return false;
                }

            }
        }
        return true;

    }

    static int dy[] = {-1,1,0,0,-1, -1, 1, 1, -2, 2, 0, 0};
    static int dx[] = {0,0,-1,1,-1, 1, -1, 1, 0, 0, 2, 2};

    public  static boolean nearChecking(int y, int x, char map[][]) {
        int ny = 0;
        int nx = 0;
        for (int i = 0; i < 4; i++) {
            ny=dy[i]+y;
            nx=dx[i]+x;
            if (ny < 0 || nx < 0 || ny >= 5 || nx >= 5)
                continue;
            if(map[ny][nx]=='P')
                return false;
        }
        for (int k = 4; k < 8; k++) {
            ny = y + dy[k];
            nx = x + dx[k];
            if (ny < 0 || nx < 0 || ny >= 5 || nx >= 5)
                continue;
            if (map[ny][nx] == 'P') {
                if (map[ny][x] == 'P' || map[ny][x] == 'O' || map[y][nx] == 'P' || map[y][nx] == 'O')
                    return false;
            }
        }
        for (int k = 8; k < 12; k++) {
            ny = y + dy[k];
            nx = x + dx[k];
            if (ny < 0 || nx < 0 || ny >= 5 || nx >= 5)
                continue;
            if (map[ny][nx] == 'P') {
                if (map[(ny+y) / 2][(nx+x) / 2] == 'P' || map[(ny+y) / 2][(nx+x) / 2] == 'O')
                    return false;
            }
        }
        return true;
    }
}
