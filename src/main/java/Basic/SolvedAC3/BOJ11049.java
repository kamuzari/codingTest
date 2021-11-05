package Basic.SolvedAC3;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ11049 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m[][] = new int[n + 1][n + 1];
        int d[] = new int[n * 2 + 1];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            d[i] = Integer.parseInt(st.nextToken());
            d[i + 1] = Integer.parseInt(st.nextToken());
        }

        for (int len = 2; len <= n; len++) {
            for (int i = 1; i <= n - len + 1; i++) {
                int  j= i + len - 1;
                m[i][j]=Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int cost=m[i][k]+m[k+1][j]+d[i-1]*d[k]*d[j];
                    m[i][j]=Math.min(m[i][j],cost);
                }
            }
        }
        System.out.println(m[1][n]);
    }
}
