package Basic.SW_TP.TwoPointer;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TwoNumberSummary {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int answer=0;
        int k = Integer.parseInt(br.readLine());
        answer=twoPointer(arr, n, k);
//         answer = bst(arr, n, k);
        System.out.println(answer);
    }

    private static int twoPointer(int[] arr, int n, int target) {
        Arrays.sort(arr);
        int s = 0, e = n - 1, sum = 0;
        int pairCount = 0;
        while (s < e) {
            sum = arr[s] + arr[e];

            if (sum == target)
                pairCount++;
            if (sum <= target)
                s++;
            else if(sum>target)
                e--;
        }
        return pairCount;
    }

    private static int bst(int[] arr, int n, int target) {
        Arrays.sort(arr);
        int pairCount = 0;
        for (int i = 0; i < n-1; i++) {
            int standard = arr[i];
            int s = i+1;
            int e = n - 1;
            int subTarget = target - standard;
            while (s <= e) {
                int mid = (s + e) >> 1;
                if (arr[mid] == subTarget) {
                    pairCount++;
                }
                if (arr[mid] >= subTarget) {
                    e = mid - 1;
                } else if (arr[mid] < subTarget) {
                    s = mid + 1;
                }
            }
        }
        return pairCount;
    }
}
