package Wed_aWeek_Study.Al_Study.set0_APPENDIX_별찍기;

import java.util.Scanner;

public class Star_19 {

    static char star[][];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        n = 4 * n - 3; //가로 세로의 출력
        star = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                star[i][j] = ' ';
            }
        }

        Star_19(0, n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(star[i][j]);
            }
            System.out.println();
        }
    }

    public static void Star_19(int s, int len) {
        if (len<=s) return;

        for (int i = s; i < len; i++) {
            star[s][i] = '*'; //맨 위 가로줄
            star[len - 1][i] = '*'; //맨 아래 가로줄
            star[i][s] = '*'; //왼쪽 세로줄
            star[i][len - 1] = '*'; //오른쪽 세로줄
        }


        // 별을 좌표라고 생각할 때 겉테두리의 사각형과 가장 근접한 사각형을 보았을 때 2만큼의 차이가 난다
        Star_19(s + 2, len - 2);
    }
}
