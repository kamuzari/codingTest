package WeeklyThuseday.RT._0519;

public class ArrayBoarderRotate {

    static int map[][];
    static int min;
    public int[] solution(int rows, int columns, int[][] queries) {
        map = new int[rows + 1][columns + 1];
        int[] answer = new int[queries.length];
        int num = 1;
        for(int i = 1; i <= rows; i++) {
            for(int j = 1; j <= columns; j++) {
                map[i][j] = num;
                num++;
            }
        }

        for(int i = 0; i < queries.length; i++) {
            answer[i] = rotation(queries[i]);
        }
        return answer;
    }

    private int rotation(int[] query) {
        int yMove = query[2] - query[0];
        int xMove = query[3] - query[1];

        int ny=query[0];
        int nx=query[1];
        int now=map[ny][nx];

        min=now;
        // 오른쪽
        for(int i = 0; i < xMove; i++) {
            nx += 1;
            now = move(ny, nx, now);
        }

        // 아래
        for(int i = 0; i < yMove; i++) {
            ny += 1;
            now =move(ny, nx, now);
        }

        // 왼쪽
        for(int i = 0; i < xMove; i++) {
            nx -= 1;
            now =move(ny, nx, now);
        }

        // 위쪽
        for(int i = 0; i < yMove; i++) {
            ny -= 1;
            now = move(ny, nx, now);
        }
        return min;
    }
    static int move(int y, int x, int before) {
        int temp = map[y][x];

        min = Math.min(min, temp);

        map[y][x] = before;

        return temp;
    }
}
