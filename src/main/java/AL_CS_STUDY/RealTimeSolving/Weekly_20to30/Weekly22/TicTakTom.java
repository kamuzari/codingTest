package AL_CS_STUDY.RealTimeSolving.Weekly_20to30.Weekly22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TicTakTom {
    static char map[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int testCase = 1; testCase <= t; testCase++) {
            sb.append("#").append(testCase).append(" ");
            map = new char[4][4];
            boolean hasDot = false;
            for (int i = 0; i < 4; i++) {
                String s[] = br.readLine().split("");
                for (int j = 0; j < 4; j++) {
                    map[i][j] = s[j].charAt(0);
                    if (map[i][j] == '.')
                        hasDot = true;
                }
            }

            if (!hasDot) {
                if (WhoIsWinner() == 'O') {
                    sb.append("O won");
                }

                if (WhoIsWinner() == 'X') {
                    sb.append("X won");
                }

                if (WhoIsWinner() == 'T') {
                    sb.append("Draw");
                }
            } else {
                if (WhoIsWinner() == 'O') {
                    sb.append("O won");
                }

                if (WhoIsWinner() == 'X') {
                    sb.append("X won");
                }

                if (WhoIsWinner() == 'T') {
                    sb.append("Game has not completed");
                }
            }
            sb.append("\n");
            if(testCase<t)
                br.readLine();
        }
        System.out.println(sb);
    }

    private static char WhoIsWinner() {
        for (int j = 0; j < 4; j++) {
            boolean O = true;
            boolean X = true;
            for (int i = 0; i < 4; i++) {
                if (O && (map[i][j] == 'O' || map[i][j] == 'T'))
                    O = true;
                else
                    O = false;

                if (X && (map[i][j] == 'X' || map[i][j] == 'T'))
                    X = true;
                else
                    X = false;
            }
            if (O)
                return 'O';
            else if (X)
                return 'X';
        }

        for (int i = 0; i < 4; i++) {
            boolean O = true;
            boolean X = true;
            for (int j = 0; j < 4; j++) {
                if (O && (map[i][j] == 'O' || map[i][j] == 'T'))
                    O = true;
                else
                    O = false;

                if (X && (map[i][j] == 'X' || map[i][j] == 'T'))
                    X = true;
                else
                    X = false;
            }
            if (O)
                return 'O';
            else if (X)
                return 'X';
        }

        boolean O=true;
        boolean X=true;
        for (int i = 0; i < 4; i++) {
            if (O && (map[i][i] == 'O' || map[i][i] == 'T')) {
                O = true;
            } else {
                O = false;
            }

            if (X && (map[i][i] == 'X' || map[i][i] == 'T')) {
                X = true;
            } else {
                X = false;
            }
        }
        if (O)
            return 'O';
        else if (X)
            return 'X';

        O=true;
        X=true;
        for (int i = 0; i < 4; i++) {
            if (O && (map[4-1-i][i] == 'O' || map[4-1-i][i] == 'T')) {
                O = true;
            } else {
                O = false;
            }

            if (X && (map[4-1-i][i] == 'X' || map[4-1-i][i] == 'T')) {
                X = true;
            } else {
                X = false;
            }
        }
        if (O)
            return 'O';
        else if (X)
            return 'X';

        return 'T';
    }
}
