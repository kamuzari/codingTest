package Basic.PrefixSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PianoGymnastics {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int difficulty[] = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n+1; i++) {
            difficulty[i] = Integer.parseInt(st.nextToken());
        }
        boolean mistake[]=new boolean[n+1];
        for (int i = 1; i <n ; i++) {
            if(difficulty[i]>difficulty[i+1]){
                mistake[i]=true;
            }
        }

        int dp[]=new int[n+1];
        for (int i = 1; i <n+1 ; i++) {
            int miss=0;
            if(mistake[i]){
                miss=1;
            }
            dp[i]=dp[i-1]+miss;
        }
        int query=Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < query; i++) {
            st=new StringTokenizer(br.readLine());
            int s=Integer.parseInt(st.nextToken());
            int e=Integer.parseInt(st.nextToken());
            sb.append(dp[e-1]-dp[s-1]).append("\n");
        }
        System.out.println(sb);
    }
}
