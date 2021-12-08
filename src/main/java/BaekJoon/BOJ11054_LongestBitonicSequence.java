package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class BOJ11054_LongestBitonicSequence {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int numbers[] = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int longestIncreaseDp[] = longestIncreaseSequence(numbers);
        int reverseLongestIncreaseDp[] = ReverseLongestIncreaseSequence(numbers);

        int answer = 0;
        for (int i = 0; i < n; i++) {
            answer = Math.max(answer, longestIncreaseDp[i] + reverseLongestIncreaseDp[i]);
        }
        System.out.println(answer + 1);
    }

    private static int[] ReverseLongestIncreaseSequence(int[] numbers) {
        int length = numbers.length;
        int dp[] = new int[length];
        for (int current = length - 2; current >= 0; current--) {
            for (int previous = length - 1; previous > current; previous--) {
                if (numbers[current] > numbers[previous]) {
                    dp[current] = Math.max(dp[current], dp[previous] + 1);
                }
            }
        }
        return dp;
    }

    private static int[] longestIncreaseSequence(int[] numbers) {
        int length = numbers.length;
        int dp[] = new int[length];
        for (int current = 1; current < length; current++) {
            for (int previous = 0; previous < current; previous++) {
                if (numbers[current] > numbers[previous]) {
                    dp[current] = Math.max(dp[current], dp[previous] + 1);
                }
            }
        }
        return dp;
    }
}
