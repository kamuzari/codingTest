package bruteForce;

import java.util.Scanner;

public class chessPanel {
    static final char[][] white = { // (0,0)이 W일 때 가질 수 있는 규칙이다.
            { 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' }, { 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' },
            { 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' }, { 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' },
            { 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' }, { 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' },
            { 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' }, { 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' } };
    static final char[][] black = { // (0,0)이 B일 때 가질 수 있는 규칙이다.
            { 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' }, { 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' },
            { 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' }, { 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' },
            { 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' }, { 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' },
            { 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' }, { 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' } };

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String str[] = sc.nextLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        char arr[][] = new char[n][m];
        for (int i = 0; i < n; i++) {
            String s[] = sc.nextLine().split("");
            for (int j = 0; j < s.length; j++) {
                arr[i][j] = s[j].charAt(0);
            }
        }

        // ==========로직=================//
        int min_cnt = Integer.MAX_VALUE;
        for (int i = 0; i <= arr.length - 8; i++) {
            for (int j = 0; j <= arr[i].length - 8; j++) {
//				System.out.print(possible(arr, i, j));
                if (min_cnt > possible(arr, i, j))
                    min_cnt = possible(arr, i, j);
//				System.out.print("   " + min_cnt + "   v    ");
            }
//			System.out.println();
        }
        System.out.println(min_cnt);
    }

    private static int possible(char arr[][], int row_start, int col_start) {
        int Change_cnt = 0;
        int Change_cnt2 = 0;
        int colindex = 0;
        int rowindex = 0;
        for (int i = row_start; i < row_start + 8; i++) {
            for (int j = col_start; j < col_start + 8; j++) {
                {
                    if (arr[i][j] != black[rowindex][colindex]) {
                        Change_cnt++;
                        // System.out.println(arr[i][j] + " " + black[rowindex][colindex]);
                    }

                }
                {
                    if (arr[i][j] != white[rowindex][colindex]) {
                        // System.out.println(arr[i][j] + " " + white[rowindex][colindex]);
                        Change_cnt2++;
                    }
                    colindex++;
                }
            }
            colindex = 0;
            rowindex++;
        }
        rowindex = 0;

        int total=Math.min(Change_cnt, Change_cnt2);

        return total;
    }
}