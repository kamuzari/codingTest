package tues_thurs_sat._202106._20210621;

import java.util.Arrays;

public class QuadTree {
    public static void main(String[] args) {
        int arr[][]= new int[][]
                {
                        {1, 1, 0, 0},
                        {1, 0, 0, 0},
                        {1, 0, 0, 1},
                        {1, 1, 1, 1}
                };
        System.out.println(Arrays.toString(solution(arr)));
    }

    static int map[][];

    public static int[] solution(int[][] arr) {
        map = arr;
        dfs(arr.length, 0, 0);
        return new int[]{zero, one};
    }

    static int one = 0;
    static int zero = 0;

    private static void dfs(int n, int y, int x) {
//        System.out.println("n = " + n + ", y = " + y + ", x = " + x);
        if (n == 1) {
            if (map[y][x] == 1)
                one++;
            else
                zero++;
            return;
        }

        if (isEqual(n, y, x)) {
            return;
        }

        dfs(n / 2, y, x);
        dfs(n / 2, y, x + n / 2);
        dfs(n / 2, y + n / 2, x);
        dfs(n / 2, y + n / 2, x + n / 2);
    }

    private static boolean isEqual(int n, int y, int x) {
        int criteria = map[y][x];
        for (int i = y; i < y + n; i++) {
            for (int j = x; j < x + n; j++) {
                if (criteria != map[i][j])
                    return false;
            }
        }
        if (criteria == 0)
            zero++;
        else
            one++;

        return true;
    }
}
