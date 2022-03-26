package BaekJoon.SolvedAC4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NAndM5 {

    static int[] arr;
    static int[] result;
    static int v = 0; // bit oper
    static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        result = new int[m];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        pick(0, m);
        System.out.println(answer);
    }

    static void pick(int cnt, int targetDepth) {
        if (targetDepth == cnt) {
            Arrays.stream(result).forEach(i -> answer.append(i + " "));
            answer.append("\n");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if ((v & (1 << i)) == 0) {
                v |= (1 << i);
                result[cnt] = arr[i];
                pick(cnt + 1, targetDepth);
                v ^= (1 << i);
            }
        }
    }
}
