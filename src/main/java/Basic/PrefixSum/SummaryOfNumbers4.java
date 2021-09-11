package Basic.PrefixSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/2015
public class SummaryOfNumbers4 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 1];
        int[] dp = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <=n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i]=dp[i-1]+arr[i];
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        long answer =0;
        for (int i = 1; i <=n; i++) {
            answer+=map.getOrDefault(dp[i]-k,0);
            map.put(dp[i],map.getOrDefault(dp[i],0)+1);
        }

        System.out.println(answer);

    }
}
