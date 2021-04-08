package thisCodingTest.Dynamic.PS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class goldMine {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= T; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            String str[] = br.readLine().split(" ");
            int arr[][] = new int[n + 2][m + 1];
            int row = -1;
            for (int j = 0; j < str.length; j++) {
                if (j % m == 0)
                    row++;
                arr[row + 1][j % m + 1] = Integer.parseInt(str[j]);
            }
            System.out.println(" ");
            System.out.println("dp 전");
            for (int j = 0; j < arr.length; j++) {
                System.out.println(Arrays.toString(arr[j]));
            }

            for (int k = 1; k < m + 1; k++) {
                for (int j = 1; j < n + 1; j++) {
//                    System.out.println(arr[j - 1][k - 1] + "  " + arr[j][k - 1] + "  " + arr[j + 1][k - 1]);
                    arr[j][k] += Math.max(arr[j - 1][k - 1], Math.max(arr[j][k - 1], arr[j + 1][k - 1]));
                }
            }
            System.out.println("dp 후");
            for (int j = 0; j < arr.length; j++) {
                System.out.println(Arrays.toString(arr[j]));
            }
            int ans=-1;
            for (int j = 1; j <n+1 ; j++) {
                ans=Math.max(ans,arr[j][m]);
            }

            System.out.println("ans = " + ans);
            System.out.println("=============================================================================================");

        }

    }
}

/*
input
3
3 4
1 3 3 2 2 1 4 1 0 6 4 7
4 4
1 3 1 5 2 2 4 1 5 0 2 3 0 6 1 2
3 3
1 3 3 2 1 4 0 6 4
output
19
16
12
*
* */
