package tony;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SectionDivision2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        StringTokenizer st = new StringTokenizer(sc.nextLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(sc.nextLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int s = 0;
        int e = Arrays.stream(arr).max().getAsInt();
        int answer = Integer.MAX_VALUE;

        while (s <= e) {
            int mid = (s + e) >> 1;

            if (isPossible(mid, arr, m)) {
                answer = Math.min(answer, mid);
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }

        System.out.println(answer);
    }

    private static boolean isPossible(int condition, int[] arr, int limitInterval) {
        int intervalCount = 1;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
            if (max - min > condition) {
                intervalCount++;
                min = Integer.MAX_VALUE;
                max = Integer.MIN_VALUE;
                i--;
            }
        }

        return intervalCount <= limitInterval;
    }

}

