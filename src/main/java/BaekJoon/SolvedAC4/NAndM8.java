package BaekJoon.SolvedAC4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class NAndM8 {

    static int[] arr;
    static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        pick(0, m, new Stack<>());
        System.out.println(answer);
    }

    public static void pick(int cnt, int targetDepth, Stack<Integer> s) {
        if (cnt == targetDepth) {
            s.stream().collect(Collectors.toList())
                .forEach(idx -> answer.append(arr[idx] + " "));
            answer.append("\n");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (s.isEmpty() || s.peek().compareTo(i) <= 0) {
                s.push(i);
                pick(cnt + 1, targetDepth, s);
                s.pop();
            }

        }
    }

}
