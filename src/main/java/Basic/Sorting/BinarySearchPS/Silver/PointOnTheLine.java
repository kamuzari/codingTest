package Basic.Sorting.BinarySearchPS.Silver;

import java.io.IOException;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PointOnTheLine {

    private static int n;
    private static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int arr[] = new int[n];
        st = new StringTokenizer(br.readLine());
        int max = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }
        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int startIdx, endIdx;
            startIdx = LowerBound(arr, a);
            endIdx = UpperBound(arr, b);

//            System.out.println(endIdx - startIdx);
            sb.append(endIdx - startIdx).append("\n");
        }
        System.out.println(sb);
    }

    private static int LowerBound(int[] arr, int target) {
        int s = 0;
        int e = n;
        while (s < e) {
            int mid = (s + e) / 2;
            if (arr[mid] < target) {
                s = mid + 1;
            } else
                e = mid;
        }
        return e;

    }

    private static int UpperBound(int[] arr, int target) {
        int s = 0;
        int e = n;
        while (s < e) {
            int mid = (s + e) / 2;
            if (arr[mid] <= target) {
                s = mid + 1;
            } else
                e = mid;
        }
        return e;

    }
}
/*
5 10
1 3 7 10 15 16 20 28 39 40
1 2
1 4
1 10
10 11
15 20
* */