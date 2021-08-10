package Basic.Sorting.BinarySearchPS.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Budget {

    private static int totalBudget;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int sum = 0;
        int max = 0;
        for (int i = 0; i < N; i++) {
            sum += arr[i];
            max = Math.max(max, arr[i]);
        }
        int M = Integer.parseInt(br.readLine());
        totalBudget = M;

        if (sum <= M) {
            System.out.println(max);
        } else {
            binarySearch(N, arr, max);
        }
    }

    private static void binarySearch(int n, int[] arr, int max) {
        int s = 0;
        int e = max;
        int budgetMaxMoney=0;
        while (s <= e) {
            int mid = (s + e) / 2;
            boolean isDivideMoney = divide(n, arr, mid);

            if(isDivideMoney)
            {
                budgetMaxMoney=Math.max(budgetMaxMoney,mid);
                s=mid+1;
            }
            else
            {
                e=mid-1;
            }
        }
        System.out.println(budgetMaxMoney);
    }

    private static boolean divide(int n, int[] arr, int midMoney) {
        int sum=0;
        for (int value : arr) {
            if(value<=midMoney)
            {
                sum+=value;
            }
            else
            {
                sum+=midMoney;
            }
        }
        if(sum<=totalBudget)
            return true;
        else
            return false;
    }
}
