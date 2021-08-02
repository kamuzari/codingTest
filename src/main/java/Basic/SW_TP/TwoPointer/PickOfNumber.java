package Basic.SW_TP.TwoPointer;
// https://www.acmicpc.net/problem/2230

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PickOfNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

//        int answer = TwoPointer(n, m, arr);
        int answer = BinarySearch(n, m, arr);
        System.out.println(answer);
    }

    private static int BinarySearch(int n, int m, int[] arr) {
        int s = 0, e = 0, mid = 0;
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            s = i;
            e = n;
            while (s < e) {
                mid = (s + e) / 2;
                if (arr[mid] - arr[i] == m)
                    return m;

                if (arr[mid] - arr[i] < m) {
                    s = mid + 1;
                } else if (arr[mid] - arr[i] > m) {
                    answer = Math.min(answer, arr[mid] - arr[i]);
                    e = mid;
                }
            }
        }
        return answer;

    }


    private static int TwoPointer(int n, int m, int[] arr) {
        int ptr1 = 0, ptr2 = 0;
        int len = n;
        int answer = Integer.MAX_VALUE;
        while (true) {
            if (ptr2 > len - 1)
                break;
            if (arr[ptr2] - arr[ptr1] > m) {
                answer = Math.min(answer, arr[ptr2] - arr[ptr1]);
                ptr1++;

            } else if (arr[ptr2] - arr[ptr1] == m) {
                return m;
            } else if (arr[ptr2] - arr[ptr1] < m) {
                ptr2++;
            }
        }
        return answer;
    }
}
