package Programmers.LV2;

public class VisitedLength {
    static final int MAP_SIZE = 11;
    static final int DIRECTION = 4;
    static final int UP = 1;
    static final int DOWN = 2;
    static final int RIGHT = 3;
    static final int LEFT = 4;

    static int dy[] = {0, -1, 1, 0, 0};
    static int dx[] = {0, 0, 0, -1, 1};
    /*
     * 3차원 배열 선언 이유 := 2차원 방문 시 이전에 어떤 방향에서 오든 것을 판단하여 길이를 늘려주어야 한다. 2차원 배열은 이미 한번 방문하면 새로운 길이를 더할 수 없다.
     */
    static int map[][][] = new int[MAP_SIZE][MAP_SIZE][DIRECTION + 1];

    public int solution(String dirs) {
        int answer = 0;
        int sy = 5;
        int sx = 5;
        int prevDir = 0;
        for (int i = 0; i < dirs.length(); i++) {
            char ch = dirs.charAt(i);
            int ny = 0;
            int nx = 0;
            int nextDir = 0;
            if (ch == 'U') {
                ny = sy + dy[UP];
                nx = sx + dx[UP];
                prevDir = DOWN;
                nextDir = UP;
            } else if (ch == 'D') {
                ny = sy + dy[DOWN];
                nx = sx + dx[DOWN];
                prevDir = UP;
                nextDir = DOWN;
            } else if (ch == 'R') {
                ny = sy + dy[RIGHT];
                nx = sx + dx[RIGHT];
                prevDir = LEFT;
                nextDir = RIGHT;
            } else if (ch == 'L') {
                ny = sy + dy[LEFT];
                nx = sx + dx[LEFT];
                prevDir = RIGHT;
                nextDir = LEFT;
            }

            if (OutOfIndex(ny, nx)) {
                continue;
            }

            if (map[ny][nx][nextDir] == 0 && map[sy][sx][prevDir] == 0) { // 방문 체크
                map[sy][sx][prevDir] = 1;
                map[ny][nx][nextDir] = 1;
                answer++;
            }
            sy = ny;
            sx = nx;
        }
        return answer;
    }

    public boolean OutOfIndex(int ny, int nx) {
        return ny < 0 || nx < 0 || ny > MAP_SIZE - 1 || nx > MAP_SIZE - 1;
    }
}
