package tues_thurs_sat._20210820;

import java.util.LinkedList;
import java.util.List;

public class BlockGame {
    public static int n;
    public static int Board[][];

    public int solution(int[][] board) {
        int answer = 0;
        n = board.length;
        Board = board;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0) {
                    continue;
                }

                if (isA(i, j, board[i][j])) {
                    if (isdrop(i + 1, j + 1, board[i][j]) && isdrop(i + 1, j + 2, board[i][j])) {
                        remove(i,j,i+1,j,i+1,j+1,i+1,j+2);
                        j = -1;
                        answer++;

                    }
                } else if (isB(i, j, board[i][j])) {
                    if (isdrop(i + 2, j - 1, board[i][j])) {
                        remove(i,j,i+1,j,i+2,j,i+2,j-1);
                        j = -1;
                        answer++;
                    }

                } else if (isC(i, j, board[i][j])) {
                    if (isdrop(i + 2, j + 1, board[i][j])) {
                        remove(i,j,i+1,j,i+2,j,i+2,j+1);
                        j = -1;
                        answer++;
                    }

                } else if (isD(i, j, board[i][j])) {
                    if (isdrop(i + 1, j - 2, board[i][j]) && isdrop(i + 1, j - 1, board[i][j])) {
                        remove(i,j,i+1,j,i+1,j-1,i+1,j-2);
                        j = -1;
                        answer++;
                    }
                } else if (isE(i, j, board[i][j])) {
                    if (isdrop(i + 1, j - 1, board[i][j]) && isdrop(i + 1, j + 1, board[i][j])) {
                        remove(i,j,i+1,j,i+1,j-1,i+1,j+1);
                        j = -1;
                        answer++;
                    }
                }

            }
        }
        return answer;
    }

    private void remove(int y1, int x1, int y2, int x2, int y3, int x3, int y4, int x4) {
        Board[y1][x1] = 0;
        Board[y2][x2] = 0;
        Board[y3][x3] = 0;
        Board[y4][x4] = 0;
    }


    private boolean isdrop(int y, int x, int number) {
        for (int i = 0; i < y; i++) {
            if (Board[i][x] == 0) {
                continue;
            }
            if (Board[i][y] != number) {
                return false;
            }
        }
        return true;
    }

    private boolean isA(int y, int x, int number) {
        if (isOutOfBound(y + 1, x + 2)) {
            return false;
        }
        return Board[y + 1][x] == number && Board[y + 1][x + 1] == number && Board[y + 1][x + 2] == number;
    }

    private boolean isB(int y, int x, int number) {
        if (isOutOfBound(y + 2, x - 1)) {
            return false;
        }
        return Board[y + 1][x] == number && Board[y + 2][x] == number && Board[y + 2][x - 1] == number;
    }

    private boolean isC(int y, int x, int number) {
        if (isOutOfBound(y + 2, x + 1)) {
            return false;
        }
        return Board[y + 1][x] == number && Board[y + 2][x] == number && Board[y + 2][x + 1] == number;
    }

    private boolean isD(int y, int x, int number) {
        if (isOutOfBound(y + 1, x - 2)) {
            return false;
        }
        return Board[y + 1][x] == number && Board[y + 1][x - 1] == number && Board[y + 1][x - 2] == number;
    }

    private boolean isE(int y, int x, int number) {
        if (isOutOfBound(y + 1, x + 1) || isOutOfBound(y + 1, x - 1)) {
            return false;
        }
        return Board[y + 1][x] == number && Board[y + 1][x - 1] == number && Board[y + 1][x + 1] == number;
    }


    private boolean isOutOfBound(int y, int x) {
        return y >= n || x >= n || x < 0 || y < 0;
    }
}
