package Basic.CompleteSearch_BackTracking;

import java.io.IOException;
import java.util.Scanner;

public class starLink {
    static int n, ablity[][];
    static boolean visited[];

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        ablity = new int[n][n];
        visited = new boolean[n];
        sc.nextLine();
        for (int i = 0; i < n; i++) {

            String str[]=sc.nextLine().split(" ");
            for (int j = 0; j < n; j++) {
                ablity[i][j] = Integer.parseInt(str[j]);
            }
        }
        teemDivide(0, 0);
        System.out.println(minGap);
    }

    static int minGap = Integer.MAX_VALUE;

    public static void teemDivide(int cnt, int idx) {
        if (cnt == n / 2) {
            calc();
            return;
        }
        for (int i = idx; i < n; i++) {
            visited[i] = true;
            teemDivide(cnt + 1, i + 1);
            visited[i] = false;
        }
    }

    public static void calc() {

        int startSum = 0;
        int linkSum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (visited[i] && visited[j]) {
                    startSum += ablity[i][j];
                    startSum += ablity[j][i];
                } else if (!visited[i] == !visited[j]) {
                    linkSum += ablity[j][i];
                    linkSum += ablity[i][j];
                }
            }
        }

         minGap=Math.min(minGap,Math.abs(startSum - linkSum));
    }
}
