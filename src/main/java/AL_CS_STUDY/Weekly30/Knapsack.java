package AL_CS_STUDY.Weekly30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Knapsack {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());
//        twoDimensionArray(br, n, k);
        oneDimensionArray(br, n, k);

    }

    private static void twoDimensionArray(BufferedReader br, int n, int k) throws IOException {
        StringTokenizer st;
        int dp[][]=new int[n +1][k +1];
        int pack[][]=new int[n +1][2];
        for (int i = 0; i < n; i++) {
            st=new StringTokenizer(br.readLine());
            pack[i+1][0]=Integer.parseInt(st.nextToken());
            pack[i+1][1]=Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < n +1; i++) {
            for (int j = 1; j < k +1; j++) {
                if(j-pack[i][0]>=0)
                {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-pack[i][0]]+pack[i][1]);
                }
            }
        }
        Arrays.stream(dp).forEach((int d[])-> System.out.println(Arrays.toString(d)));
    }
    private static void oneDimensionArray(BufferedReader br, int n, int k) throws IOException {
        StringTokenizer st;
        int dp[]=new int[k +1];
        int pack[][]=new int[n +1][2];
        for (int i = 0; i < n; i++) {
            st=new StringTokenizer(br.readLine());
            pack[i+1][0]=Integer.parseInt(st.nextToken());
            pack[i+1][1]=Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < n +1; i++) {
            for (int j = k; j > 0; j--) {
                if(j-pack[i][0]>=0)
                {
                    dp[j]=Math.max(dp[j],dp[j-pack[i][0]]+pack[i][1]);
                }
            }
        }
        Arrays.stream(dp).forEach(System.out::println);
    }
}
