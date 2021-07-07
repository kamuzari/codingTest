package AL_CS_STUDY.Weekly28;
import java.util.*;
import java.io.*;
public class SequenceSummary2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int arr[]=new int[n];
        StringTokenizer st=new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }
        int answer=arr[0];
        int dp[][]=new int[n][2];
        dp[0][0]=dp[0][1]=arr[0];
        for (int i = 1; i < n; i++) {
            dp[i][0]=Math.max(dp[i-1][0]+arr[i],arr[i]);
            dp[i][1]=Math.max(dp[i-1][0],dp[i-1][1]+arr[i]);
            answer=Math.max(answer,Math.max(dp[i][0],dp[i][1]));
        }
        System.out.println(answer);
    }
}
