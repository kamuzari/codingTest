package thisCodingTest.Dynamic.PS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class retire {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int t[]=new int[n];
        int p[]=new int[n];
        int dp[]=new int[n+1];

        for (int i = 0; i <n ; i++) {
            StringTokenizer st=new StringTokenizer(br.readLine());
            t[i]=Integer.parseInt(st.nextToken());
            p[i]=Integer.parseInt(st.nextToken());
        }
        int maxVal=0;
        for (int i = n-1; i >-1 ; i--) {
            int time=t[i]+i;
            if(time<=n)
            {
                dp[i]=Math.max(maxVal,dp[time]+p[i]);
                maxVal=Math.max(dp[i],maxVal);
            }
            else
                dp[i]=maxVal;
        }
        System.out.println(maxVal);
    }
}
