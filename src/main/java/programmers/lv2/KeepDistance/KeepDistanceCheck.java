package programmers.lv2.KeepDistance;
import java.util.*;
public class KeepDistanceCheck {
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
        // System.out.println(Arrays.toString(answer));
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

    static int dy[] = {-1, -1, 1, 1, -2, 2, 0, 0};
    static int dx[] = {-1, 1, -1, 1, 0, 0, 2, 2};
    static int dy2[]={-1,1,0,0};
    static int dx2[]={0,0,-1,1};

    public  static boolean nearChecking(int y, int x, char map[][]) {
        int ny = 0;
        int nx = 0;
        for (int i = 0; i < 4; i++) {
            ny=dy2[i]+y;
            nx=dx2[i]+x;
            if (ny < 0 || nx < 0 || ny >= 5 || nx >= 5)
                continue;
            if(map[ny][nx]=='P')
                return false;
        }
        for (int k = 0; k < 4; k++) {
            ny = y + dy[k];
            nx = x + dx[k];
            if (ny < 0 || nx < 0 || ny >= 5 || nx >= 5)
                continue;
            if (map[ny][nx] == 'P') {
                if (map[ny][x] == 'P' || map[ny][x] == 'O' || map[y][nx] == 'P' || map[y][nx] == 'O')
                    return false;
            }
        }
        for (int k = 4; k < 8; k++) {
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
