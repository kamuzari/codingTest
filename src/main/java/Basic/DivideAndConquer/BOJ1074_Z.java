package Basic.DivideAndConquer;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1074_Z {

    private static int r;
    private static int c;
    private int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        n = (int) Math.pow(2, n);
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
//        divide(n,0,0);
        int cnt = 0;
        int y = 0;
        int x = 0;

        while (n > 0) {
            n /= 2;

            if (r < y + n && c < x + n) {
                cnt += n * n * 0; // 1사분면
            } else if (r < y + n) {
                cnt += n * n * 1;  // 2사분면
                x += n;
            } else if (c < x + n) {
                cnt += n * n * 2; // 3사분면
                y += n;
            } else {
                cnt += n * n * 3;
                y += n;
                x += n;
            }

            if (n == 1) {
                System.out.println(cnt);
                break;
            }
        }
    }


    // TLE
    static int cnt = 0;
    public static void divide(int n, int sy, int sx) {
        if (n == 1) {
            if (r == sy && c == sx) {
                System.out.println(cnt);
                System.exit(0);
            }
            cnt++;
            return;
        }
        divide(n / 2, sy, sx);
        divide(n / 2, sy, sx + n / 2);
        divide(n / 2, sy + n / 2, sx);
        divide(n / 2, sy + n / 2, sx + n / 2);
    }

}
