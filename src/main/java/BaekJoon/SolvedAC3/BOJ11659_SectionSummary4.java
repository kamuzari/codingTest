package BaekJoon.SolvedAC3;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ11659_SectionSummary4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int arr[] = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        int sum=0;
        for (int i = 1; i <= n; i++) {
            sum+=Integer.parseInt(st.nextToken());
            arr[i] = sum;
        }
        StringBuilder answers = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            answers.append(arr[b] - arr[a - 1]).append("\n");
        }
        System.out.println(answers);
    }
}
