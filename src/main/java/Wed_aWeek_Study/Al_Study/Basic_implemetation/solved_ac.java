package Wed_aWeek_Study.Al_Study.Basic_implemetation;

import java.io.*;
import java.util.*;

public class solved_ac {
    static final float jeulsaAvg = (float) 0.15;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (Integer.parseInt(br.readLine()));
        }
        Arrays.sort(arr); // 오름파순 정렬.
        int d = solvedAc(n, arr);
        bw.write(d + " ");
        bw.flush();
        bw.close();
        br.close();
    }

    static int solvedAc(int n, int[] arr) {
        int x = (int) Math.round(n * jeulsaAvg);
        int sum = 0;
        for (int i = x; i < arr.length - x; i++) {
            sum += arr[i];
        }
        double ans = Math.round((double) sum / (n - x * 2));
        return (int) ans;
    }
}
