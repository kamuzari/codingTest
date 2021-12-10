package BaekJoon.SolvedAC4.Standard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class BOJ12865_OrdinaryBackPack {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        //dp[ i번째 물품 ] [ j kg일 때 가치 ]

        int items[][] = new int[n + 1][2]; // [i][0] := 무게, [i][1] := 가치
        for (int i = 1; i <=n; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            items[i][0]=weight;
            items[i][1]=value;
        }
        int dp[][] = new int[n + 1][k + 1];
        for (int idxItem = 1; idxItem <= n; idxItem++) {
            for (int currentWeight = 1; currentWeight <= k; currentWeight++) {
                dp[idxItem][currentWeight] = dp[idxItem - 1][currentWeight];
                if (currentWeight - items[idxItem][0] >= 0) {
                    int previousItemIdx = idxItem - 1;
                    int restWeight = currentWeight - items[idxItem][0];
                    dp[idxItem][currentWeight] = Math.max(dp[previousItemIdx][currentWeight]
                            , dp[previousItemIdx][restWeight] + items[idxItem][1]);
                }
            }
        }
        System.out.println(dp[n][k]);
    }
}
