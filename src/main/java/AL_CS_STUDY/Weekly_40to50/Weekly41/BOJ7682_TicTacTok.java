package AL_CS_STUDY.Weekly_40to50.Weekly41;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ7682_TicTacTok {
    static final int N = 3;
    private static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer answers = new StringBuffer();
        while (true) {
            String input = br.readLine();
            if (input.equals("end")) break;

            map = new char[N][N];
            for (int i = 0; i < N * N; i++) {
                map[i / N][i % N] = input.charAt(i);
            }

            if (check()) {
                answers.append("valid\n");
            } else {
                answers.append("invalid\n");
            }
        }
        System.out.println(answers);
    }

    private static boolean check() {
        int oCnt = 0, xCnt = 0, empty = 0;
        for (int i = 0; i < N * N; i++) {
            char ch = map[i / N][i % N];
            if (ch == 'X') xCnt++;
            else if (ch == 'O') oCnt++;
            else empty++;
        }

        if (xCnt + oCnt == 9) {
            if (xCnt - 1 != oCnt || isValid('O')) return false;
            else return true;
        }else{
            if(xCnt==oCnt){
                boolean isO=isValid('O');
                boolean isX=isValid('X');
                if(isO && !isX){
                    return true;
                }else{
                    return false;
                }
            }else if(xCnt-1==oCnt){
                boolean isO=isValid('O');
                boolean isX=isValid('X');
                if(!isO && isX){
                    return true;
                }else {
                    return false;
                }
            }
        }
        return false;
    }

    private static boolean isValid( char ch) {
        for (int i = 0; i < N; i++) {
            if (colCheck(i, ch)) return true;
        }

        for (int j = 0; j < N; j++) {
            if (rowCheck(j, ch)) return true;
        }
        for (int i = 0; i < N; i++) {
            if (leftDiagonal(map, ch)) return true;
        }
        for (int i = 0; i < N; i++) {
            if (rightDiagonal(map, ch)) return true;
        }

        return false;
    }

    private static boolean leftDiagonal(char[][] map, char ch) {
        for (int i = 0; i < N; i++) {
            if (map[0 + i][0 + i] == ch) continue;
            else return false;
        }
        return true;
    }

    private static boolean rightDiagonal(char[][] map, char ch) {
        for (int i = 0; i < N; i++) {
            if (map[0 + i][N - 1 - i] == ch) continue;
            else return false;
        }
        return true;
    }

    private static boolean rowCheck(int col, char ch) {
        for (int i = 0; i < N; i++) {
            if (map[i][col] == ch) continue;
            else return false;
        }
        return true;
    }

    private static boolean colCheck(int row, char ch) {
        for (int j = 0; j < N; j++) {
            if (map[row][j] == ch) continue;
            else return false;
        }
        return true;
    }

}
