package tony;

import java.util.Scanner;
import java.util.StringTokenizer;

public class BridgeCrossing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long s = 0;
        long e = 10;
        long answer = Long.MAX_VALUE;
        while (s <= e) {
            long mid = (s + e) >> 1L;
            if (isGo(arr, mid)) {
                answer = Math.min(answer, mid);
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }

        System.out.println(answer);
    }

    private static boolean isGo(int[] arr, long limit) {
        boolean isGo = false;
        for (int i = 0; i < arr.length; i++) {
            long minPower = Long.MAX_VALUE;
            int nextIdx = 0;
            for (int j = i + 1; j < arr.length; j++) {
                long diffPower = (long) (j - i) * (1L + Math.abs(arr[i] - arr[j]));
                if (minPower <= diffPower) {
                    continue;
                }

                if (diffPower > limit) {
                    continue;
                }

                minPower = diffPower;
                nextIdx = j;
            }

            boolean isNotDecide = minPower == Long.MAX_VALUE;
            if (isNotDecide) {
                return false;
            } else if (nextIdx == arr.length - 1) {
                return true;
            } else {
                i = nextIdx - 1;
            }
        }

        return isGo;
    }
}
