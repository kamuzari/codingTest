package Basic.Sorting.BinarySearchPS.Silver;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TwoSolution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

//        int[] answers = twoPointer(arr, n);
//        System.out.println(answers[0]+" "+answers[1]);
        int[] answers = binarySearch(arr, n);
        System.out.println(answers[0]+" "+answers[1]);

    }

    private static int[] twoPointer(int[] arr, int n) {
        Arrays.sort(arr);
        int one = 0, two = 0;

        int l = 0;
        int r = n - 1;
        int minGap = Integer.MAX_VALUE;
        while (l < r) {
            int sum = arr[l] + arr[r];
            int abs = Math.abs(sum);
            if (abs < minGap) {
                minGap = abs;
                one = arr[l];
                two = arr[r];
            }
            if (sum < 0) {
                l++;
            } else if (sum == 0) {
                break;
            } else if (sum > 0) {
                r--;
            }
        }
        return new int[]{one, two};
    }

    private static int[] binarySearch(int[] arr, int n) {
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        int answer[] = new int[2];
        exit:
        for (int i = 0; i < n - 1; i++) {
            int s = i+1;
            int e = n - 1;
            while (s <= e) {
                int mid = (s + e) / 2;
                int sum = arr[i] + arr[mid];
                if (sum == 0) {
                    answer[0] = arr[i];
                    answer[1] = arr[mid];
                    break exit;
                } else if (sum < 0) {
                    s = mid + 1;
                } else if (sum > 0) {
                    e = mid - 1;
                }
                int abs = Math.abs(sum);
                if (min > abs) {
                    answer[0] = arr[i];
                    answer[1] = arr[mid];
                    min = abs;
                }
            }
        }
        return answer;
    }
}
