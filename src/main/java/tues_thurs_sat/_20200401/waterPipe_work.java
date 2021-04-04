package tues_thurs_sat._20200401;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class waterPipe_work {
//dp[순서][길이]=용량;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int d=Integer.parseInt(st.nextToken());
        int p=Integer.parseInt(st.nextToken());
        int arr[][]=new int[p+1][2];
        for (int i = 1; i <p+1; i++) {
            st=new StringTokenizer(br.readLine());
            arr[i][0]=Integer.parseInt(st.nextToken()); // 길이
            arr[i][1]=Integer.parseInt(st.nextToken()); // 용량
        }
        // 길이가 ==d 이고 용량이 큰거.
//        Arrays.sort(arr,(o1, o2) -> {
//            if(o1[0]==o2[0])
//                return o1[1]-o2[1];
//            return o1[0]-o2[0];
//        });
        int dp[][]=new int[p+1][d+1];
        for (int i = 0; i < p; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
        for (int i = 0; i < d+1; i++) {
            if(i-arr[1][0]>=0)
            {
                dp[1][i]=arr[1][1];
            }
        }for (int i = 0; i <=p; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        System.out.println();
        for (int i = 2; i < p+1; i++) {
            for (int j = 1; j <d+1 ; j++) {
                dp[i][j]=dp[i-1][j];
                if(j-arr[i][0]>=0)
                {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-arr[i][0]]+arr[i][1]);
                }
            }
        }
        for (int i = 0; i <=p; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        System.out.println(dp[p][d]);

    }


}
