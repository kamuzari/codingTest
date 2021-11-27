package Programmers.LV2;

public class BigSquareSearch {
    /*
    * 정사각형을 찾기 위한 완전탐색은 1000 ^3 로 실패
    *
    */
    public int solution(int[][] board) {
        int answer = 0;
        int b[][] = board;
        int n = b.length;
        int m = b[0].length;
        if (n == 1 && m == 1) { // 예외 상황
            return b[0][0];
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (b[i][j] == 1) {
                    if (i == 0 || j == 0) {
                        continue;
                    }
                    b[i][j] = Math.min(b[i - 1][j - 1], Math.min(b[i - 1][j], b[i][j - 1])) + 1;
                    answer = Math.max(answer, b[i][j]);
                }
            }
        }
        return answer * answer;
    }
}
