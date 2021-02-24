package oneDay_twoSol.Implementation2.Basic;

import java.util.Scanner;

public class clock {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // n*1 00 00

        int cnt = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < 60; j++) {
                for (int k = 0; k < 60; k++) {
                    if (i % 10 == 3 || i/10==3 || j % 10 == 3 || j / 10 == 3 || k % 10 == 3 || k / 10 == 3)
                        cnt++;
                }
            }
        }
        System.out.println("cnt = " + cnt);

    }
}
