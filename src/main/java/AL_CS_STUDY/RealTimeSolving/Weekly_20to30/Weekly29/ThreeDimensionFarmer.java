package AL_CS_STUDY.RealTimeSolving.Weekly_20to30.Weekly29;

import java.io.*;
import java.util.*;

public class ThreeDimensionFarmer {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();
        int n, m;
        for (int TestCase = 1; TestCase <= T; ++TestCase) {
            n =sc.nextInt();;
            m =sc.nextInt();;

            int c1 =sc.nextInt();;
            int c2 =sc.nextInt();;
            int dx = Math.abs(c1 - c2);

            int cows[] = new int[n];
            for (int i = 0; i < n; i++) {
                cows[i] =sc.nextInt();;
            }
            Arrays.sort(cows);
            int min = Integer.MAX_VALUE;
            int cnt = 0;
            for (int i = 0; i < m; i++) {
                int horse =sc.nextInt();;
                int idx = BS(cows, horse);

                if (0 <= idx && idx < n) {
                    int z = Math.abs(cows[idx] - horse);
                    if (min > z) {
                        min = z;
                        cnt = 1;
                    } else if (min == z)
                        cnt++;
                }
                if (0 < idx && idx < n && cows[idx] != horse) {
                    int z = Math.abs(cows[idx - 1] - horse);
                    if (min > z) {
                        min = z;
                        cnt = 1;
                    } else if (min == z)
                        cnt++;
                }

            }

            sb.append("#").append(TestCase).append(" ").append(dx + min).append(" ").append(cnt).append("\n");
        }
        System.out.println(sb);
    }

    public static int BS(int[] arr, int val) {
        int l = 0;
        int r = arr.length - 1;
        int mid = (l + r) / 2;
        if (val < arr[l])
            return 0;
        if (val > arr[r])
            return r;

        while (l <= r) {
            mid = (l + r) / 2;

            if (arr[mid] == val)
                return mid;
            else if (arr[mid] < val)
                l = mid + 1;
            else
                r = mid - 1;
        }
        if (arr[mid] < val)
            mid++;

        return mid;
    }
}
