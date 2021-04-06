package thisCodingTest.Dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class makingOne {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int arr[]=new int[n+1];
        int dp[]=new int[n+1];
        d=new int[n+1];
        dp[1]=0;
        for (int i = 2; i < n+1; i++) {
            dp[i]=dp[i-1]+1;

            if(i%3==0)
            {
                dp[i]=Math.min(dp[i/3]+1,dp[i]);
            }
            if(i%2==0)
            {
                dp[i]=Math.min(dp[i/2]+1,dp[i]);
            }
        }
//        System.out.println(Arrays.toString(dp));

        System.out.println(dp[n]);
//        for (int i = 2; i <=n ; i++) {
//            d[i]=Integer.MAX_VALUE;
//        }
//        int ans=topDown(n);
//        System.out.println(ans);
    }
    static int d[];
    static int topDown(int n)
    {
        if(n==1)
            return 0;

        // memoization
        if(d[n]>0)
            return d[n];

        d[n]=topDown(n-1)+1;

        if(n%3==0)
        {
            d[n]=Math.min(d[n],topDown(n/3)+1);
        }
        if(n%2==0)
        {
            d[n]=Math.min(d[n],topDown(n/2)+1);
        }
        return d[n];
    }
}

