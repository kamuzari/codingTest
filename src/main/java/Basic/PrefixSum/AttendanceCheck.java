package Basic.PrefixSum;
import java.io.*;
import java.util.StringTokenizer;

public class AttendanceCheck {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());
        int q=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());

        int dp[]=new int[n+3];
        for (int i = 3; i < n + 3; i++) {
            dp[i]=i;
        }

        boolean sleep[]=new boolean[n+3];
        boolean check[]=new boolean[n+3];

        st=new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            sleep[Integer.parseInt(st.nextToken())]=true;
        }

        st=new StringTokenizer(br.readLine());
        for (int i = 0; i < q; i++) {
            int sentToStu=Integer.parseInt(st.nextToken());
            if(sleep[sentToStu]){
                continue;
            }
            int multipleStu=sentToStu;
            for (int j = multipleStu; j <n+3 ; j+=multipleStu) {
                if(sleep[j]) {
                    continue;
                }
                check[j]=true;
            }
        }

        for (int i = 3; i <n+3; i++) {
            int a;
            if(!check[i]){
                a=1;
            }else{
                a=0;
            }
            dp[i]=dp[i-1]+a;
        }

        StringBuffer sb=new StringBuffer();
        for (int i = 0; i < m; i++) {
            st=new StringTokenizer(br.readLine());
            int s=Integer.parseInt(st.nextToken());
            int e=Integer.parseInt(st.nextToken());
            sb.append(dp[e]-dp[s-1]).append("\n");
        }
        System.out.println(sb);
    }
}
